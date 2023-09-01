import { Toast } from 'bootstrap';
import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { Footer } from '../components';
import categoryService from '../services/category.service';
import productService from '../services/product.service';
import { ToastContainer, toast } from 'react-toastify';
import { Link } from "react-router-dom";
import {  useNavigate } from "react-router-dom";



function UpdateFormAdmin(props) {
    const navigate = useNavigate();
    const location = useLocation();
    const productId = location.state;
    // const [categoryList, setCategoryList] = useState([]);
    let [product, setProduct] = useState({
        name: "",
        price: 0,
        description: "",
        stock: 0,
        expDate: null
    }
    );


    useEffect(() => {
       
        productService.getProductById(productId).then((resp) => {
            setProduct({
                name: resp.data.name,
                price: resp.data.price,
                description: resp.data.description,
                stock: resp.data.stock,
                categoryId: resp.data.categoryId,
                expDate: resp.data.expDate

            })
        })
    }, [])


    const handleChange = (event) => {
        const { name, value } = event.target;
        setProduct((prevState => {
            return {
                ...prevState,
                [name]: value
            };
        }));
    }

    const handleAddProduct = (e) => {
         e.preventDefault();
         console.log("In Handle Product ")
         console.log(product)
         productService.updateProduct(productId,product).then((resp)=>{
            console.log(resp.data)
            toast.success("Product Updated" ,{autoClose: 1500});
            navigate('/updateproduct')
         })
    }

    return (
        <>
            <div className="container my-3 py-3">
                <h1 className="text-center">Update Product</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
                        <form onSubmit={handleAddProduct}>
                            <div class="form my-3">
                                <label for="PName">Product Name </label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="PName"
                                    name="name"
                                    value={product.name}
                                    placeholder="Enter Product Name"
                                    maxLength={20}
                                    required
                                    onChange={handleChange}
                                />
                            </div>


                            <div class="form my-3">
                                <label for="price">Product price</label>
                                <br />
                                <input
                                    type="number"
                                    class="form-control"
                                    name="price"
                                    id="price"
                                    value={product.price}
                                    placeholder="Enter Price Here"
                                    onChange={handleChange}
                                    required
                                    maxLength={10}
                                />
                            </div>


                            <div class="form my-3">
                                <label for="description">Product Description </label>
                                <textarea
                                    class="form-control"
                                    name="description"
                                    id="description"
                                    cols="60"
                                    rows="10"
                                    value={product.description}
                                    placeholder="Enter Description Here"
                                    onChange={handleChange}>
                                </textarea>
                            </div>

                            <div class="form my-3">
                                <label for="stock">Product Stock</label>
                                <input
                                    type="number"
                                    class="form-control"
                                    name="stock"
                                    id="stock"
                                    value={product.stock}
                                    placeholder="Enter Stock Here"
                                    onChange={handleChange}
                                    required
                                    maxLength={10}

                                />
                            </div>

                            <div class="form my-3">
                                <label for="expDate">Product expdate</label>
                                <input
                                    type="date"
                                    class="form-control"
                                    name="expDate"
                                    id="expDate"
                                    value={product.expDate}
                                    placeholder="Enter Stock Here"
                                    onChange={handleChange}
                                    required

                                />
                            </div>


                            <div className="text-center">
                            <button class="my-2 mx-auto btn btn-dark" type="submit" >
                                    Update
                                </button>
                            </div>
                            <div className="text-center">
                                <Link to="/updateproduct" state={product.id} class="my-2 mx-auto btn btn-dark">Cancel</Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default UpdateFormAdmin