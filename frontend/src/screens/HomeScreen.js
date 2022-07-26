import React, {useState, useEffect} from 'react'
import { Row, Col } from 'react-bootstrap'
import axios from 'axios'
import Restaurant from '../components/Restaurant'

const HomeScreen = () => {
  const [restaurants, setRestaurants] = useState([])

  useEffect(() => {
    const fetchRestaurants = async () => {
      const {data} = await axios.get('/api/restaurants')

      setRestaurants(data)
    }
    fetchRestaurants()
  }, [])

  return (
    <>
    <h1>Available Restaurants</h1>
        <Row>
            {restaurants.map((restaurant) => (
                <Col key={restaurant._id} sm={12} md={6} lg={4} xl={3}>
                    <Restaurant restaurant={restaurant}/>
                </Col>
            ))}
        </Row>
    </>
  )
}

export default HomeScreen