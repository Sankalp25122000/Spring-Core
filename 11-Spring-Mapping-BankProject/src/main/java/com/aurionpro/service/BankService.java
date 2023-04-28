package com.aurionpro.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Bank;

public interface BankService {

	ResponseEntity<String> saveBank(Bank bankData);

	Bank getBankById(Long bankId);

	List<Bank> getBanks();

	ResponseEntity<String> updateBankDetails(Bank bankData);


	ResponseEntity<String> addAccount(Bank bankData);

	Page<Bank> getBankPagination(int pageNumber, int pageSize);

	Page<Bank> getBankPaginationInSort(int pageNumber, int pageSize, String sortProperty);

}
