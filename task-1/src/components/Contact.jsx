import React, { useState } from 'react';
import "../assets/css/Contact.css";

const Contact = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Form Data Submitted:', formData);
    
  };

  return (
    <div id='contact' className="main">
      <h2 className='contact-heading'>Contact Us</h2>
      <form onSubmit={handleSubmit} className="contact-form">
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input type="text" id="name" name="name"  value={formData.name} onChange={handleChange} placeholder="Enter your name" required/>
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input type="email" id="email" name="email"  value={formData.email} onChange={handleChange} placeholder="Enter your email"  required/>
        </div>
        <div className="form-group">
          <label htmlFor="message">Message</label>
          <textarea id="message" name="message" value={formData.message} onChange={handleChange} placeholder="Enter your message" required/>
        </div>
        <button type="submit" className="submit-button">Send Message</button>
      </form>
    </div>
  );
};

export default Contact;
