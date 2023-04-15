import React from 'react';

function UserData({ username, handleLogout }) {
  return (
    <div>
      <h1>Welcome, {username}!</h1>
      <button onClick={handleLogout}>Log Out</button>
      {/* TODO: Display user data */}
    </div>
  );
}

export default UserData;