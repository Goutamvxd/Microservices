package com.banking.app.banking.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "account", schema = "online_bank")
public class Account {

	@Id
	@GeneratedValue

	private long id;
	private String sortCode;
	private String accountNumber;
	private double currentBalance;
	private String bankName;
	private String ownerName;
	private transient List<Transaction> transactions;

	public Account(long id, String sortCode, String accountNumber, double currentBalance, String bankName,
			String ownerName) {
		super();
		this.id = id;
		this.sortCode = sortCode;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.ownerName = ownerName;
	}

	public Account(String bankName, String ownerName, String generatedSortCode, String generatedAccontNumber,
			double currentBalance) {

		this.sortCode = generatedSortCode;
		this.accountNumber = generatedAccontNumber;
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.ownerName = ownerName;
	}

	public Account(long id, String sortCode, String accountNumber, double currentBalance, String bankName,
			String ownerName, List<Transaction> transactions) {
		super();
		this.id = id;
		this.sortCode = sortCode;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.ownerName = ownerName;
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", sortCode=" + sortCode + ", accountNumber=" + accountNumber + ", currentBalance="
				+ currentBalance + ", bankName=" + bankName + ", ownerName=" + ownerName + "]";
	}

}
