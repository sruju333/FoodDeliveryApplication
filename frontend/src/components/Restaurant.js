import React from 'react'
import {Card} from 'react-bootstrap'
import Rating from './Rating'
import {Link} from 'react-router-dom'

const Restaurant = ({restaurant}) => {
  return (
    <Card className='my-3 p-3 rounded'>
        <Link to={`/restaurant/${restaurant.id}`}>
            <Card.Img src={restaurant.restaurantImage} variant='top' />
        </Link>

        <Card.Body>
        <Link to={`/restaurant/${restaurant.id}`}>
            <Card.Title as='div'><strong>{restaurant.restaurantName}</strong></Card.Title>
        </Link>

        <Card.Title as='div'>{restaurant.restaurantAddress}</Card.Title>

        <Card.Text as='div'>
            <Rating value={4}/>
        </Card.Text>
        </Card.Body>
    </Card>
  )
}

export default Restaurant