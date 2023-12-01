const initialState = {
  products: [],
  error: null,
};

const productReducer = (state = initialState, action) => {
  switch (action.type) {
    case "FETCH_PRODUCTS_SUCCESS":
      return {
        ...state,
        products: action.payload,
        error: null,
      };

    case "FETCH_PRODUCTS_FAILURE":
      return {
        ...state,
        products: [],
        error: action.payload,
      };

    case "DELETE_PRODUCT_SUCCESS":
      const deletedProducts = state.products.filter(
        (product) => product.productId !== action.payload
      );
      return {
        ...state,
        products: deletedProducts,
        error: null,
      };

    case "DELETE_PRODUCT_FAILURE":
      return {
        ...state,
        error: action.payload,
      };

    case "ADD_PRODUCTS_SUCCESS":
      return {
        ...state,
        products: action.payload,
        error: null,
      };

    case "ADD_PRODUCTS_FAILURE":
      return {
        ...state,
        products: [],
        error: action.payload,
      };

    case "UPDATE_PRODUCT_SUCCESS":
      const updatedProducts = state.products.map((product) =>
        product.productId === action.payload.productId
          ? { ...product, ...action.payload.updatedData }
          : product
      );
      return {
        ...state,
        products: updatedProducts,
        error: null,
      };

    case "UPDATE_PRODUCT_FAILURE":
      return {
        ...state,
        error: action.payload,
      };
    default:
      return state;
  }
};
export default productReducer;
