package com.example.controllers;

import com.example.models.dbModels.Wishlist;
import com.example.models.dtoModels.WishlistDto;
import com.example.repositories.WishlistRepository;
import com.example.services.WishlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Wishlist Controller API's", description = "This API's are Managed to Customers Wishlists in Application")
@Slf4j
public class WishlistController
{
    @Autowired
    private WishlistService wishlistSer;


    @Operation(summary = "Get Wishlist by customer Id", description = "Get Wishlist products of a Customer by customer Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Wishlist Retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Wishlist Not found/ products Not found in wishlist")
    })
    @GetMapping("/wishlist/{custId}")
    public ResponseEntity<List<WishlistDto>> getWishlistByCustomerId(@PathVariable int custId)
    {
        log.info("Fetching wishlist for customer ID:{}",custId);
        List<WishlistDto> wishlist = wishlistSer.getWishlistByCustomerId(custId);
        if (wishlist.isEmpty()) {
            log.warn("No products found in wishlist for customer ID:{}",custId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            log.info("Wishlist retrieved successfully for customer ID: {}", custId);
            return new ResponseEntity<>(wishlist, HttpStatus.OK);
        }
    }


    @Operation(summary = "Add a Product to wishlist by product Id", description = "Adding a Product to a Customer Wishlist by Product Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Added in Customer Wishlist Successfully"),
            @ApiResponse(responseCode = "404", description = "Customer/product Not found")
    })
    @PostMapping("/{custId}/add/{prodId}")
    public ResponseEntity<Wishlist> addingProduct(@PathVariable int custId, @PathVariable int prodId)
    {
        return wishlistSer.addingProduct(custId,prodId);
    }


    @Operation(summary = "Remove a Product in customer Wishlist by ProductId", description = "Removing a Product From a customer Wishlist by ProductId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Removed From a Customer wishlist"),
            @ApiResponse(responseCode = "404", description = "Product Not Available in wishlist(check-->Product Id)")
    })
    @DeleteMapping("/wishlist/{custId}/remove/{prodId}")
    public ResponseEntity<String> removeProdFromWishlist(@PathVariable int custId, @PathVariable int prodId)
    {
        return wishlistSer.removeProdFromWishlist(custId,prodId);
    }


    @Operation(summary = "Clear Customer Wishlist by customer Id", description = "Deleting all the Products from a customer wishlist by Using Customer Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "wishlist Cleared Successfully")
    })
    @DeleteMapping("/clear/{custId}")
    public ResponseEntity<String> clearWishlist(@PathVariable int custId)
    {
        return wishlistSer.clearWishlist(custId);
    }
}
