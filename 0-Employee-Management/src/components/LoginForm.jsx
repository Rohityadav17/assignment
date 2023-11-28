import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Form, FormGroup, Label, Input, Button, Col, Alert } from "reactstrap";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "../styles/login.css";

const LoginForm = (props) => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const [error, setError] = useState();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("http://localhost:9090/api/v1/user/login", formData)
      .then((res) => {
        console.log("Form submitted:", res.data.status);
        if (res.data.status) {
          navigate("/home");
        }
      })
      .catch((err) => {
        console.error("Login failed:", err);
        setError("Wrong email or password.");
      });
  };

  return (
    <div className="login-container my-3">
      <center>
        <h2>Login</h2>
      </center>
      <Form onSubmit={handleSubmit}>
        <FormGroup>
          <Label for="email">Email:</Label>
          <Input
            type="email"
            name="email"
            id="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </FormGroup>
        <FormGroup>
          <Label for="password">Password:</Label>
          <Input
            type="password"
            name="password"
            id="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </FormGroup>
        <center>
          <Button className="button" color="primary" type="submit">
            Login
          </Button>
        </center>
        {error && (
          <Alert color="danger" className="mt-3">
            <center>{error}</center>
          </Alert>
        )}
      </Form>
    </div>
  );
};

export default LoginForm;
