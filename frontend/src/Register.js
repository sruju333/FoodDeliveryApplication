import React,{useState} from 'react';
import { Navigate, useNavigate ,Link} from 'react-router-dom';
import "./Register.css";

function Register(){
    
    const [user,setUser]=useState({
        name:"",
        email:"",
        phonenumber:"",
        password:"",
        reEnterPassword:""

    })
    const handleChange =(e)=>{
        const{name,value}=e.target;
        setUser({
            ...user,[name]: value
        })
    
    }
    const registerMe=(e)=>{
        e.preventDefault();
        console.log(user);
    }
   
    return(
        
        <form className="register" onSubmit={registerMe}>
        <h1>Register</h1>
        <input type="text" name="name" value={user.name} placeholder="Enter your Name" onChange={handleChange}></input>
        <input type="text" name="email" value={user.email}placeholder="Enter your email" onChange={handleChange}></input>
        <input type="phone" name="phonenumber" value={user.phonenumber}placeholder="Enter your Phone Number"onChange={handleChange}></input>
        <input type="password" name="password" value={user.password} placeholder="Enter your password" onChange={handleChange}></input>
        <input type="password" name="reEnterPassword" value={user.reEnterPassword} placeholder="Re-enter your password" onChange={handleChange}></input>
        <button className="btn btn-primary my-3 h4">Register</button>
        <div><a href='/login'>Already have an account</a></div>
        </form>
    )
}
export default Register;