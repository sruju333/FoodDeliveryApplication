import React from 'react'
import {Card, ListGroup, Button} from 'react-bootstrap'
import Rating from './Rating'
import Category from './Category'

const Food = ({food}) => {
  return (
    <Card className='my-3 p-3 rounded'>
            <Card.Img src={food.image} variant='top' />


        <Card.Body>
            <Card.Title as='div'><strong>{food.name}</strong></Card.Title>

        <Card.Text as='div'>
            <Rating value={food.rating} />
        </Card.Text>

        <Card.Text as='h3'>${food.price}</Card.Text>

        <Card.Text as='div'>
            <Category text={food.category} color={food.category==='Veg' ? 'green' : 'red'}/>
        </Card.Text>
        <ListGroup variant='flush'>
            <ListGroup.Item>
                <Button className='btn-block' type='button'>
                    Add To Cart
                </Button>
            </ListGroup.Item>
        </ListGroup>
        </Card.Body>
        
    </Card>
  )
}

export default Food