import React from 'react'
import {Container} from 'react-bootstrap'
const Category = ({text, color}) => {
  return (
    <Container className='category' >
        <span>
            <i style={{color}} className='fas fa-solid fa-circle'/>
            {text}
        </span>
    </Container>
  )
}

export default Category