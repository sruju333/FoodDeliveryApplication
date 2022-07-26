const express = require('express')
const restaurants = require('./data/restaurants')
const foods = require('./data/foods')

const app = express()

app.get('/', (req, res) => {
    res.send('API is running...')
})

app.get('/api/restaurants', (req, res) => {
    res.json(restaurants)
})

app.get('/api/restaurants/:id', (req, res) => {
    const restaurant = restaurants.find(p => p._id === req.params.id) 
    res.json(foods)
})

app.listen(5000, console.log('Server running on port 5000'))