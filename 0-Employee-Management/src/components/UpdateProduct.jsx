import React, { useState, useEffect, useRef } from "react";
import { connect, useDispatch } from "react-redux";
import { useParams, useNavigate } from "react-router-dom";
import { updateProductAction } from "../redux/actions/productActions";

const UpdateProduct = ({ products }) => {
  const { productId } = useParams();
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const isFirstRender = useRef(true);

  const [formData, setFormData] = useState({
    productId: "",
    productName: "",
    productCost: 0.0,
    productCategory: "",
    productDescription: "",
  });

  useEffect(() => {
    if (isFirstRender.current) {
      console.log("Inside useEffect of Update product");
      const existingProduct = products.find(
        (product) => product.productId === parseInt(productId)
      );

      if (existingProduct) {
        setFormData({
          productId: existingProduct.productId,
          productName: existingProduct.productName,
          productCost: existingProduct.productCost,
          productCategory: existingProduct.productCategory,
          productDescription: existingProduct.productDescription,
        });
      }

      isFirstRender.current = false;
    }
  }, [products, productId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    console.log("Inside Handle Submit");
    e.preventDefault();
    dispatch(updateProductAction(productId, formData));
    setFormData({
      productId: "",
      productName: "",
      productCost: 0.0,
      productCategory: "",
      productDescription: "",
    });
    navigate("/view-products");
    console.log("Handle Submit Executed");
  };

  return (
    <div>
      <h1>Update Product Component</h1>
      <form onSubmit={handleSubmit}>
        <label>Product Name:</label>
        <input
          type="text"
          name="productName"
          value={formData.productName}
          onChange={handleInputChange}
        />
        <label>Product Cost:</label>
        <input
          type="text"
          name="productCost"
          value={formData.productCost}
          onChange={handleInputChange}
        />
        <label>Product Category:</label>
        <input
          type="text"
          name="productCategory"
          value={formData.productCategory}
          onChange={handleInputChange}
        />
        <label>Product Description:</label>
        <input
          type="text"
          name="productDescription"
          value={formData.productDescription}
          onChange={handleInputChange}
        />
        <button type="submit">Update Product</button>
      </form>
    </div>
  );
};

const mapStateToProps = (state) => ({
  products: state.products.products,
});

export default connect(mapStateToProps, { updateProductAction })(UpdateProduct);
