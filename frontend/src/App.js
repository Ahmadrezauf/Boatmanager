import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { useAuth } from './utils/auth';
import BoatList from './components/BoatList';
import LoginForm from './components/LoginForm';
import LogoutButton from './components/LogoutButton';
import UserBoats from './components/UserBoats';

function App() {
  const [authTokens, setAuthTokens] = useState();
  const { auth, setAuth } = useAuth();

  useEffect(() => {
    setAuthTokens(localStorage.getItem('tokens'));
  }, []);

  useEffect(() => {
    if (authTokens) {
      setAuth(true);
      localStorage.setItem('tokens', authTokens);
    } else {
      setAuth(false);
      localStorage.removeItem('tokens');
    }
  }, [authTokens]);

  return (
    <Router>
      <div className="container">
        <Switch>
          <Route exact path="/" component={BoatList} />
          <Route exact path="/login" component={LoginForm} />
          <Route exact path="/logout" component={LogoutButton} />
          <Route exact path="/userboats" component={UserBoats} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
