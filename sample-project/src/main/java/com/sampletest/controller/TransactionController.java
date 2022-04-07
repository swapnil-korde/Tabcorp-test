package com.sampletest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sampletest.model.Transaction;
import com.sampletest.service.TransactionService;

@RestController
public class TransactionController{
	
	@Autowired
	TransactionService transactionService;
	
	private static final String REQUEST_NO_BODY = "Request does not contain a body";
	
	@GetMapping("/transaction")
	private List<Transaction> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	@PostMapping("/transaction")
	private String saveTransaction(@RequestBody List<Transaction> transactions){
		
		if(transactions != null && !transactions.isEmpty()) {
			transactionService.insertAll(transactions);
			return String.format("Added %d transactions.", transactions.size());
		}else {
			return REQUEST_NO_BODY;
		}
	}
	
	@GetMapping("/aus-transactions")
	private int getTransactionsSoldToAus() {
		return transactionService.soldToAusTransactions();
	}
	
	@GetMapping("/product-cost")
	private Map<String, Integer> getTransactionCostPerProduct() {
		return transactionService.getTransactionCostPerProduct();
	}
	
	@GetMapping("/customer-cost")
	private Map<Integer, Integer> getTransactionCostPerCustomer() {
		return transactionService.getTransactionCostPerCustomer();
	}
}
