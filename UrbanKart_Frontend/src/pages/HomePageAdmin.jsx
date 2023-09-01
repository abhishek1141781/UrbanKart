import React, { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import ProductService from '../services/product.service';
import CategoryService from '../services/category.service';
import Skeleton from "react-loading-skeleton";
import "react-loading-skeleton/dist/skeleton.css";
import { Link } from "react-router-dom";

function HomePageAdmin() {
  const [data, setData] = useState([]);
  const [filter, setFilter] = useState(data);
  const [loading, setLoading] = useState(false);
  const [categorie, setCategorie] = useState([]);

  const BASE_URL="http://localhost:8080/products/";
   //Fetched Data From Backend
   useEffect(() => {
    
    ProductService.getAllProducts().then((response) => {
      setData(response.data);
      setFilter(response.data);
      setLoading(false);
    });

    CategoryService.getAllCategories().then((response) => {
      setCategorie(response.data);
    });
  }, []);

  const Loading = () => {
    return (
      <>
        <div className="col-12 py-5 text-center">
          <Skeleton height={40} width={560} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
        <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
          <Skeleton height={592} />
        </div>
      </>
    );
  };

  const ShowProducts = () => {
    return (
      <>
        <div className="buttons text-center py-5" style={{backgroundColor:"#000000"}}>
          <button className="btn btn-outline-light btn-sm m-2" style={{fontSize:"1.5rem"}} onClick={() => setFilter(data)}>All</button>
          {categorie.map((cat)=>{
            const name=cat.categoryName;
            console.log(BASE_URL + cat.id );
            return <button className="btn btn-outline-light btn-sm m-2" style={{fontSize:"1.5rem"}} onClick={() => filterProduct(cat.id)}>{cat.categoryName}</button>
          })}

        </div>
        
        {filter.map((product) => {
          return (
            <div id={product.id} key={product.id} className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
              <div className="card text-center h-100" key={product.id}>
                <img
                  className="card-img-top p-3"
                  src={BASE_URL + product.id +'/image'}//src={product.image}
                  alt="Card123"
                  height={300}
                />
                <div className="card-body">
                  <h5 className="card-title">
                  
                    {product.name}
                  </h5>
                  <p className="card-text">
                    {product.description}
                  </p>
                  <p className="card-text">
                    Stock : {product.stock}
                  </p>
                </div>
                <ul className="list-group list-group-flush">
                  <li className="list-group-item lead">Rs. {product.price}</li>
                </ul>


                <div className="card-body">
                <Link to="/updateform" state={product.id} className="btn btn-dark m-1">
          Update Product
        </Link>
                </div>
              </div>
            </div>

          );
        })}
      </>
    );
  };

  const filterProduct = (id) => {

    ProductService.getProductsByCategory(id).then((response)=>{
      setFilter(response.data)
    });
  }


  return (
    <>
    <div className="container my-3 py-0" >
      <div className="row">
        <div className="col-12">
         
          <hr />
        </div>
      </div>
      <div className="row justify-content-center">
        {loading ? <Loading /> : <ShowProducts />}
      </div>
    </div>
  </>
  );
}

export default HomePageAdmin