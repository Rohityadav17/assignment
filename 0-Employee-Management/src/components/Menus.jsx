import React from "react";
import { ListGroup, ListGroupItem } from "reactstrap";

function Menus() {
  return (
    <ListGroup>
      <ListGroupItem tag="a" href="/" action>
        Home
      </ListGroupItem>
      <ListGroupItem tag="a" href="/add-product" action>
        Add Product
      </ListGroupItem>
      <ListGroupItem tag="a" href="/view-products" action>
        View Products
      </ListGroupItem>
      <ListGroupItem tag="a" href="/update" action>
        Update Product
      </ListGroupItem>
      <ListGroupItem tag="a" href="/About" action>
        About
      </ListGroupItem>
      <ListGroupItem tag="a" href="/Contact" action>
        Contact
      </ListGroupItem>
    </ListGroup>
  );
}

export default Menus;
