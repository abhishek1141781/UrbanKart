import React, { useEffect } from "react";
import { useState } from "react";
import { Footer } from "../components";
import {  useNavigate } from "react-router-dom";
import Product from "../models/product";
import categoryService from "../services/category.service";
import productService from "../services/product.service";
import ProductService from '../services/product.service';
import {  toast } from 'react-toastify';

const AddCategory = () => {
    const navigate = useNavigate();
    const [product, setProduct] = useState(new Product('', '', '', '', '', ''));
    const [categoryList, setCategoryList] = useState([]);
    const [image, setImage] = useState(null)
    const handleChange = (e) => {
        const { name, value } = e.target;
        setProduct(prevState => {
            return {
                ...prevState,
                [name]: value
            }
        }
        )
        console.log(product);
    }
    useEffect(() => {
        categoryService.getAllCategories().then((resp) => {
            console.log(resp.data)
            setCategoryList(resp.data)
        });
    }, []);

    const handleAddProduct = (e) => {
        e.preventDefault();
          productService.saveProduct(product).then((resp) => {
            console.log("Product added Success");
            productService.uploadProductImage(image, resp.data.id).then(() => {
                toast.success("Product Added" ,{autoClose: 1500});
                navigate('/updateproduct')
            });
        })
    }

    const handleImageChange = (event) => {
        setImage(event.target.files[0])
        console.log(image);
    }



    return (
        <>

            <div className="container my-3 py-3 bg-dark">
                <h1 className="text-center text-light" >Add Product</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">

                        <form onSubmit={(e) => handleAddProduct(e)}>
                            <div class="form my-3">
                                <label for="PName" class="text-light">Product Name </label>
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
                                <label for="price" class="text-light">Product price</label>
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
                                    maxLength={20}
                                />
                            </div>


                            <div class="form my-3">
                                <label for="description" class="text-light"> Product Description </label>
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
                                <label for="stock" class="text-light">Product Stock</label>
                                <input
                                    type="number"
                                    class="form-control"
                                    name="stock"
                                    id="stock"
                                    value={product.stock}
                                    placeholder="Enter Stock Here"
                                    onChange={handleChange}
                                    required

                                />
                            </div>

                            <div class="form my-3">
                                <label for="categoryId" class="text-light">Category</label>
                                <select
                                    class="form-control"
                                    name="categoryId"
                                    id="categoryId"

                                    placeholder="Enter Stock Here"
                                    onChange={handleChange}
                                    required
                                >
                                    <option value="" selected disabled>-- Select The Category --</option>
                                    {
                                        categoryList.map((cat) => {
                                            console.log(cat.id)
                                            return <option key={cat.id} value={cat.id}>{cat.categoryName}</option>

                                        })


                                    }

                                </select>

                            </div>

                            <div class="form my-3">
                                <label for="image" class="text-light">Product Image</label>
                                <input
                                    type="file"
                                    class="form-control"
                                    name="image"
                                    id="image"
                                    placeholder="Enter image Here"
                                    onChange={handleImageChange}
                                    required

                                />
                            </div>


                            <div class="form my-3">
                                <label for="expDate" class="text-light">Product expdate</label>
                                <input
                                    type="date"
                                    class="form-control"
                                    name="expDate"
                                    id="expDate"

                                    placeholder="Enter Stock Here"
                                    onChange={handleChange}
                                    required

                                />
                            </div>


                            <div className="text-center">
                                <button class="my-2 mx-auto btn btn-dark" type="submit" >
                                    Add Product
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
};

export default AddCategory;