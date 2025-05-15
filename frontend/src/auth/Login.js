// src/Login.js
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Auth.css';

export default function Login() {
  const [formData, setFormData] = useState({ email: '', password: '' });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async e => {
    e.preventDefault();
    setError('');
    try {
      const response = await axios.post('http://localhost:8080/api/users/login', formData);
      console.log('Login response:', response.data);
      if (response.data && response.data.id) {
        localStorage.setItem('user', JSON.stringify(response.data));
        navigate('/dashboard'); // 👈 Redirect to Dashboard
      } else {
        setError('Invalid credentials');
      }
    } catch {
      setError('Login failed. Please check your credentials.');
    }
  };

  return (
    <div className="auth-container">
      <h2>Login</h2>
      {error && <div className="error-msg">{error}</div>}
      <form onSubmit={handleSubmit}>
        <input type="email" name="email" placeholder="Email" onChange={handleChange} value={formData.email} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} value={formData.password} required />
        <button type="submit">Login</button>
      </form>
      <p>Don't have an account? <a href="/register">Register here</a></p>
    </div>
  );
}
