import React from 'react';
import BoatListItem from './BoatListItem';

const BoatList = ({ boats, handleDelete, handleEdit }) => {
  return (
    <div>
      <h2>Boat List</h2>
      {boats.map(boat => (
        <BoatListItem
          key={boat.id}
          boat={boat}
          handleDelete={handleDelete}
          handleEdit={handleEdit}
        />
      ))}
    </div>
  );
};

export default BoatList;
