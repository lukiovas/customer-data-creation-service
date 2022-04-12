package com.example.customerdatacreationservice.repositories;

import com.example.customerdatacreationservice.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
