import React, { useEffect, useState } from "react";
import AdminOrderService from '../services/adminorder.service';

import {Modal , ModalHeader ,ModalBody } from "reactstrap";
import Orderstatus from "../models/orderStatus";
import {  toast } from 'react-toastify';

const OrdersPage = () => {

  const [model,setModel]=useState(false);
  const [orders, setOrders] = useState([]);
  const [orderStat , setOrderStat] = useState(new Orderstatus('',''))
  const BASE_URL = "http://localhost:8080/products/";
  useEffect(() => {
    AdminOrderService.getAllOrders().then((resp) => {
      setOrders(resp.data);
    }).then(()=>{
      console.log(orders)
    })
  }, [])


  const renderOrders=()=>{
    AdminOrderService.getAllOrders().then((resp) => {
      setOrders(resp.data);
    }).then(()=>{
      console.log(orders)
    })
  }
  

  const handleStatusChange=(e)=>{
        const{name , value}= e.target
        setOrderStat(prevStat =>{
          return {
            ...prevStat,
            [name]:value
          }
        })
        console.log(orderStat)

  }

  const handleStatusUpdateSubmit =(e)=>{
    e.preventDefault();
    console.log("In submit ")
    AdminOrderService.updateOrderStatus(orderStat).then((resp)=>{
      toast.success("Status Updated" ,{autoClose: 1500});
       setModel(false);
      renderOrders();
       }).catch((error)=>{
        setModel(false);
        toast.error(error.response.data ,{autoClose: 1500});
       })
  }



  return (
    <>
    {/* Code For Updating The Order Status */}
     <div className="form-control">
      <button  className="btn btn-outline-dark m-2" onClick={()=>{setModel(true)}}> Update Order Status</button>
     <small>please copy Order Id First</small>

      <div>
        <Modal
        size="lg"
        isOpen={model}
        toggle={()=>setModel(!model)}
        style={{backgroundColor:"green"}}
        >
           <ModalHeader toggle={()=>setModel(!model)}>
              Update Order
           </ModalHeader>
           <ModalBody>
            <form onSubmit={(e)=>{handleStatusUpdateSubmit(e)}}>

                    <div class="form my-3">
                      <label htmlFor="orderid">
                        Order ID
                      </label>
                     <input 
                     type="text" 
                     id="orderId"
                     name="orderId"
                     className="form-control" 
                     onChange={handleStatusChange}
                     placeholder="Enter Order ID To be Updated"/>
                    </div>


                    <div class="form my-3">
                                <label for="status">Order Status</label>
                                <select
                                    class="form-control"
                                    name="status"
                                    id="status"
                                    onChange={handleStatusChange}
                                    required
                                >
                                   <option value="">--Select Status</option>
                                   <option value="IN_PROCESS">IN_PROCESS</option>
                                   <option value="DELIVERED">DELIVERED</option>
                                </select>

                            </div>

                            <div class="form my-3">
                                <label for="deliveryDate">Order Delivery Date</label>
                                <input
                                    type="date"
                                    class="form-control"
                                    name="deliveryDate"
                                    id="deliveryDate"

                                    placeholder="Enter Stock Here"
                                    onChange={handleStatusChange}
                                    required

                                />
                            </div>

                            <div className="text-center">
                                <button class="my-2 mx-auto btn btn-dark" type="submit" >
                                    Update Status
                                </button>
                            </div>
            </form>
           </ModalBody>
        </Modal>
      </div>





     </div>
      <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Order Id</th>
            <th scope="col">Product</th>
            <th scope="col">Name</th>
            <th scope="col">description</th>
            <th scope="col">Quantity</th>
            <th scope="col">Total Price</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Address</th>
            <th scope="col">City</th>
            <th scope="col">Pin Code</th>
            <th scope="col">Mobile Number</th>
            <th scope="col">Status</th>
            <th scope="col">Order date</th>
            <th scope="col">Delivery Date</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {
            orders.map((order) => {
              return (
                <>
                  {
                    order.orderDetails.map((oDetails) => {
                      return (
                        <>
                          <tr>
                            <td >{order.id}</td>
                            <td >
                                <img
                                  src={BASE_URL + oDetails.productId.id + '/image'}
                                  width={100}
                                  height={75}
                                  alt={oDetails.productId.name}
                                />
                            </td>
                            <td >{oDetails.productId.name}</td>
                            <td >{oDetails.productId.description}</td>
                            <td >{oDetails.quantity}</td>
                            <td >{oDetails.totalPrice + order.shippingPrice}</td>
                            <td >{order.userOrdered.firstName + " " + order.userOrdered.lastName}</td>
                            <td >{
                              order.address.adressLine1+ " " +
                              order.address.adressLine2
                            }</td>
                            <td >{order.address.city}</td>
                            <td >{order.address.zipCode}</td>
                            <td >{order.userOrdered.mobileNumber}</td>
                            <td >{order.status}</td>
                            <td >{order.orderDate}</td>
                            <td >{order.deliveryDate}</td>


                          </tr>
                        </>
                      );
                    })
                  }
                </>
              )
            })
          }
        </tbody>
      </table>

    </>


  );


}

export default OrdersPage;