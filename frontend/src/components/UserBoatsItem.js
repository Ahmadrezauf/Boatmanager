import React from 'react';

const UserBoatsItem = ({ boat, onEdit }) => {
  return (
    <div className="boat-item">
      <div className="boat-item-details">
        <h3>{boat.name}</h3>
        <p>Quantity: {boat.quantity}</p>
        <p>Description: {boat.description}</p>
      </div>
      <div className="boat-item-actions">
        <button onClick={() => onEdit(boat)}>Edit</button>
      </div>
    </div>
  );
};

export default UserBoatsItem;
