import { Container } from 'react-bootstrap'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer'; 
import HomeScreen from './screens/HomeScreen';
import RestaurantScreen from './screens/RestaurantScreen'
import CartScreen from './screens/CartScreen';

const App=()=> {
  return (
    <Router>
    <Header />
      <main className='py-3'>
        <Container>
          <Routes>
            <Route path='/' element={<HomeScreen />}/>
            <Route path='/restaurants/:id' element={<RestaurantScreen />} />
            <Route path='/cart/*' element={<CartScreen />}/>
          </Routes>
        </Container>
      </main>
    <Footer />
    </Router>
  );
}

export default App;
