import React, { useEffect} from 'react'
import {useDispatch, useSelector} from 'react-redux'
import { Row, Col } from 'react-bootstrap'
import Restaurant from '../components/Restaurant'
import {listRestaurants} from '../actions/restaurantActions'
import Message from '../components/Message'
import Loader from '../components/Loader'

const HomeScreen = () => {
  const dispatch = useDispatch()

  const restaurantList = useSelector(state => state.restaurantList)
  const {loading, error, restaurants} = restaurantList

  useEffect(() => {
    dispatch(listRestaurants())
  }, [dispatch])

  return (
    <>
    <h2>Available Restaurants</h2>
    {loading ? <Loader /> : error ? <Message variant='danger'>{error}</Message> : 
        <Row>
            {restaurants.map((restaurant) => (
                <Col key={restaurant._id} sm={12} md={6} lg={4} xl={3}>
                    <Restaurant restaurant={restaurant}/>
                </Col>
            ))}
        </Row> }
    
    </>
  )
}

export default HomeScreen