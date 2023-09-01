import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader, authImageHeader } from './base.service';
const API_URL = BASE_API_URL + '/products';

class ProductService {
  saveProduct(product) {
    return axios.post(API_URL, product, { headers: authHeader() });
  }

  //upload product image
  uploadProductImage(image, productId) {
    let formData = new FormData();
    formData.append('imageFile', image);
    console.log('in upload img ' + formData + ' ' + productId);
    return axios
      .post(`${API_URL}/${productId}/image`, formData, {
        headers: authImageHeader(),
      })
      .then((response) => response.data);
  }

  deleteProduct(product) {
    return axios.delete(API_URL + '/' + product.id, { headers: authHeader() });
  }

  getAllProducts() {
    return axios.get(API_URL);
  }


  getAllCategories() {
    return axios.get(BASE_API_URL + '/category');
  }

  getProductsByCategory(id) {
    return axios.get(BASE_API_URL + `/products/category/${id}`);
  }

  getProductById(id) {
    return axios.get(BASE_API_URL + `/products/${id}`);
  }

  updateProduct(id , product){
    console.log(id);
    console.log(id);
    console.log(BASE_API_URL+`/products/${id}`);
    console.log(authHeader());
    return axios.put(BASE_API_URL+`/products/${id}`,product,{ headers :authHeader()});
  }
  getProductImage(id) {
    return axios.get(`http://localhost:8080/products/${id}/image`, {
      responseType: 'blob',
    }); 
  }
}

export default new ProductService();