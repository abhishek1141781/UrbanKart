import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { clearCurrentUser } from '../redux/action';
import { Role } from '../models/role';
import { ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {  toast } from 'react-toastify';

const Navbar = () => {


    const user = useSelector(state => state.user)

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const logout = () => {
         
        dispatch(clearCurrentUser());
        toast.success("Logged Out",{autoClose: 1500});
        console.log("After logout")
        navigate('/login');
        console.log("After navigate")
    };





    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark py-3 sticky-top"> {/*darken the nav bar*/} 
            <ToastContainer />
            <div className="container">
            { ! (user?.role===Role.ADMIN) ?
                <NavLink className="navbar-brand fw-bold fs-4 px-2" to="/product"> UrbanKart</NavLink>
                :
                <NavLink className="navbar-brand fw-bold fs-4 px-2" to="/updateproduct"> UrbanKart</NavLink> 
            }
                {}
                <button className="navbar-toggler mx-2" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav m-auto my-2 text-center">

                    { 
                          ! (user?.role===Role.ADMIN) ?
                                <>
                                <li className="nav-item">
                                     <NavLink className="nav-link" to="/">Home </NavLink>
                                 </li>
                                <li className="nav-item">
                                     <NavLink className="nav-link" to="/product">Products</NavLink>
                                 </li>


                                 {/* <li className="nav-item">
                                     <NavLink className="nav-link" to="/updateProfile">Update Profile</NavLink>
                                 </li> */}
                                </> :
                                <> 
                                <li className="nav-item">
                                     <NavLink className="nav-link" to="/updateproduct">Products</NavLink>
                                 </li> 
                                </>

                         }

                        <li className="nav-item">
                            <NavLink className="nav-link" to="/about">About</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/contact">Contact</NavLink>
                        </li>
                    </ul>
                    <div className="buttons text-center">
                        {
                            user ? <></>
                                : <NavLink to="/register" className="btn btn-outline-light m-2"><i className="fa fa-user-plus mr-1"></i> Register</NavLink>
                        }

                         {
                            (user?.role === Role.ADMIN) ?

                               <span>
                                <NavLink to="/users" className="btn btn-outline-light m-2"><i class="fa fa-user" aria-hidden="true"></i> Users</NavLink>
                                <NavLink to="/addcategory" className="btn btn-outline-light m-2"><i className="fa fa-solid fa-plus"></i>Add Category</NavLink>
                                <NavLink to="/addproduct" className="btn btn-outline-light m-2"><i className="fa fa-solid fa-plus"></i> Add Product</NavLink>
                                 <NavLink to="/placedorders" className="btn btn-outline-light m-2"><i class="fa-solid fa-pen-to-square"></i> All Orders Details</NavLink> 
                               </span>


                                :
                                <>

                                </>



                         }

                        {
                            user ? <NavLink to="/login" className="btn btn-outline-light m-2" onClick={logout}><i className="fa fa-sign-in-alt mr-1"  ></i> Logout</NavLink>
                                : <NavLink to="/login" className="btn btn-outline-light m-2"><i className="fa fa-sign-in-alt mr-1"></i> Login</NavLink>

                        }

                        { 
                          ! (user?.role===Role.USER) ?
                                <>

                                </>
                                :
                                <>
                                  <NavLink to="/cart" className="btn btn-outline-light m-2"><i className="fa fa-cart-shopping mr-1"></i> Cart </NavLink>
                                  <NavLink to="/myorders" className="btn btn-outline-light m-2"><i className="fa fa-cart-shopping mr-1"></i> My Orders </NavLink>
                                </>     
                         }
                      
                        {user && (
                    <span className="text-light">Welcome {user.firstName}</span>
                    )}

                    </div>
                </div>


            </div>
        </nav>
    )
}

export default Navbar