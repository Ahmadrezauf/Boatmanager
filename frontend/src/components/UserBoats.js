import React, { useState, useEffect } from 'react';
import UserBoatsItem from './UserBoatsItem';
import UserBoatsForm from './UserBoatsForm';
import { useAuth } from '../utils/auth';

const UserBoats = () => {
  const [boats, setBoats] = useState([]);
  const [adding, setAdding] = useState(false);
  const [editing, setEditing] = useState(false);
  const [selectedBoat, setSelectedBoat] = useState(null);
  const { authTokens } = useAuth();

  useEffect(() => {
    fetch('/api/boats', {
      headers: {
        Authorization: `Bearer ${authTokens}`
      }
    })
      .then(res => res.json())
      .then(data => setBoats(data));
  }, [adding, editing, authTokens]);

  const handleAddBoat = () => {
    setSelectedBoat(null);
    setAdding(true);
    setEditing(false);
  };

  const handleEditBoat = (boat) => {
    setSelectedBoat(boat);
    setAdding(false);
    setEditing(true);
  };

  const handleCancel = () => {
    setSelectedBoat(null);
    setAdding(false);
    setEditing(false);
  };

  return (
    <div className="user-boats">
      <h2>Your Boats</h2>
      <button className="add-boat-btn" onClick={handleAddBoat}>Add a boat</button>
      {adding && <UserBoatsForm onCancel={handleCancel} />}
      {editing && selectedBoat && <UserBoatsForm boat={selectedBoat} onCancel={handleCancel} />}
      <div className="boats-list">
        {boats.map(boat => (
          <UserBoatsItem key={boat.id} boat={boat} onEdit={handleEditBoat} />
        ))}
      </div>
    </div>
  );
};

export default UserBoats;
