import React from 'react'
import { Link } from 'react-router-dom'
import { Card, Col } from 'antd'
import { URI } from '../../helpers/constants'

const { Meta } = Card

const imageStyle = {
  height: '200px',
}

const CategoryItem = ({ index, imagePath, title, description }) => (
  <Col sm={12} lg={8}>
    <Link to={`${URI.CATEGORIES}/${index}`}>
      <Card
        hoverable
        cover={<img style={imageStyle} alt="example" src={imagePath} />}
      >
        <Meta title={title} description={description} />
      </Card>
    </Link>
  </Col>
)

export default CategoryItem
