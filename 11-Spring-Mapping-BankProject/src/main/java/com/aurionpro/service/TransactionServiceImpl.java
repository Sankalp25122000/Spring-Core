package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Transaction;
import com.aurionpro.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public ResponseEntity<String> saveTransaction(Transaction transactionData) {
		transactionRepository.save(transactionData);
		return ResponseEntity.ok("Transaction data saved");
	}

	@Override
	public Transaction getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId).get();
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateTransactionDetails(Transaction transactionData) {
		transactionRepository.save(transactionData);
		return ResponseEntity.ok("Transaction data updated");
	}

}
