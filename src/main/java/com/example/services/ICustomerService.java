package com.example.services;

import com.example.models.dbModels.Customers;
import com.example.models.dtoModels.CustomersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICustomerService
{
    ResponseEntity<Customers> addingCustomer(CustomersDto cDto);

    ResponseEntity<Customers> getCustomer(int custId);

    ResponseEntity<List<Customers>> getAllCustomers();

    ResponseEntity<Customers> updateCustomer(int custId, CustomersDto cDto);

    ResponseEntity<String> deleteCustomer(int custId);



}
