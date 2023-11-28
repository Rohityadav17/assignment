import React from "react";
import "../styles/App.css";
import Header from "./Header";
import Menus from "./Menus";
import { Container, Row, Col } from "reactstrap";

function Home() {
  return (
    <>
      <div>
        <Row>
          <Col md={2}>
            <Menus />
          </Col>
          <Col md={10}>
            <div className="homestyle text-center">
              <h1>Products Management System</h1>
              <p>
                This application is developed by Mr.Rohit Sanjay Yadav for
                learning purpose, cloning or duplicating this will be considered
                as violation of piracy policy under article 213 of indian penal
                court
              </p>
            </div>
          </Col>
        </Row>
      </div>
    </>
  );
}

export default Home;
