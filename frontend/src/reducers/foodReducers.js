import {FOOD_LIST_REQUEST, FOOD_LIST_SUCCESS, FOOD_LIST_FAIL} from '../constants/foodConstants'

export const foodListReducer = (state = {foods: []}, action) => {
    switch (action.type) {
        case FOOD_LIST_REQUEST:
            return {loading: true, foods: []}
        case FOOD_LIST_SUCCESS:
            return {loading: false, foods: action.payload}
        case FOOD_LIST_FAIL:
            return {loading: false, error: action.payload}
        default:
            return state
    }
}