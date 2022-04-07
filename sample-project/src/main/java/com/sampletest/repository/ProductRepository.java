package com.sampletest.repository;

import org.springframework.data.repository.CrudRepository;
import com.sampletest.model.Product;

public interface ProductRepository extends CrudRepository<Product, String>
{
}
