import React from 'react'
const Category = ({text, color}) => {
  return (
        <span>
            <i style={{color}} className='fas fa-solid fa-circle'/>
            {text}
        </span>
  )
}

export default Category