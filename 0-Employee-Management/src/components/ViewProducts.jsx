import React, { useEffect, useRef } from "react";
import { useSelector, useDispatch } from "react-redux";
import { fetchProducts, deleteProduct } from "../redux/actions/productActions";
import { Table, Button } from "reactstrap";
import { useNavigate } from "react-router-dom";

const ViewProducts = () => {
  const products = useSelector((state) => state.products.products);
  const error = useSelector((state) => state.products.error);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const hasFetchedData = useRef(false);

  useEffect(() => {
    if (!hasFetchedData.current) {
      console.log("inside useEffect of view products");
      dispatch(fetchProducts());
      hasFetchedData.current = true;
    }
  }, [dispatch]);

  const handleDelete = (productId) => {
    dispatch(deleteProduct(productId));
  };

  const handleUpdate = (productId) => {
    navigate(`/update/${productId}`);
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

export default ViewProducts;
