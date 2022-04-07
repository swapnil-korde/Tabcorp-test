package com.sampletest.repository;

import org.springframework.data.repository.CrudRepository;
import com.sampletest.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
}
