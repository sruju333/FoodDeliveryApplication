import React, {useEffect} from 'react' 
import {Link, useParams, useNavigate, useLocation} from 'react-router-dom'
import {Row, Col, Button, Image, Form, Card, ListGroup} from 'react-bootstrap'
import {useDispatch, useSelector} from 'react-redux'
import { addToCart } from '../actions/cartActions'
import Message  from '../components/Message'

const CartScreen = () => {
    const params = useParams()
    const location = useLocation()
    const productId = params.id
    const qty = location.search ? Number(location.search.split('=')[1]) : 1

    const dispatch = useDispatch()

    const cart = useSelector(state => state.cart)
    const {cartItems} = cart
    const a = [1,2,3,4,5,6,7,8,9]

    useEffect(() => {
        if (productId){
            dispatch(addToCart(productId, qty))
        }
    },[dispatch, productId, qty])

    const removeFromCartHandler = (id) => {
        console.log('Remove')
    }

  return (
    <Row>
        
        <Col md={8}>
            <h1>Cart</h1>
            {cartItems.length === 0 ? <Message>Your cart is empty<Link to='/'>Go Back</Link></Message> : <ListGroup variant='flush'>
                {cartItems.map(item => (
                        <ListGroup.Item key={item.product}>
                                <Row>
                                    <Col md={2}>
                                        <Image src={item.image} alt={item.name} fluid rounded />
                                    </Col>
                                    <Col md={3}>
                                        {item.name}
                                    </Col>
                                    <Col md={2}>
                                        ${item.price}
                                    </Col>
                                    <Col md={3}>
                                        <Form.Control as='select' value={item.qty} onChange={(e) => dispatch(addToCart(item.product, Number(e.target.value)))}>
                                        {a.map((x) => (<option key={x} value={x}>
                                                {x}
                                            </option>))}
                                        </Form.Control>
                                    </Col>
                                    <Col md={2}>
                                        <Button type='button' variant='light' onClick={() => removeFromCartHandler(item.product)}>
                                            <i className='fas fa-trash'></i>
                                        </Button>
                                    </Col>
                                </Row>
                        </ListGroup.Item>
                    ))}
                </ListGroup>}
        </Col>
        <Col md={2}></Col>
        <Col md={2}></Col>
    </Row>
  )
}

export default CartScreen