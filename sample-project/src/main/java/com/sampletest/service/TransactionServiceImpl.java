package com.sampletest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampletest.model.Customer;
import com.sampletest.model.Product;
import com.sampletest.model.Transaction;
import com.sampletest.repository.CustomerRepository;
import com.sampletest.repository.ProductRepository;
import com.sampletest.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Transaction> getAllTransactions(){
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactionRepository.findAll().forEach(transaction -> transactions.add(transaction));
		return transactions;
	}

	@Override
	public List<Transaction> insertAll(List<Transaction> t) {
		return (List<Transaction>)transactionRepository.saveAll(t);
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}
	
	@Override
	public List<Product> getAllProductos(){
		List<Product> productos = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> {
			if(product.getStatus().equalsIgnoreCase("Active")) {
				productos.add(product);
			}
		});
		return productos;
	}
	
	@Override
	public int soldToAusTransactions() {
		List<Integer> ausCustomers = new ArrayList<Integer>();
	
		getAllCustomers().forEach(c -> {
			if(c.getLocation().equalsIgnoreCase("Australia")) {
				ausCustomers.add(c.getCustomerId());
			}
		});
		
		List<Transaction> ausTransactionsList = getAllTransactions()
				.stream()
				.filter(t -> 
				ausCustomers.contains(t.getCustomerId()))
				.collect(Collectors.toList());

		return ausTransactionsList != null ? ausTransactionsList.size() : 0;
	}
	
	@Override
	public Map<String,Integer> getTransactionCostPerProduct(){
			
		List<String> transactionProducts = new ArrayList<String>();
		
		getAllTransactions().forEach(c -> {
			transactionProducts.add(c.getProductCode());	
		});
		
		Map<String, Integer> costPerProduct = new HashMap<String, Integer>();
		
		getAllProductos().forEach(activeProd ->{
			String p = activeProd.getProductCode();
			int count = (int)transactionProducts.stream().filter(f -> f.equalsIgnoreCase(p)).count();	
			costPerProduct.put(p, count*activeProd.getCost());
			System.out.println("p -> "+p +" count "+count*activeProd.getCost());
		});
		
		return costPerProduct;
	}
	
	@Override
	public Map<Integer,Integer> getTransactionCostPerCustomer(){
			
		Map<Integer,List<Integer>> customerTransactionCostMap = new HashMap<Integer, List<Integer>>();
		
		getAllTransactions().forEach(c -> {
			
			if(!customerTransactionCostMap.containsKey(c.getCustomerId())){
				List<Integer> totalCost = new ArrayList<>();
				getAllTransactions().forEach(t -> {
					if(c.getCustomerId() == t.getCustomerId()) {
						getAllProductos().forEach(activeProd ->{
							String p = activeProd.getProductCode();
							if(p.equalsIgnoreCase(t.getProductCode())) {
								totalCost.add(activeProd.getCost());
								System.out.println("getCustomerId -> "+t.getCustomerId() +" totalCost "+totalCost);
								customerTransactionCostMap.put(t.getCustomerId(),totalCost);
							}
						});
					}
				});
			}
		});
		
		Map<Integer,Integer> customerTransactionCost = new HashMap<Integer,Integer>();
		for (Entry<Integer, List<Integer>> entry : customerTransactionCostMap.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		    int count =entry.getValue().stream().mapToInt( i ->i).sum();
		    System.out.println("final val:: "+entry.getKey() + "/" + count);
		    customerTransactionCost.put(entry.getKey(), count);
		}
		return customerTransactionCost;
	}
}