package com.banking.app.banking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.banking.models.Account;
import com.banking.app.banking.repository.AccountRepository;
import com.banking.app.banking.repository.TransactionRepository;
import com.banking.app.banking.utils.CodeGenerator;

@Service
public class AccountService {

	@Autowired
	private  AccountRepository accountRepository;

	@Autowired
	private  TransactionRepository transactionRepository;

	public Account getAccount(String sortCode, String accountNumber) {
		Optional<Account> account = accountRepository.findBySortCodeAndAccountNumber(sortCode, accountNumber);

		account.ifPresent(value -> value
				.setTransactions(transactionRepository.findBySourceAccountIdOrderByInitiationDate(value.getId())));
		return account.orElse(null);
	}
	
	public Account getAccount(String accountNumber) {
		Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
		return  account.orElse(null);
	}
	 
	public Account createAccount(String bankName,String ownerName) {
		CodeGenerator codeGenerator=new  CodeGenerator();
		Account newAccount=new Account(bankName,ownerName,codeGenerator.generateSortCode(),codeGenerator.generateAccountNumber(),0.00);
		return accountRepository.save(newAccount);
	}
}
