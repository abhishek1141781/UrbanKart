import React from "react";
import { useState } from "react";
import {  useNavigate } from "react-router-dom";
import { Footer } from "../components";
import Category from "../models/category";
import categoryService from "../services/category.service";

const AddCategory = () => {

    const [category , setCategory] = useState(new Category('',''));
    const navigate = useNavigate();

    const handleChange = (e)=>{
    const {name,value} = e.target;
        setCategory(prevState=>{
            return{
                ...prevState , 
                [name]:value
            }
        })
    }
    
   const handleAddCategory=(e)=>{
        e.preventDefault();
        

        if(!category.categoryName) return;
       categoryService.addCategory(category).then(_=>{
        alert("Category added")
        navigate('/product')
       })
       .catch((error)=>{
        console.log(error)
       })

   }
  return (
    <>     
            <div className="container my-3 py-3 bg-dark">
                <h1 className="text-center text-light">Add Category</h1>
                <hr />
                <div class="row my-4 h-50">
                    <div className="col-md-7 col-lg-7 col-sm-5 mx-auto">
                        <form onSubmit={(e) => handleAddCategory(e)}>
                            <div class="form my-3">
                                <label for="CName" class="text-light">Category Name </label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="CName"
                                    name="categoryName"
                                    value={category.categoryName}
                                    placeholder="Enter Category Name"
                                    minLength={4}
                                    maxLength={20}
                                    required
                                    onChange={handleChange}
                                />
                            </div>
                            <div class="form my-3">
                                <label for="Desc" class="text-light">Description</label>
                                <textarea 
                                 class="form-control"
                                name="description"
                                 id="description" 
                                 cols="60" 
                                 rows="10"
                                 value={category.description}
                                 placeholder="Enter Description Here"
                                 onChange={handleChange}>
                                </textarea>
                            </div>
                            <div className="text-center">
                                <button class="my-2 mx-auto btn btn-dark" type="submit" >
                                  Add Category
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