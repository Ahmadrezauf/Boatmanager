import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import axios from 'axios';
import { useAuth } from '../utils/auth';
import { getBoatsByUserId } from '../utils/api';


function UserBoatsForm(props) {
  const { boat, onSubmit, onCancel } = props;
  const [boatName, setBoatName] = useState(boat ? boat.name : '');
  const [boatType, setBoatType] = useState(boat ? boat.type : '');
  const [boatDescription, setBoatDescription] = useState(boat ? boat.description : '');
  const [boatQuantity, setBoatQuantity] = useState(boat ? boat.quantity : '');
  const { authTokens } = useAuth();

  const handleSubmit = async (event) => {
    event.preventDefault();
    const boatData = {
      name: boatName,
      type: boatType,
      description: boatDescription,
      quantity: boatQuantity,
    };
    try {
      let res;
      if (boat) {
        res = await axios.put(`/api/boats/${boat.id}`, boatData, {
          headers: {
            Authorization: `Bearer ${authTokens.accessToken}`,
          },
        });
      } else {
        res = await axios.post('/api/boats', boatData, {
          headers: {
            Authorization: `Bearer ${authTokens.accessToken}`,
          },
        });
      }
      onSubmit(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group controlId="formBoatName">
        <Form.Label>Name</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter name"
          value={boatName}
          onChange={(e) => setBoatName(e.target.value)}
        />
      </Form.Group>
      <Form.Group controlId="formBoatType">
        <Form.Label>Type</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter type"
          value={boatType}
          onChange={(e) => setBoatType(e.target.value)}
        />
      </Form.Group>
      <Form.Group controlId="formBoatDescription">
        <Form.Label>Description</Form.Label>
        <Form.Control
          as="textarea"
          rows={3}
          placeholder="Enter description"
          value={boatDescription}
          onChange={(e) => setBoatDescription(e.target.value)}
        />
      </Form.Group>
      <Form.Group controlId="formBoatQuantity">
        <Form.Label>Quantity</Form.Label>
        <Form.Control
          type="text"
          placeholder="Enter quantity"
          value={boatQuantity}
          onChange={(e) => setBoatQuantity(e.target.value)}
        />
      </Form.Group>
      <Button variant="primary" type="submit" className="mr-2">
        {boat ? 'Update' : 'Add'}
      </Button>
      <Button variant="secondary" onClick={onCancel}>
        Cancel
      </Button>
    </Form>
  );
}

export default UserBoatsForm;
