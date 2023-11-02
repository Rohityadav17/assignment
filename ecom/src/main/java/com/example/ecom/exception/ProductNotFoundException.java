package com.example.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// sending customized response for requested source
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
        super(message);
    }

}
