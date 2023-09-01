import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader} from './base.service';

const ADMIN_API_URL = BASE_API_URL + '/order/admin';

class AdminOrderService {

  getAllOrders() {
    return axios.get(ADMIN_API_URL , { headers: authHeader() })
  }

  updateOrderStatus(orderStatusDTO){
    return axios.put(ADMIN_API_URL , orderStatusDTO , { headers: authHeader() })
  }

  getAllUsers(){
    return axios.get(BASE_API_URL + "/user/admin" ,  { headers: authHeader() })
  }

}

export default new AdminOrderService();