// // src/dashboard/Messages.js
// import React from 'react';

// const Messages = () => {
//   return <h2>Messages Module</h2>;
// };

// export default Messages;
// src/dashboard/Messages.js
import React from 'react';
import { Player } from '@lottiefiles/react-lottie-player';
import animationData from '../assets/messageAnimation.json'; // adjust path as needed
import './Messages.css';

const Messages = () => {
  return (
    <div className="messages-wrapper">
      <div className="lottie-animation">
        <Player
          autoplay
          loop
          src={animationData}
          style={{ height: '100px', width: '100px' }}
        />
      </div>

      <div className="container mt-5">
        <h2 className="text-center text-primary">Messages Module</h2>
      </div>
    </div>
  );
};

export default Messages;
