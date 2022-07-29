import React, { useEffect, useState } from 'react'
import { Link, useParams, useNavigate} from 'react-router-dom'
import { Row, Col, ListGroup, Image, Card, Button } from 'react-bootstrap'
import { useDispatch, useSelector } from 'react-redux'
import Message from '../components/Message'
import Loader from '../components/Loader'
import { getOrderDetails, payOrder } from '../actions/orderActions'
import {ORDER_PAY_RESET} from '../constants/orderConstants'


const OrderScreen = () => {
    const params = useParams()
    const navigate = useNavigate()
    const orderId = params.id

  const dispatch = useDispatch()

  const orderDetails = useSelector((state) => state.orderDetails)
  const { order, loading, error } = orderDetails

  const userLogin = useSelector((state) => state.userLogin)
  const { userInfo } = userLogin

  const orderPay = useSelector((state) => state.orderPay)
  const { loading: loadingPay, success: successPay } = orderPay

  // const orderDeliver = useSelector((state) => state.orderDeliver)
  // const { loading: loadingDeliver, success: successDeliver } = orderDeliver

  if(!loading) {
      //   Calculate prices
  const addDecimals = (num) => {
    return (Math.round(num * 100) / 100).toFixed(2)
  }

  order.itemsPrice = addDecimals(
    order.orderItems.reduce((acc, item) => acc + item.price * item.qty, 0)
  )
  }

  useEffect(() => {
    if (!userInfo) {
      navigate('/login')
    }

    if (!order || order._id !== orderId){
      //dispatch({ type: ORDER_PAY_RESET })
      // dispatch({ type: ORDER_DELIVER_RESET })

      dispatch(getOrderDetails(orderId, order.resId, order.userId))
    }
  }, [dispatch, order, orderId, userInfo, successPay])

  const successPaymentHandler = (paymentResult) => {
    dispatch(payOrder(orderId, paymentResult))
  }
  
  return loading ? <Loader /> : error ? <Message variant='danger'>{error}</Message> : <>
    <h1>Order {order._id}</h1>
    <Row>
        <Col md={8}>
          <ListGroup variant='flush'>
            <ListGroup.Item>
              <h2>Shipping</h2>
              <p><strong>Name: </strong> {order.userId}</p>
              <p>
                <strong>Address:</strong>
                {order.deliveryAddress}
              </p>
              {order.orderStatus==='DELIVERED' ? (<Message variant='success'>Delivered</Message> ):(
              <Message variant='danger'>Not Delivered</Message>)}
            </ListGroup.Item>

            <ListGroup.Item>
              <h2>Payment Method</h2>
              <p>
              <strong>UPI </strong>
              </p>
              {order.paymentStatus=='1' ? (<Message variant='success'>Paid</Message> ):(
              <Message variant='danger'>Not Paid</Message>)}
            </ListGroup.Item>

            <ListGroup.Item>
              <h2>Order Items</h2>
              {order.orderItems.length === 0 ? (
                <Message>Order is empty</Message>
              ) : (
                <ListGroup variant='flush'>
                  {order.orderItems.map((item, index) => (
                    <ListGroup.Item key={index}>
                      <Row>
                        <Col md={1}>
                          <Image
                            src={item.image}
                            alt={item.name}
                            fluid
                            rounded
                          />
                        </Col>
                        <Col>
                          <Link to={`/product/${item.product}`}>
                            {item.name}
                          </Link>
                        </Col>
                        <Col md={4}>
                          {item.qty} x ${item.price} = ${item.qty * item.price}
                        </Col>
                      </Row>
                    </ListGroup.Item>
                  ))}
                </ListGroup>
              )}
            </ListGroup.Item>
          </ListGroup>
        </Col>
        <Col md={4}>
          <Card>
            <ListGroup variant='flush'>
              <ListGroup.Item>
                <h2>Order Summary</h2>
              </ListGroup.Item>
              
              <ListGroup.Item>
                <Row>
                  <Col>Total</Col>
                  <Col>${order.price}</Col>
                </Row>
              </ListGroup.Item>
              {order.orderStatus!=='PAID' && (
                <ListGroup.Item>
                  {loadingPay ? <Loader /> : <Button type='button' variant='primary' onClick={successPaymentHandler}>Pay</Button>}
                </ListGroup.Item>
              )}
            </ListGroup>
          </Card>
        </Col>
      </Row>
  </>
}

export default OrderScreen