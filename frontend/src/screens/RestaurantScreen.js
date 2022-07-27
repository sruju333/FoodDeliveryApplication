import React, { useEffect} from 'react'
import {Link,useParams} from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import { Row, Col } from 'react-bootstrap'
import Food from '../components/Food'
import {listFoods} from '../actions/foodActions'
import Message from '../components/Message'
import Loader from '../components/Loader'

const RestaurantScreen = () => {
  
  const dispatch = useDispatch()

  const foodList = useSelector(state => state.foodList)
  const {loading, error, foods} = foodList

  const params = useParams()

  useEffect(()=>{
    dispatch(listFoods(params.id))
  },[dispatch]) 
  
  return (
    <>
      <h2>Available Foods</h2>
      <Link className='btn btn-dark my-3' to='/'>Go Back</Link>
      {loading ? <Loader /> : error ? <Message variant='danger'>{error}</Message> : 
      <Row>
            {foods.map((food) => (
              <Col sm={12} md={6} lg={4} xl={3}>
                  <Food food={food}/>
                </Col>
            ))}
        </Row>}
    </>
  )
}

export default RestaurantScreen