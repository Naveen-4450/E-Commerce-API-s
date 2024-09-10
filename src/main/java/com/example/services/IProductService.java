package com.example.services;

import com.example.enums.Stock;
import com.example.models.dbModels.Products;
import com.example.models.dtoModels.ProductsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

public interface IProductService
{
    ResponseEntity<Products> addingProduct(ProductsDto pDto,int cateId) throws IOException;

    ResponseEntity<String> deletingProduct(int prodId);

    public ResponseEntity<String> updateProdAvail(int prodId);

    public ResponseEntity<String> updateProdNotAvail(int prodId);

    public ResponseEntity<String> updateProductDiscount(int prodId, int discount);

    public ResponseEntity<String> updateProductPrice(int prodId, Double price);

    public ResponseEntity<Products> getProduct(int prodId);

    public ResponseEntity<List<Products>> getAllProducts();


}
/* ResponseEntity<List<Products>> addingMultipleProducts(List<ProductsDto> pDto, int cateId) throws IOException;
 */