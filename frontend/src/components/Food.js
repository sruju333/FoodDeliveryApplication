import React, { useState} from 'react'
import {useParams, useNavigate} from 'react-router-dom'
import {Card, ListGroup, Button, Form, Row, Col} from 'react-bootstrap'
import Rating from './Rating'
import Category from './Category'

const Food = ({food}) => {
    const [qty, setQty] = useState(1)
    const a = [1,2,3,4,5,6,7,8,9]

    const params = useParams()
    const navigate = useNavigate()

    const addToCartHandler = () => {
        navigate(`/cart/${food._id}?qty=${qty}`)
    }
    

  return (
    <Card className='my-3 p-3 rounded'>
            <Card.Img src={food.image} variant='top' />


        <Card.Body>
            <Card.Title as='div'><strong>{food.name}</strong></Card.Title>

        <Card.Text as='div'>
            <Rating value={food.rating} />
        </Card.Text>

        <Card.Text as='div'>${food.price}</Card.Text>

        <Card.Text as='div'>
            <Category text={food.category} color={food.category==='Veg' ? 'green' : 'red'}/>
        </Card.Text>
        <ListGroup variant='flush'>
            <ListGroup.Item>
                <Row>
                    <Col>Qty</Col>
                    <Col>
                        <Form.Control as='select' value={qty} onChange={(e) => setQty(e.target.value)}>
                            {a.map((x) => (<option key={x} value={x}>
                                {x}
                            </option>))}
                        </Form.Control>
                    </Col>
                </Row>
            </ListGroup.Item>
            <ListGroup.Item>
                <Button onClick={addToCartHandler}  className='btn-block' type='button'>
                    Add To Cart
                </Button>
            </ListGroup.Item>
        </ListGroup>
        </Card.Body>
        
    </Card>
  )
}

export default Food