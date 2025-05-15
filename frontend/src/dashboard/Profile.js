import React from 'react';

const Profile = () => {
  const user = JSON.parse(localStorage.getItem('user'));

  return (
    <div className="container mt-5">
      <div className="card shadow p-4">
        <h2 className="card-title text-center text-primary mb-4">My Profile</h2>
        <div className="card-body">
          <p className="mb-3"><strong>Name:</strong> {user?.name}</p>
          <p className="mb-3"><strong>Email:</strong> {user?.email}</p>
          <p className="mb-3"><strong>Branch:</strong> {user?.branch}</p>
          <p className="mb-3"><strong>Role:</strong> {user?.role}</p>
          <p className="mb-3"><strong>Interests:</strong> {user?.interests}</p>
        </div>
      </div>
    </div>
  );
};

export default Profile;
