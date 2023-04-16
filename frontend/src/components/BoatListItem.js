import React from 'react';

const BoatListItem = ({ boat, handleDelete, handleEdit }) => {
  return (
    <div>
      <h3>{boat.name}</h3>
      <p>{boat.description}</p>
      <p>Quantity: {boat.quantity}</p>
      <button onClick={() => handleEdit(boat)}>Edit</button>
      <button onClick={() => handleDelete(boat.id)}>Delete</button>
    </div>
  );
};

export default BoatListItem;
