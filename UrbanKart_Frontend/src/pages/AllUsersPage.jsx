import React, { useEffect, useState } from "react";
import AdminOrderService from '../services/adminorder.service';

import Orderstatus from "../models/orderStatus";


const AllUsersPage = () => {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    AdminOrderService.getAllUsers().then((resp) => {
      setUsers(resp.data);
    }).then(()=>{
      console.log(users)
    })
  }, [])
  return (
    <>
    {/* Code For Updating The Order Status */}
     
      <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">User Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Role</th>
            <th scope="col">MobileNumber</th>
          </tr>
        </thead>
        <tbody>
          {
            
                users.map((users) => {
                  return (
                    <>
                      <tr>
                        <td >{users.id}</td>
                        <td >{users.firstName}</td>
                        <td >{users.lastName}</td>
                        <td >{users.email}</td>
                        <td >{users.role}</td>
                        <td >{users.mobileNumber}</td>
                       </tr>
                    </>
                  );
                })
              }
        </tbody>
      </table>
    </>
  );
}

export default AllUsersPage;