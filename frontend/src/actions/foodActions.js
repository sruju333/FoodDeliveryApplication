import {FOOD_LIST_REQUEST, FOOD_LIST_SUCCESS, FOOD_LIST_FAIL} from '../constants/foodConstants'
import axios from 'axios'

export const listFoods = (id) => async (dispatch) => {

    try {
        dispatch({type: FOOD_LIST_REQUEST})

        const {data} = await axios.create({
            baseURL: 'https://food-delivery-app-123.herokuapp.com'
          }).get(`/restaurant/products/${id}`)

        dispatch({
            type: FOOD_LIST_SUCCESS,
            payload: data
        })
    } catch (error) {
        dispatch({
            type: FOOD_LIST_FAIL,
            payload: error.response && error.response.data.message ? error.response.data.message : error.message,
        })
    }
}