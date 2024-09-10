package com.example.services;

import com.example.models.dbModels.Cart;
import com.example.models.dtoModels.CartDto;
import org.springframework.http.ResponseEntity;

public interface ICartService
{
    ResponseEntity<String> addProductToCart(int prodId, int custId, int quantity);

    ResponseEntity<CartDto> viewCustomerCart(int custId);

    ResponseEntity<String> updateProductQuantity(int prodId,int custId,int quantity);

    ResponseEntity<String> removeProductFromCart(int prodId, int custId);

    ResponseEntity<String> clearCart(int custId);
}
