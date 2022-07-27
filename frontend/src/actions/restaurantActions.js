import {RESTAURANT_LIST_REQUEST, RESTAURANT_LIST_SUCCESS, RESTAURANT_LIST_FAIL} from '../constants/restaurantConstants'
import axios from 'axios'

export const listRestaurants = () => async (dispatch) => {
    try {
        dispatch({type: RESTAURANT_LIST_REQUEST})

        const {data} = await axios.get('/api/restaurants')

        dispatch({
            type: RESTAURANT_LIST_SUCCESS,
            payload: data
        })
    } catch (error) {
        dispatch({
            type: RESTAURANT_LIST_FAIL,
            payload: error.response && error.response.data.message ? error.response.data.message : error.message,
        })
    }
}