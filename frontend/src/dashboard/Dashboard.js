import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Sidebar from '../components/Sidebar';
import ItemExchange from './ItemExchange';
import Mentorship from './Mentorship';
import Reviews from './Reviews';
import Messages from './Messages';
import Profile from './profile';
import './Dashboard.css';

const Dashboard = () => {
  const user = JSON.parse(localStorage.getItem('user'));

  if (!user) return <Navigate to="/login" />;

  return (
    <div className="dashboard-wrapper">
      <Sidebar />
      <div className="dashboard-content">
        <Routes>
          <Route path="items" element={<ItemExchange />} />
          <Route path="mentorship" element={<Mentorship />} />
          <Route path="reviews" element={<Reviews />} />
          <Route path="messages" element={<Messages />} />
          <Route path="profile" element={<Profile />} />
          <Route path="*" element={<Navigate to="items" />} />
        </Routes>
      </div>
    </div>
  );
};

export default Dashboard;
