import React from 'react'
import { Footer } from "../components";
import { useState } from 'react';
import Address from '../models/address';
import {  useNavigate } from 'react-router-dom';
import UserOrderService from '../services/userorder.service';
import store from '../redux/store';
import {  toast } from 'react-toastify';

const Billing = () => {
    const [address,setAddress]=useState(new Address('','','','',''));
    const currentUser = store.getState().user;
    const [errorMessage] = useState('');
    const navigate = useNavigate();

  const handleChange=(event)=>{
    const {name, value} = event.target;
    setAddress((prevState => {
        return {
            ...prevState,
            [name]: value
        };
    }));
  }

  const handleAddress = (e) => {

    e.preventDefault();
    
    UserOrderService.saveOrder(currentUser.id,address).then((resp)=>{
        toast.success("Order Placed" ,{autoClose: 1500});
     
      navigate("/product")
      }).catch((error)=>{
      console.log(error)
     }); 
  };

    return (
        <>
           
            <div className="container my-3 py-3">
                <h1 className="text-center">Check Out</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">

                        {errorMessage &&
                        <div className="alert alert-danger">
                            {errorMessage}
                        </div>
                        }
                        <form onSubmit={(e) => handleAddress(e)}>
                            <div class="form my-3">
                                <label for="FName">Address Line1</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="FName"
                                    name="addressLine1"
                                    value={address.addressLine1}
                                    placeholder="Address Line1"
                                    required
                                    onChange={handleChange}
                                />
                            </div>
                            <div class="form my-3">
                                <label for="FName">Address Line2</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="LName"
                                    name="addressLine2"
                                    value={address.addressLine2}
                                    placeholder="Address Line2"
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div class="form my-3">
                                <label for="Email">City</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="Email"
                                    name="city"
                                    value={address.city}
                                    placeholder="City"
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div class="form  my-3">
                                <label for="Password">State</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="Password"
                                    name="state"
                                    value={address.state}
                                    placeholder="State"
                                    onChange={handleChange}
                                    required
                                />
                            </div>

                            <div class="form  my-3">
                                <label for="Mobile Number">Zip Code</label>
                                <input
                                    type="number"
                                    class="form-control"
                                    id="mobile"
                                    name="zipCode"
                                    value={address.zipCode}
                                    placeholder="Zip Code"
                                    onChange={handleChange}
                                    required
                                />
                            </div>


                            
                            <div className="text-center">
                                <button class="my-2 mx-auto btn btn-dark" type="submit" >
                                    Place Order
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default Billing