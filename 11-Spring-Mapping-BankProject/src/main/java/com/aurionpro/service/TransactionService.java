package com.aurionpro.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Transaction;

public interface TransactionService {

	ResponseEntity<String> saveTransaction(Transaction transactionData);

	Transaction getTransactionById(Long transactionId);

	List<Transaction> getTransactions();

	ResponseEntity<String> updateTransactionDetails(Transaction transactionData);

	Page<Transaction> getTransactionPagination(int pageNumber, int pageSize);

	Page<Transaction> getTransactionPaginationInSort(int pageNumber, int pageSize, String sortProperty);

}
