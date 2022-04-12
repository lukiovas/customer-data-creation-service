package com.example.customerdatacreationservice.services;

import com.example.customerdatacreationservice.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer createNewCustomer(String name, String surname, String birthDate, String telephoneNo, String email);

    List<Customer> getAllCustomers();
}
