// src/components/Sidebar.js
import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Sidebar.css'; // You can style this yourself

const Sidebar = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/login');
  };

  return (
    <div className="sidebar">
      <h2 className="logo">EduNexus</h2>
      <ul>
        <li><Link to="/dashboard/items">Item Exchange</Link></li>
        <li><Link to="/dashboard/mentorship">Mentorship</Link></li>
        <li><Link to="/dashboard/reviews">Reviews</Link></li>
        <li><Link to="/dashboard/messages">Messages</Link></li>
        <li><Link to="/dashboard/profile">Profile</Link></li>
        <li><button onClick={handleLogout}>Logout</button></li>
      </ul>
    </div>
  );
};

export default Sidebar;
