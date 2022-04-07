package com.sampletest.service;

import java.util.List;
import java.util.Map;

import com.sampletest.model.Customer;
import com.sampletest.model.Product;
import com.sampletest.model.Transaction;

public interface TransactionService{
	
	List<Transaction> getAllTransactions();
	List<Transaction> insertAll(List<Transaction> p);
	List<Customer> getAllCustomers();
	List<Product> getAllProductos();
	int soldToAusTransactions();
	Map<String, Integer> getTransactionCostPerProduct();
	Map<Integer, Integer> getTransactionCostPerCustomer();

}