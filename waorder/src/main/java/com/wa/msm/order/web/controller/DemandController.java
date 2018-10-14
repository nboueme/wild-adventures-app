package com.wa.msm.order.web.controller;

import com.wa.msm.order.entity.Order;
import com.wa.msm.order.entity.OrderDemand;
import com.wa.msm.order.entity.OrderSession;
import com.wa.msm.order.proxy.MSUserAccountProxy;
import com.wa.msm.order.repository.OrderDemandRepository;
import com.wa.msm.order.repository.OrderDemandSessionRepository;
import com.wa.msm.order.repository.OrderRepository;
import com.wa.msm.order.repository.OrderSessionRepository;
import com.wa.msm.order.util.enumeration.OrderDemandEnum;
import com.wa.msm.order.util.enumeration.OrderStatusEnum;
import com.wa.msm.order.web.exception.OrderDemandNotFoundException;
import com.wa.msm.order.web.exception.OrderDemandValidationException;
import com.wa.msm.order.web.exception.OrderNotFoundException;
import com.wa.msm.order.web.exception.UserAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DemandController {

    @Autowired
    private OrderDemandRepository orderDemandRepository;

    @Autowired
    private OrderDemandSessionRepository orderDemandSessionRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderSessionRepository orderSessionRepository;

    @Autowired
    private MSUserAccountProxy msUserAccountProxy;

    @GetMapping("/demand/{demandId}")
    public Optional<OrderDemand> getOrderDemand(@PathVariable Long demandId){
        Optional<OrderDemand> orderDemand = orderDemandRepository.findById(demandId);
        if(!orderDemand.isPresent()) throw new OrderDemandNotFoundException("La demande n'a pas été trouvée");
        return orderDemand;
    }

    @GetMapping("/demands")
    public List<OrderDemand> getAllDemands(){
        List<OrderDemand> orderDemands = orderDemandRepository.findAll();
        if(orderDemands == null || orderDemands.isEmpty()) throw new OrderDemandNotFoundException("Il n'existe actuellement aucune demande");
        return orderDemands;
    }

    @GetMapping("/demands/user/{userId}")
    public List<OrderDemand> getAllDemandsByUser(@PathVariable Long userId){
        if(!msUserAccountProxy.getUserById(userId).isPresent()) throw new UserAccountNotFoundException("L'utilisateur d'id "+userId+"n'existe pas");
        List<OrderDemand> orderDemands = orderDemandRepository.findByUserAccountId(userId);
        if(orderDemands == null || orderDemands.isEmpty()) throw new OrderDemandNotFoundException("Il n'existe actuellement aucune demande correspondant à cet utilisateur");
        return orderDemands;
    }

    @GetMapping("/demands/status/{status}")
    public List<OrderDemand> getAllDemandsByStatus(@PathVariable OrderDemandEnum status){
        List<OrderDemand> orderDemands = orderDemandRepository.findByDemandStatus(status);
        if(orderDemands == null || orderDemands.isEmpty()) throw new OrderDemandNotFoundException("Il n'existe actuellement aucune demande correspondant à ce statut");
        return orderDemands;
    }

    @PostMapping("/demand")
    public ResponseEntity<OrderDemand> createDemand(@RequestBody OrderDemand orderDemand){
        validateOrderDemand(orderDemand);
        if(orderDemand.getId()!= null) throw new OrderDemandValidationException("La demande a déjà été enregistrée");

        final OrderDemand orderDemandSaved = orderDemandRepository.save(orderDemand);
        //TODO tester si les sessions existent
        orderDemandSaved.getOrderDemandSessions().iterator().forEachRemaining(orderDemandSession -> {
            orderDemandSession.setDemandId(orderDemandSaved.getId());
            orderDemandSessionRepository.save(orderDemandSession);
        });

        return new ResponseEntity<OrderDemand>(orderDemand, HttpStatus.CREATED);
    }

    @PatchMapping("/demand")
    public OrderDemand updateDemand(@RequestBody OrderDemand orderDemand){
        validateOrderDemand(orderDemand);
        if(orderDemand.getId() == null || !orderDemandRepository.findById(orderDemand.getId()).isPresent()) throw new OrderDemandNotFoundException("La demande fournie n'existe pas");
        //TODO tester si les sessions existent
        return orderDemandRepository.save(orderDemand);
    }

    @PatchMapping("/demand/validate/update")
    public OrderDemand validateUpdateDemand(@RequestBody OrderDemand orderDemand){
        validateOrderDemand(orderDemand);
        if(orderDemand.getId() == null || !orderDemandRepository.findById(orderDemand.getId()).isPresent()) throw new OrderDemandNotFoundException("La demande fournie n'existe pas");
        //TODO tester si les sessions existent
        if(!orderDemand.getStatus().equals(OrderStatusEnum.UPDATE_DEMAND)) throw new OrderDemandValidationException("Le statut de la demande est incorrect");
        populateOrderWithDemandUpdate(orderDemand);
        orderDemand.setDemandStatus(OrderDemandEnum.VALIDATED_DEMAND);
        return orderDemandRepository.save(orderDemand);
    }

    @PatchMapping("/demand/validate/delete")
    public OrderDemand validateDeleteDemand(@RequestBody OrderDemand orderDemand){
        validateOrderDemand(orderDemand);
        if(orderDemand.getId() == null || !orderDemandRepository.findById(orderDemand.getId()).isPresent()) throw new OrderDemandNotFoundException("La demande fournie n'existe pas");
        //TODO tester si les sessions existent
        if(!orderDemand.getStatus().equals(OrderStatusEnum.DELETE_DEMAND)) throw new OrderDemandValidationException("Le statut de la demande est incorrect");
        orderDemand.getOrder().setStatus(OrderStatusEnum.CANCELED);
        orderDemand.setDemandStatus(OrderDemandEnum.VALIDATED_DEMAND);
        return orderDemandRepository.save(orderDemand);
    }

    @DeleteMapping("/demand/{demandId}")
    public String deleteOrderDemand(@PathVariable Long demandId){
        Optional<OrderDemand> orderDemand = orderDemandRepository.findById(demandId);
        if(!orderDemand.isPresent()) throw new OrderDemandNotFoundException("La demande n'a pu être trouvé");
        orderDemandRepository.deleteById(demandId);
        return "La demande d'id : "+ demandId + " a bien été supprimée";
    }

    private void validateOrderDemand(OrderDemand orderDemand){
        if(orderDemand == null) throw new OrderDemandValidationException("La demande fournie  est nulle");
        if(orderDemand.getOrder() == null) throw new OrderDemandValidationException("La demande n'est lié à aucune commande");
        if(!orderRepository.findById(orderDemand.getOrder().getId()).isPresent()) throw new OrderNotFoundException("La commande d'id "+ orderDemand.getOrder().getId() +" n'existe pas");
        if(!msUserAccountProxy.getUserById(orderDemand.getUserAccountId()).isPresent()) throw new UserAccountNotFoundException("L'utilisateur lié à cette demande n'existe pas ");
        if(orderDemand.getOrderDemandSessions().isEmpty()) throw new OrderDemandValidationException("La commande liée à cette demande n'est liée à aucune Session");
    }

    private void populateOrderWithDemandUpdate(OrderDemand orderDemand){

        orderDemand.getOrder().setIsPaid(orderDemand.getIsPaid());

        if(orderDemand.getOrder().getIsPaid()){
            orderDemand.getOrder().setStatus(OrderStatusEnum.FINALIZED);
        }else{
            orderDemand.getOrder().setStatus(OrderStatusEnum.NOT_PAID);
        }

        if(orderDemand.getStatus().equals(OrderStatusEnum.UPDATE_DEMAND)){
            orderSessionRepository.deleteAll(orderDemand.getOrder().getOrderSessions());
        }
        List<OrderSession> orderSessions = new ArrayList<>(0);
        orderDemand.getOrderDemandSessions().iterator().forEachRemaining(orderDemandSession -> {
            OrderSession orderSession = new OrderSession(orderDemand.getOrder(),orderDemand.getOrder().getId(), orderDemandSession.getSessionId());
            orderSessions.add(orderSession);
        });
        orderDemand.getOrder().setOrderSessions(orderSessions);

        orderDemand.getOrder().setUserAccountId(orderDemand.getUserAccountId());
        orderDemand.getOrder().setOrderDate(orderDemand.getOrderDate());
    }
}
