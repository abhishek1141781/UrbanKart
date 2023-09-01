import { BASE_API_URL} from '../common/constants';
import axios from 'axios';
import { authHeader } from './base.service';

const BASE_URL =  BASE_API_URL + '/category';

class CategoryService {

 addCategory(category){
    console.log("In axios of category")
    return axios.post(BASE_URL , category ,{ headers: authHeader() })
 }


 getAllCategories() {
   return axios.get(BASE_API_URL + '/category');
 }

 getProductsByCategory(id) {
   return axios.get(BASE_API_URL + `/products/category/${id}`);
 }

}

export default new CategoryService();