package com.sampletest.repository;

import org.springframework.data.repository.CrudRepository;

import com.sampletest.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
}
