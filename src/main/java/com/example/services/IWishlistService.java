package com.example.services;

import com.example.models.dbModels.Wishlist;
import com.example.models.dtoModels.WishlistDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IWishlistService
{
    ResponseEntity<Wishlist> addingProduct(int custId,int prodId);

    List<WishlistDto> getWishlistByCustomerId(int custId);

    ResponseEntity<String> removeProdFromWishlist( int custId, int prodId);

    public ResponseEntity<String> clearWishlist(int custId);

}
