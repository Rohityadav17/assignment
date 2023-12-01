import "./styles/App.css";
import FooterComponent from "./components/FooterComponent";
import Home from "./components/Home";
import Header from "./components/Header";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AddProduct from "./components/AddProduct";
import ViewProducts from "./components/ViewProducts";
import UpdateProduct from "./components/UpdateProduct";
import LoginForm from "./components/LoginForm";
import { Container, Row, Col } from "reactstrap";
import Register from "./components/Register";
import { Provider } from "react-redux";
import store from "./redux/store";

function App() {
  return (
    <Provider store={store}>
      <div id="app-container">
        <Router>
          <Header />
          <Container className="content">
            <Routes>
              <Route path="/" Component={ViewProducts} exact />
              <Route
                path="/update/:productId"
                Component={UpdateProduct}
                exact
              />
              <Route path="/home" Component={Home} exact />
              <Route path="/login" Component={LoginForm} exact />
              <Route path="/add-product" Component={AddProduct} exact />
              <Route path="/view-products" Component={ViewProducts} exact />
              <Route path="/signup" Component={Register} exact />
            </Routes>
          </Container>
          <FooterComponent class="footer" />
        </Router>
      </div>
    </Provider>
  );
}

export default App;
