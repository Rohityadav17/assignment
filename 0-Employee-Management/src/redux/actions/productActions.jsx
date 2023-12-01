import axios from "axios";

export const fetchProducts = () => (dispatch) => {
  axios
    .get("http://localhost:9090/products/show")
    .then((response) => {
      dispatch({ type: "FETCH_PRODUCTS_SUCCESS", payload: response.data });
    })
    .catch((error) => {
      dispatch({ type: "FETCH_PRODUCTS_FAILURE", payload: error.message });
    });
};

export const deleteProduct = (productId) => (dispatch) => {
  return axios
    .delete(`http://localhost:9090/products/remove/${productId}`)
    .then(() => {
      dispatch({ type: "DELETE_PRODUCT_SUCCESS", payload: productId });
      return Promise.resolve();
    })
    .catch((error) => {
      dispatch({ type: "DELETE_PRODUCT_FAILURE", payload: error.message });
      return Promise.reject(error);
    });
};

export const addProduct = (formData) => (dispatch) => {
  return axios
    .post(`http://localhost:9090/products/jdbc/add`, formData)
    .then((response) => {
      dispatch({ type: "ADD_PRODUCT_SUCCESS", payload: formData });
      return Promise.resolve();
    })
    .catch((error) => {
      dispatch({ type: "ADD_PRODUCT_FAILURE", payload: error.message });
      return Promise.reject(error);
    });
};

export const updateProductAction = (productId, updatedData) => (dispatch) => {
  return axios
    .put(`http://localhost:9090/products/jdbc/update`, updatedData)
    .then(() => {
      dispatch({
        type: "UPDATE_PRODUCT_SUCCESS",
        payload: { productId, updatedData },
      });
      return Promise.resolve();
    })
    .catch((error) => {
      dispatch({ type: "UPDATE_PRODUCT_FAILURE", payload: error.message });
      return Promise.reject(error);
    });
};
