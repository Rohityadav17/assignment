import React from "react";
import "../App.css";
import { Button } from "reactstrap";
import Header from "./Header";

function Home() {
  return (
    <>
      <div className="jumbotron text-center">
        <h1>Products Management System</h1>
        <p>
          This application is developed by Mr.Rohit Sanjay Yadav for learning
          purpose, cloning or duplicating this will be considered as violation
          of piracy policy under article 213 of indian penal court
        </p>
        <Button color="primary">Click</Button>
      </div>
    </>
  );
}

export default Home;
