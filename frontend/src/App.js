import { Container } from 'react-bootstrap'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer'; 
import HomeScreen from './screens/HomeScreen';
import RestaurantScreen from './screens/RestaurantScreen'
import CartScreen from './screens/CartScreen';
import LoginScreen from './screens/LoginScreen';
import RegisterScreen from './screens/RegisterScreen';

const App=()=> {
  return (
    <Router>
    <Header />
      <main className='py-3'>
        <Container>
          <Routes>
            <Route path='/' element={<HomeScreen />}/>
            <Route path='/restaurant/:id' element={<RestaurantScreen />} />
            <Route path='/cart/:id' element={<CartScreen />}/>
            <Route path='/cart' element={<CartScreen />}/>
            <Route path='/login' element={<LoginScreen />}/>
            <Route path='/register' element={<RegisterScreen />}/>
          </Routes>
        </Container>
      </main>
    <Footer />
    </Router>
  );
}

export default App;
