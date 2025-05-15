import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Sidebar.css'; // Optional: additional custom styling

const Sidebar = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/login');
  };

  return (
    <div className="sidebar p-3 bg-light" style={{ minHeight: '100vh' }}>
      <h2 className="logo mb-4 text-primary">EduNexus</h2>
      <div className="d-grid gap-2">
        <Link to="/dashboard/items" className="btn btn-outline-primary">Item Exchange</Link>
        <Link to="/dashboard/mentorship" className="btn btn-outline-primary">Mentorship</Link>
        <Link to="/dashboard/reviews" className="btn btn-outline-primary">Reviews</Link>
        <Link to="/dashboard/messages" className="btn btn-outline-primary">Messages</Link>
        <Link to="/dashboard/Feedback" className="btn btn-outline-primary">Feedback</Link>
        <Link to="/dashboard/profile" className="btn btn-outline-primary">Profile</Link>
        
        <button onClick={handleLogout} className="btn btn-danger">Logout</button>
      </div>
    </div>
  );
};

export default Sidebar;
