import React from "react";
import { Link } from "react-router-dom";
import { Footer } from "../components";
import { useEffect, useState } from 'react';
import User from '../models/user';
import { useDispatch, useSelector } from 'react-redux';
import {  useNavigate } from 'react-router-dom';
import AuthenticationService from '../services/authentication.service';
import { setCurrentUser } from '../redux/action';
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
//import '../register/register.page.css'; //No need.
import {getUserRole} from '../services/base.service';
import { Role } from '../models/role';
import {  toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


const Login = () => {
  const [user, setUser] = useState(new User('', ''));
    const [loading, setLoading] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');

    const currentUser = useSelector(state => state.user);

    const navigate = useNavigate();

    const dispatch = useDispatch();

    //mounted
    useEffect(() => {
        if (currentUser?.id) {
            navigate('/profile');
        }
    }, []);

 
    const handleChange = (e) => {
        const {name, value} = e.target;

        setUser((prevState => {
            return {
                ...prevState,
                [name]: value
            };
        }));
    };

    const handleLogin = (e) => {
      e.preventDefault();
    console.log("in Handle Login")
      setSubmitted(true);
      if (!user.email || !user.password) {
        console.log(user.email +" " + user.password)
          return;
      }
      console.log("in Handle Login 22222")
      setLoading(true);
      console.log("email "+user.email+" pwd "+user.password);
      AuthenticationService.login(user).then(response => {
          toast.success("Welcome to UrbanKart "+response.data.firstName ,
           {autoClose: 1500});
          //set user in session.
          dispatch(setCurrentUser(response.data));
         console.log("after dispatch");
        if(getUserRole() === Role.USER)
          navigate('/');
          else
          navigate('/updateproduct');
      }).catch(error => {
         console.log(error);
         setErrorMessage('email or password is not valid.');
         setLoading(false);
      });
    };



  return (
    <>
     <div className="container my-3 py-3">
  <h1 className="text-center" style={{color: "black", textDecoration: "underline"}}>Login</h1>
  <hr />
  <div class="row my-4 h-100">
    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
      {errorMessage &&
      <div className="alert alert-danger">
          {errorMessage}
      </div>
      }
      <form onSubmit={(e) => handleLogin(e)}>
        <div class="my-3">
          <label for="display-4" style={{fontWeight: "bold"}}>Email address</label>
          <input
            type="email"
            name="email"
            class="form-control"
            id="floatingInput"
            placeholder="name@example.com"
            value={user.email}
            onChange={(e) => handleChange(e)}
            required
          />
        </div>
        <div className="invalid-feedback" style={{color: "red"}}>
            Email is required.
        </div>
        <div class="my-3">
          <label for="floatingPassword display-4" style={{fontWeight: "bold"}}>Password</label>
          <input
            type="password"
            name="password"
            class="form-control"
            id="floatingPassword"
            placeholder="Password"
            value={user.password}
            onChange={(e) => handleChange(e)}
            required
          />
        </div>
        <div className="my-3">
          <p style={{fontStyle: "italic"}}>New Here? <Link to="/register" className="text-decoration-underline text-info">Register</Link> </p>
        </div>
        <div className="text-center">
          <button class="my-2 mx-auto btn btn-dark" type="submit" style={{fontWeight: "bold"}}>
            Login
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

export default Login;
