import {React,useState} from 'react';
import "./Login.css";
import axios from 'axios';
function Login(){
       
    const [user,setUser]=useState({
        email:"",
        password:""

    })
    const handleChange =(e)=>{
        const{name,value}=e.target;
        setUser({
            ...user,[name]: value
        })
    
    }
    const loginMe=(e)=>{
        e.preventDefault();
        axios.post("https://reqres.in/api/login",user)
        .then(response =>{
            console.log(response);
        })
        .catch((e)=>{
            alert("enter valid details")
        })
    }
    return(
        
        <form className="register" onSubmit={loginMe}>
        <h1>Login</h1>
        <input type="text" name="email" value={user.email}placeholder="Enter your email" onChange={handleChange}></input>
        <input type="password" name="password" value={user.password} placeholder="Enter your password" onChange={handleChange}></input>
        <button className="btn btn-primary my-3 h4">Login</button>
        <div><a href='/register'>Create a new user</a></div>
        </form>
    )
}
export default Login;