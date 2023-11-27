import "./App.css";
import FooterComponent from "./components/FooterComponent";
import { ToastContainer, toast } from "react-toastify";
import Home from "./components/Home";
import Header from "./components/Header";
import { Container, Row, Col } from "reactstrap";
import Menus from "./components/Menus";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AddProduct from "./components/AddProduct";
import ViewProducts from "./components/ViewProducts";
import UpdateProducts from "./components/UpdateProducts";

function App() {
  return (
    <div>
      <Router>
        {/* <ToastContainer /> */}
        <Header />
        <Container>
          <Row>
            <Col md={4}>
              <Menus />
            </Col>
            <Col md={8}>
              <Routes>
                <Route path="/" Component={Home} exact />
                <Route path="/add-product" Component={AddProduct} exact />
                <Route path="/view-products" Component={ViewProducts} exact />
                <Route path="/update" Component={UpdateProducts} exact />
              </Routes>
            </Col>
          </Row>
        </Container>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
