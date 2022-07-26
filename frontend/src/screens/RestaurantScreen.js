import React, {useState, useEffect} from 'react'
import {useParams} from 'react-router-dom'
import { Row, Col } from 'react-bootstrap'
import Food from '../components/Food'
import axios from 'axios'

const RestaurantScreen = () => {

  const [foods, setFoods] = useState([])

  const params = useParams()

  useEffect(()=>{
    
    const fetchFoods = async () => {
      const {data} = await axios.get(`/api/restaurants/${params.id}`)

      setFoods(data)
    }
    fetchFoods()
  },[]) 
  
  return (
    <>
      <h1>Available Foods</h1>
      <Row>
            {foods.map((food) => (
              <Col key={food._id} sm={12} md={6} lg={4} xl={3}>
                  <Food food={food}/>
                </Col>
            ))}
        </Row>
    </>
  )
}

export default RestaurantScreen