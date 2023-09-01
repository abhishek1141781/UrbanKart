export default class User {
  constructor(id,firstName,lastName,email, password,role,mobileNumber) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    //this.token = token;
    this.mobileNumber=mobileNumber;
    this.id = id;
  }
}
