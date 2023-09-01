import handleCart from './handleCart'
import userReducer from './user';
import { combineReducers } from "redux";
const rootReducers = combineReducers({
    handleCart,
    user: userReducer,
})
export default rootReducers