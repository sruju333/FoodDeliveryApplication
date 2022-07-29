import React,{useState} from 'react';
import "./Restaurant.css";



function Restaurant(){
    
    

    const [user,setUser]=useState({
        restaurantAddress:"",
        restaurantName:"",
        restaurantManagerId:"",
        restaurantImage:""

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
        
        <form className="restaurant" onSubmit={registerMe}>
        <h1>Restaurant Registration</h1>
        <input type="text" name="restaurantAddress" value={user.restaurantAddress} placeholder="Enter the  Restaurant Address" onChange={handleChange} required></input>
        <input type="text" name="restaurantName" value={user.restaurantName} placeholder="Enter the Restaurant Name" onChange={handleChange} required></input>
        <input type="number" onkeypress="return event.charCode>=48 && event.charCode<=57" min="0" required name="restaurantManagerId" value={user.restaurantManagerId} placeholder="Enter the Restaurant Manager Id" onChange={handleChange} oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1').replace(/^0[^.]/, '0');"></input>
        <input type="url" onChange={handleChange}  name="restaurantImage" value={user.restaurantImage}  placeholder="Enter the url of the image https://example.com" pattern="https://.*" size="30"required></input>
        <button className="btn btn-primary my-3 h4">Register</button>
        </form>
       
    )
}

export default Restaurant;