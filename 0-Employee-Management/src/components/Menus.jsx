import React from "react";
import { ListGroup, ListGroupItem } from "reactstrap";
import { Link } from "react-router-dom";

function Menus() {
  return (
    <ListGroup>
      <Link
        className="list-group-item list-group-item-action"
        tag="a"
        to="/home"
        action
      >
        Home
      </Link>
      <Link
        className="list-group-item list-group-item-action"
        tag="a"
        to="/add-product"
        action
      >
        Add Product
      </Link>
      <Link
        className="list-group-item list-group-item-action"
        tag="a"
        to="/view-products"
        action
      >
        View Products
      </Link>
      <Link
        className="list-group-item list-group-item-action"
        tag="a"
        to="/About"
        action
      >
        About
      </Link>
      <Link
        className="list-group-item list-group-item-action"
        tag="a"
        to="/Contact"
        action
      >
        Contact
      </Link>
    </ListGroup>
  );
}

export default Menus;
