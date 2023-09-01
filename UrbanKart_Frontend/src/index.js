// import React from 'react';
import ReactDOM from 'react-dom/client';
import '../node_modules/font-awesome/css/font-awesome.min.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './redux/store';


import { Home, Products, AboutPage, ContactPage, Cart, Login, Register,  PageNotFound, AddProduct, Billing ,MyOrders, OrdersPage, AllUsersPage} from "./pages"
import { Navbar } from './components';
import AddCategory from './pages/AddCategory';
import UpdateProduct from './pages/HomePageAdmin';
import UpdateFormAdmin from './pages/UpdateFormAdmin';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>


    <Provider store={store}>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/product" element={<Products />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/checkout"  element={<Billing />} />
        <Route path="*" element={<PageNotFound />} />
        <Route path="/product/*" element={<PageNotFound />} />
        <Route path="/addcategory" element={<AddCategory />} />
        <Route path="/myorders" element={<MyOrders />} />
        <Route path="/addproduct" element={<AddProduct />} />
        <Route path="/updateproduct" element={<UpdateProduct />} />
        <Route path="/users" element={< AllUsersPage />}/>
        <Route path="/updateform" element={< UpdateFormAdmin />}/>
        <Route path="/placedorders" element={< OrdersPage />}/>
      </Routes>
    </Provider>
  </BrowserRouter>
);