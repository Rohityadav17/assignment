import React, { useState } from "react";
import { Button, Card, CardBody, Row, Col, Container } from "reactstrap";
import LoginForm from "./LoginForm";
import { useNavigate } from "react-router-dom";

function Header() {
  const navigate = useNavigate();

  const handleSignUp = () => {
    navigate("/signup");
  };

  const handleLogin = () => {
    navigate("/login");
  };

  return (
    <div>
      <Card className="my-2 bg-warning">
        <CardBody>
          <Row className="align-items-center">
            <Col xs="6" className="text-center">
              <h1 className="my-2">Welcome To Products Management System</h1>
            </Col>
            <Col xs="6" className="d-flex justify-content-end">
              <Button className="mx-2" color="primary" onClick={handleLogin}>
                Login
              </Button>
              <Button color="success" onClick={handleSignUp}>
                Sign Up
              </Button>
            </Col>
          </Row>
        </CardBody>
      </Card>
    </div>
  );
}

export default Header;
