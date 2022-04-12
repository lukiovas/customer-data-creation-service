package com.example.customerdatacreationservice.controllers;

import com.example.customerdatacreationservice.models.Customer;
import com.example.customerdatacreationservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.createNewCustomer(
                customer.getName(), customer.getSurname(), customer.getBirthDate(), customer.getTelephoneNo(), customer.getEmail());
        if (newCustomer != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}