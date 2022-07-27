import express from 'express'
import dotenv from 'dotenv'
import restaurants from './data/restaurants.js'
import foods from './data/foods'

dotenv.config()

const app = express()

app.get('/', (_req, res) => {
    res.send('API is running...')
})

app.get('/api/restaurants', (_req, res) => {
    res.json(restaurants)
})

app.get('/api/restaurants/:id', (_req, res) => {
    const restaurant = []
    for(let i = 0 ; i < restaurants.length ; i++){
        if(restaurants[i]._id == _req.params.id)
            restaurant.push(restaurants[i].foods)
    }   
    //console.log(restaurant) 
    res.json(restaurant[0])
})

app.get('/api/restaurant/:id', (_req, res) => {
    const food = foods[0]
    res.json(food)
})

const PORT = process.env.PORT || 5000

app.listen(PORT, console.log(`Server running in ${process.env.NODE_ENV} mode port ${PORT}`))