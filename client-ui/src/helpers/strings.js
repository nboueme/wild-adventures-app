import LocalizedStrings from 'react-localization'

export const languagesList = {
  en: 'English',
  fr: 'Français',
}

export let strings = new LocalizedStrings({
  en: {
    routes: {
      wildAdventures: 'Wild Adventures',
      categories: 'Categories',
      adventures: 'Adventures',
      account: 'Account',
      register: 'Register',
      logout: 'Logout',
      login: 'Login',
      home: 'Home',
      notMatch: 'This page does not exist.',
    },
    home: {
      welcomeText:
        'Wild Aventures wish you welcome, find the categories of adventures in the spotlight as well as our most popular adventures.',
      adventureTitle: 'Adventures in the spotlight',
      categoryTitle: 'Categories in the spotlight',
    },
    adventures: {
      location: 'Location',
      categoriesListAdventure: 'Categories list of the adventure',
    },
    categories: {
      categoriesList: 'Categories list',
      goAdventure: 'Go on an adventure',
      adventuresList: 'Adventures list',
    },
    comments: {
      commentsList: 'Comments',
      said: 'said',
      reply: 'Reply',
      cancel: 'Cancel',
      send: 'Send',
      form: {
        contentMessageRule: 'Thank you to enter a comment.',
        contentPlaceholder: 'Write your comment here',
      },
    },
    user: {
      rememberMe: 'Remember me',
      forgotPassword: 'Forgot password',
      logIn: 'Log in',
      or: 'Or',
      registerNow: 'register now!',
      register: 'Register',
      upload: 'Upload',
      send: 'Send',
      deactivateAccount: 'Deactivate my account',
      form: {
        emailLabel: 'E-mail',
        usernameValidEmail: 'The input is not valid e-mail!',
        usernameMessageRule: 'Please input your e-mail!',
        usernamePlaceholder: 'E-mail',
        currentEmailLabel: 'Current e-mail',
        newEmailLabel: 'New e-mail',
        passwordLabel: 'Password',
        currentPasswordLabel: 'Current password',
        passwordMessageRule: 'Please input your password!',
        passwordPlaceholder: 'Password',
        confirmPasswordLabel: 'Confirm password',
        confirmPasswordMessageRule: 'Please confirm your password!',
        newPasswordLabel: 'New password',
        newPasswordMessageRule: 'Please input your new password!',
        confirmNewPasswordLabel: 'Confirm new password',
        confirmNewPasswordMessageRule: 'Please confirm your new password!',
        compareToFirstPassword: 'Two passwords that you enter is inconsistent!',
        avatarLabel: 'Avatar',
        pseudoLabel: 'Pseudo',
        newPseudoLabel: 'New pseudo',
        currentPseudoLabel: 'Current pseudo',
        pseudoTooltipTitle: 'What do you want others to call you?',
        pseudoMessageRule: 'Please input your nickname!',
        firstnameLabel: 'Firstname',
        firstnameMessageRule: 'Please input your firstname!',
        lastnameLabel: 'Lastname',
        lastnameMessageRule: 'Please input your lastname!',
        addressLabel: 'Address',
        addressMessageRule: 'Please input your address!',
        postalCodeLabel: 'Postal code',
        postalCodeMessageRule: 'Please input your postal code!',
        cityLabel: 'City',
        cityMessageRule: 'Please input your city!',
        countryLabel: 'Country',
        countryMessageRule: 'Please input your country!',
        phoneNumberLabel: 'Phone number',
        phoneNumberMessageRule: 'Please input your phone number!',
        birthDateLabel: 'Birth date',
        birthDateMessageRule: 'Please input your birth date!',
        birthDatePlaceholder: 'Select date',
        birthDateFormat: 'DD/MM/YYYY',
      },
    },
    statusCode: {
      wrongCredentials: 'Wrong credentials.',
      serverNotFound: 'Problems accessing the server. Please, try again later.',
    },
  },
  fr: {
    routes: {
      wildAdventures: 'Wild Adventures',
      categories: 'Catégories',
      adventures: 'Aventures',
      account: 'Compte',
      register: 'Inscription',
      logout: 'Déconnexion',
      login: 'Connexion',
      home: 'Accueil',
      notMatch: "Cette page n'existe pas.",
    },
    home: {
      welcomeText:
        "Wild Aventures vous souhaite la bienvenue, retrouvez les catégories d'aventures à l'honneur ainsi que nos aventures les plus populaires.",
      adventureTitle: "Les aventures à l'honneur",
      categoryTitle: "Les catégories à l'honneur",
    },
    adventures: {
      location: 'Localisation',
      categoriesListAdventure: "Liste des catégories de l'aventure",
    },
    categories: {
      categoriesList: 'Liste des catégories',
      goAdventure: "Partez à l'aventure",
      adventuresList: 'Liste des aventures',
    },
    comments: {
      commentsList: 'Commentaires',
      said: 'a dit',
      reply: 'Répondre',
      cancel: 'Annuler',
      send: 'Envoyer',
      form: {
        contentMessageRule: 'Merci de rentrer un commentaire.',
        contentPlaceholder: 'Écrivez votre commentaire ici',
      },
    },
    user: {
      rememberMe: 'Se rappeler de moi',
      forgotPassword: 'Mot de passe oublié',
      logIn: 'Se connecter',
      or: 'Ou',
      registerNow: 'se créer un compte !',
      register: "S'inscrire",
      upload: 'Uploader',
      send: 'Envoyer',
      deactivateAccount: 'Désactiver mon compte',
      form: {
        emailLabel: 'Email',
        usernameValidEmail: "Ce n'est pas un email valide !",
        usernameMessageRule: 'Merci de renseigner votre email !',
        usernamePlaceholder: 'Email',
        currentEmailLabel: 'Adresse email actuelle',
        newEmailLabel: 'Nouvelle adresse email',
        passwordLabel: 'Mot de passe',
        currentPasswordLabel: 'Mot de passe actuel',
        passwordMessageRule: 'Merci de renseigner votre mot de passe !',
        passwordPlaceholder: 'Mot de passe',
        confirmPasswordLabel: 'Confirmation du mot de passe',
        confirmPasswordMessageRule: 'Merci de confirmer votre mot de passe !',
        newPasswordLabel: 'Nouveau mot de passe',
        newPasswordMessageRule:
          'Merci de renseigner votre nouveau mot de passe !',
        confirmNewPasswordLabel: 'Confirmation',
        confirmNewPasswordMessageRule:
          'Merci de confirmer votre nouveau mot de passe !',
        compareToFirstPassword: 'Les deux mots de passe ne correspondent pas !',
        avatarLabel: 'Avatar',
        pseudoLabel: 'Pseudo',
        newPseudoLabel: 'Nouveau pseudo',
        currentPseudoLabel: 'Pseudo actuel',
        pseudoTooltipTitle: 'Comment souhaitez-vous être appelé ?',
        pseudoMessageRule: 'Merci de renseigner votre pseudo !',
        firstnameLabel: 'Prénom',
        firstnameMessageRule: 'Merci de renseigner votre prénom !',
        lastnameLabel: 'Nom',
        lastnameMessageRule: 'Merci de renseigner votre nom !',
        addressLabel: 'Adresse',
        addressMessageRule: 'Merci de renseigner votre adresse !',
        postalCodeLabel: 'Code postal',
        postalCodeMessageRule: 'Merci de renseigner votre code postal !',
        cityLabel: 'Ville',
        cityMessageRule: 'Merci de renseigner votre ville !',
        countryLabel: 'Pays',
        countryMessageRule: 'Merci de renseigner votre pays !',
        phoneNumberLabel: 'Numéro de téléphone',
        phoneNumberMessageRule:
          'Merci de renseigner votre numéro de téléphone !',
        birthDateLabel: 'Date de naissance',
        birthDateMessageRule: 'Merci de renseigner votre date de naissance !',
        birthDatePlaceholder: 'Sélectionner une date',
        birthDateFormat: 'DD/MM/YYYY',
      },
    },
    statusCode: {
      wrongCredentials: 'Identifiants invalides.',
      serverNotFound:
        "Problèmes d'accès au serveur. Merci de réessayer plus tard.",
    },
  },
})
