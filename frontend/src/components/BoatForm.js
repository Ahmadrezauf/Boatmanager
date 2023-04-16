import React, { useState } from 'react';

const BoatForm = ({ handleSubmit }) => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [quantity, setQuantity] = useState(0);

  const submitForm = e => {
    e.preventDefault();
    const boat = {
      name,
      description,
      quantity
    };
    handleSubmit(boat);
    setName('');
    setDescription('');
    setQuantity(0);
  };

  return (
    <form onSubmit={submitForm}>
      <h2>Add Boat</h2>
      <label>
        Name:
        <input type="text" value={name} onChange={e => setName(e.target.value)} />
      </label>
      <label>
        Description:
        <input type="text" value={description} onChange={e => setDescription(e.target.value)} />
      </label>
      <label>
        Quantity:
        <input type="number" value={quantity} onChange={e => setQuantity(parseInt(e.target.value))} />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default BoatForm;
