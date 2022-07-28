import React,{useState} from 'react';
import "./Register.css";



function Register(){
    
    const [user,setUser]=useState({
        username:"",
        email:"",
        phonenumber:"",
        password:"",
        role:"",
        address:""

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
        <input type="text" name="username" value={user.username} placeholder="Enter your username" onChange={handleChange}></input>
        <input type="text" name="email" value={user.email}placeholder="Enter your email" onChange={handleChange}></input>
        <input type="phone" name="phonenumber" value={user.phonenumber}placeholder="Enter your Phone Number"onChange={handleChange}></input>
        <input type="password" name="password" value={user.password} placeholder="Enter your password" onChange={handleChange}></input>
        <input type="text" name="address" value={user.address} placeholder="Enter your address" onChange={handleChange}></input>
        <select value={user.role} name="role" onChange={handleChange}>
        <option value="Enter your role">Enter your Role</option>
        <option value="user">User</option>
            <option value="rmanager">RManager</option>
        </select>
        <button className="btn btn-primary my-3 h4">Register</button>
        <div><a href='/login'>Already have an account</a></div>
        </form>
       
    )
}
export default Register;