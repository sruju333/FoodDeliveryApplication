// import {Container} from 'react-bootstrap'
import React,{Component,useState} from 'react';
//import './App.css';
//import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter, Routes,Route} from 'react-router-dom';
import Login from './Login';
import Register from './Register';
function App(){
  
  return (
    <>
     <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>} />
        <Route path="/register" element={<Register/>} />
      </Routes>
    </BrowserRouter>
   </>
  );
   
}

export default App;
