// src/dashboard/Profile.js
import React from 'react';

const Profile = () => {
  const user = JSON.parse(localStorage.getItem('user'));

  return (
    <div>
      <h2>My Profile</h2>
      <p><strong>Name:</strong> {user?.name}</p>
      <p><strong>Email:</strong> {user?.email}</p>
      <p><strong>Branch:</strong> {user?.branch}</p>
      <p><strong>Role:</strong> {user?.role}</p>
      <p><strong>Interests:</strong> {user?.interests}</p>
    </div>
  );
};

export default Profile;
