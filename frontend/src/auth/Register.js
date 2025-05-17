import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import Lottie from 'lottie-react';
import animationData from '../assets/registerAnimation.json'; // adjust the path as needed



import './Auth.css';

export default function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    branch: '',
    role: '',
    interests: ''
  });
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async e => {
    e.preventDefault();
    setError('');
    setSuccess('');
    try {
      console.log("Registering with:", formData);  
      const response = await axios.post('http://localhost:8080/api/users/register', formData);
      setSuccess('Registration successful! Redirecting to login...');
      setTimeout(() => {
        window.location.href = '/login';
      }, 2000);
    } catch (err) {
      if (err.response && err.response.data) {
        setError(err.response.data); // Show actual error message from backend
      } else {
        setError('Failed to register. Please try again later.');
      }
    }
  };

  return (
  <div className="auth-page">
    <div className="auth-wrapper">
      <div className="auth-left">
        <Lottie animationData={animationData} loop={true} />
      </div>
      <div className="auth-right">
        <div className="auth-container">
          <h2>Register</h2>
          {error && <div className="error-msg">{error}</div>}
          {success && <div className="success-msg">{success}</div>}
          <form onSubmit={handleSubmit}>
            <input type="text" name="name" placeholder="Full Name" onChange={handleChange} required />
            <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
            <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
            <input type="text" name="branch" placeholder="Branch" onChange={handleChange} required />
            <input type="text" name="role" placeholder="Role (e.g., Mentor/Mentee)" onChange={handleChange} required />
            <input type="text" name="interests" placeholder="Interests (comma-separated)" onChange={handleChange} required />
            <button type="submit">Register</button>
          </form>
          <p>
            Already have an account? <Link to="/login">Login here</Link>
          </p>
        </div>
      </div>
    </div>
  </div>
);

}
