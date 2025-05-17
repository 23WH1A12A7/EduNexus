import React from 'react';
import { useNavigate } from 'react-router-dom';
import Lottie from 'lottie-react';
import animationData from '../assets/edu-animation.json';
import './Homepage.css';

const HomePage = () => {
  const navigate = useNavigate();

  return (
    <div className="homepage-container">
      <div className="homepage-left">
        <h1 className="homepage-title">EduNexus</h1>
        <p className="homepage-subtitle">Empowering Learning, Connecting Minds</p>
        <div className="homepage-buttons">
          <button onClick={() => navigate('/login')}>Login</button>
          <button onClick={() => navigate('/register')}>Register</button>
        </div>
      </div>
      <div className="homepage-right">
        <Lottie animationData={animationData} loop={true} className="homepage-lottie" />
      </div>
    </div>
  );
};

export default HomePage;
