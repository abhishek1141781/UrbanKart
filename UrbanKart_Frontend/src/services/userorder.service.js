import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader } from './base.service';
const API_URL = BASE_API_URL + '/order/user';


class UserOrderService {

  saveOrder(id,address) {
    return axios.post(API_URL+`/${id}`, address, { headers: authHeader() });
  }

  getMyOrders(id) {
    return axios.get(API_URL+`/${id}` , { headers: authHeader() })
  }

  cancelMyOrder(id) {
    console.log("in Method"+authHeader())
    return axios.put(API_URL+`/cancel/${id}` , id,{ headers: authHeader() })
  }
}

export default new UserOrderService();
