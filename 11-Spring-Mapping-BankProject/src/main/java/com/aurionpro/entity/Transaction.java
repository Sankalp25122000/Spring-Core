package com.aurionpro.entity;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Transactional
@Table(name = "transaction_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_no")
	private Long transactionNo;

	private String transactionType;
	private String transactionDetail;
	private String transactionDate;
	private double amount;
	private double balance;

	@ManyToOne
	@JoinColumn(name = "fk_account_no")
	@JsonIgnore
	private Accounts accounts;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionNo, String transactionType, String transactionDetail, String transactionDate,
			double amount, double balance, Accounts accounts) {
		super();
		this.transactionNo = transactionNo;
		this.transactionType = transactionType;
		this.transactionDetail = transactionDetail;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.balance = balance;
		this.accounts = accounts;
	}

	public Long getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Long transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionDetail() {
		return transactionDetail;
	}

	public void setTransactionDetail(String transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Transaction [transactionNo=" + transactionNo + ", transactionType=" + transactionType
				+ ", transactionDetail=" + transactionDetail + ", transactionDate=" + transactionDate + ", amount="
				+ amount + ", balance=" + balance + ", accounts=" + accounts + "]";
	}

}