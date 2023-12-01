import "./styles/App.css";
import FooterComponent from "./components/FooterComponent";
import Home from "./components/Home";
import Header from "./components/Header";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AddProduct from "./components/AddProduct";
import ViewProducts from "./components/ViewProducts";
import UpdateProducts from "./components/UpdateProducts";
import LoginForm from "./components/LoginForm";
import { Container, Row, Col } from "reactstrap";
import Register from "./components/Register";
import { Provider } from "react-redux";
import store from "./redux/store";

function App() {
  return (
    <div>
      <Provider store={store}>
        <Router>
          <Header />
          <Container>
            <Routes>
              <Route path="/" Component={ViewProducts} exact />
              <Route
                path="/update/productId"
                Component={UpdateProducts}
                exact
              />
              <Route path="/home" Component={Home} exact />
              <Route path="/login" Component={LoginForm} exact />
              <Route path="/add-product" Component={AddProduct} exact />
              <Route path="/view-products" Component={ViewProducts} exact />
              <Route path="/signup" Component={Register} exact />
            </Routes>
          </Container>
          <FooterComponent />
        </Router>
      </Provider>
    </div>
  );
}

export default App;
