// // src/dashboard/Reviews.js
// import React from 'react';

// const Reviews = () => {
//   return <h2>Reviews Module</h2>;
// };

// export default Reviews;
// src/dashboard/Reviews.js
import React from 'react';
import { Player } from '@lottiefiles/react-lottie-player';
import animationData from '../assets/reviewAnimation.json'; // Adjust the path if needed
import './Reviews.css';

const Reviews = () => {
  return (
    <div className="reviews-wrapper">
      <div className="lottie-animation">
        <Player
  autoplay
  loop
  src={animationData}
  style={{ height: '250px', width: '250px' }}  // increased size
/>

      </div>

      <div className="container mt-5">
        <h2 className="text-center text-primary">Reviews Module</h2>
      </div>
    </div>
  );
};

export default Reviews;

