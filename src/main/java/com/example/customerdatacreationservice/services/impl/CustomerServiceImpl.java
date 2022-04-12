package com.example.customerdatacreationservice.services.impl;

import com.example.customerdatacreationservice.models.Customer;
import com.example.customerdatacreationservice.repositories.CustomerRepository;
import com.example.customerdatacreationservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createNewCustomer(String name, String surname, String birthDate, String telephoneNo, String email) {
        Customer customer = customerRepository.save(new Customer( name, surname, birthDate, telephoneNo, email));
        if (customer != null) {
            return customer;
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) this.customerRepository.findAll();
    }
}
