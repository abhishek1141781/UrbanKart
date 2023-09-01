import React from "react";
import { Footer } from "../components";
import {toast} from 'react-toastify';
import {  useNavigate } from "react-router-dom";



const ContactPage = () => {
  const navigate = useNavigate();
 const handleSubmit =(e)=>{
  e.preventDefault();
  toast.success("You will here back from us Soon");
  navigate("/product")
}
   

  return (
    <>
<div class="container my-5 py-5">
  <div class="row">
    <div class="col-md-6 mx-auto bg-dark" >
      <h1 class="text-center mb-4 text-light">Contact Us</h1>
      <hr class="my-4" />
      <form class="my-5" onSubmit={handleSubmit}>
        <div class="form-group my-3 ">
          <label for="Name " class="text-light">Name</label>
          <input
            type="text"
            class="form-control"
            id="Name"
            placeholder="Enter your name"
          />
        </div>
        <div class="form-group my-3">
          <label for="Email" class="text-light">Email</label>
          <input
            type="email"
            class="form-control"
            id="Email"
            placeholder="name@example.com"
          />
        </div>
        <div class="form-group my-3">
          <label for="Password" class="text-light">Message</label>
          <textarea
            rows={5}
            class="form-control"
            id="Password"
            placeholder="Enter your message"
          ></textarea>
        </div>
        <div class="text-center">
          <button
            class="my-2 px-4 mx-auto btn btn-dark"
            type="submit"
          >
            Send
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

export default ContactPage;
