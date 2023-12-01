import React, { useEffect } from "react";
import { connect, useDispatch } from "react-redux";
import { fetchProducts, deleteProduct } from "../redux/actions/productActions";
import { Table, Button } from "reactstrap";
import { useNavigate } from "react-router-dom";

const ViewProducts = ({ products, error, fetchProducts }) => {
  useEffect(() => {
    fetchProducts();
  }, [fetchProducts]);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const handleDelete = (productId) => {
    dispatch(deleteProduct(productId));
  };

  const handleUpdate = (productId) => {
    navigate("update/productId");
  };

  return (
    <div>
      <h1>View Products Component</h1>
      {error && <p>Error: {error}</p>}
      <Table striped responsive>
        <thead>
          <tr>
            <th>Product Id</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Category</th>
            <th>Description</th>
            <th>Action</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.productId}>
              <td>{product.productId}</td>
              <td>{product.productName}</td>
              <td>{product.productCost}</td>
              <td>{product.productCategory}</td>
              <td>{product.productDescription}</td>
              <td>
                <Button
                  color="primary"
                  onClick={() => handleUpdate(product.productId)}
                >
                  Update
                </Button>
              </td>
              <td>
                <Button
                  color="danger"
                  onClick={() => handleDelete(product.productId)}
                >
                  Delete
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

const mapStateToProps = (state) => ({
  products: state.products.products,
  error: state.products.error,
});

export default connect(mapStateToProps, { fetchProducts })(ViewProducts);
