import React, { useState } from "react";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import { useDispatch } from "react-redux";
import { addProduct } from "../redux/actions/productActions";
import { useNavigate } from "react-router-dom";

const AddProduct = ({ onSubmit }) => {
  const [formData, setFormData] = useState({
    productId: 0,
    productName: "",
    productCost: 0.0,
    productCategory: "",
    productDescription: "",
  });

  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(addProduct(formData))
      .then(() => {
        navigate("/view-products");
      })
      .catch((error) => {
        console.error("Failed to add product:", error);
      });
  };

  return (
    <Form onSubmit={handleSubmit}>
      <FormGroup>
        <Label for="productName">Product Name</Label>
        <Input
          type="text"
          name="productName"
          id="productName"
          placeholder="Enter product name"
          value={formData.productName}
          onChange={handleInputChange}
        />
      </FormGroup>
      <FormGroup>
        <Label for="productCost">Product Cost</Label>
        <Input
          type="number"
          name="productCost"
          id="productCost"
          placeholder="Enter product cost"
          value={formData.productCost}
          onChange={handleInputChange}
        />
      </FormGroup>
      <FormGroup>
        <Label for="productCategory">Product Category</Label>
        <Input
          type="text"
          name="productCategory"
          id="productCategory"
          placeholder="Enter product category"
          value={formData.productCategory}
          onChange={handleInputChange}
        />
      </FormGroup>
      <FormGroup>
        <Label for="productDescription">Product Description</Label>
        <Input
          type="textarea"
          name="productDescription"
          id="productDescription"
          placeholder="Enter product description"
          value={formData.productDescription}
          onChange={handleInputChange}
        />
      </FormGroup>
      <Button color="primary" type="submit">
        Add To Cart
      </Button>
    </Form>
  );
};

export default AddProduct;
