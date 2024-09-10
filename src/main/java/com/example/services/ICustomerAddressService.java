package com.example.services;

import com.example.models.dbModels.CustomerAddresses;
import com.example.models.dtoModels.CustomerAddressDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICustomerAddressService
{
    ResponseEntity<CustomerAddresses> addingAddress(int custId, CustomerAddressDto cADto);

    ResponseEntity<CustomerAddressDto> getOneAddress(int addId);

    ResponseEntity<List<CustomerAddressDto>> getAllAddresses(int custId);

    ResponseEntity<String> updateAddress(int addId, CustomerAddressDto cADto);

    ResponseEntity<String> deleteAddress(int addId);
}
