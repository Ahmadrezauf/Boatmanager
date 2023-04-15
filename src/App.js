import React, { useState } from 'react';
import LoginForm from './components/LoginForm';
import UserData from './components/UserData';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (event) => {
    event.preventDefault();
    // TODO: Make API call to authenticate user
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    // TODO: Make API call to log out user
    setIsLoggedIn(false);
  };

  return (
    <div>
      {isLoggedIn ? (
        <UserData username={username} handleLogout={handleLogout} />
      ) : (
        <LoginForm
          username={username}
          password={password}
          setUsername={setUsername}
          setPassword={setPassword}
          handleLogin={handleLogin}
        />
      )}
    </div>
  );
}

export default App;
