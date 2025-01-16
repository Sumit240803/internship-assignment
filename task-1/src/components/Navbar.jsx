import React from 'react'
import "../assets/css/Navbar.css"
const Navbar = () => {
  return (
    <div className='nav'>
        <a href='#home' className='nav-list'>
            Home
        </a>
        <a href='#products' className='nav-list'>
            Products
        </a>
        <a href='#about' className='nav-list'>
            About Us
        </a>
        <a href='#contact' className='nav-list'>
            Contact
        </a>
    </div>
  )
}

export default Navbar