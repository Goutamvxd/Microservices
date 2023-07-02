package com.banking.app.banking.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.app.banking.constants.ACTION;
import com.banking.app.banking.models.Account;
import com.banking.app.banking.models.Transaction;
import com.banking.app.banking.repository.AccountRepository;
import com.banking.app.banking.repository.TransactionRepository;
import com.banking.app.banking.utils.TransactionInput;

@Service
public class TransactionService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	public boolean makeTransfer(TransactionInput transactionInput) {
		String sourceSortCode = transactionInput.getSourceAccount().getSortCode();
		String sourceAccountNumber = transactionInput.getSourceAccount().getAccountNumber();
		Optional<Account> sourceAccount = accountRepository.findBySortCodeAndAccountNumber(sourceSortCode,
				sourceAccountNumber);

		String targetSortCode = transactionInput.getTargetAccount().getSortCode();
		String targetAccountNumber = transactionInput.getTargetAccount().getAccountNumber();
		Optional<Account> targetAccount = accountRepository.findBySortCodeAndAccountNumber(targetSortCode,
				targetAccountNumber);

		if (sourceAccount.isPresent() && targetAccount.isPresent()) {
			if (isAmountAvailble(transactionInput.getAmount(), sourceAccount.get().getCurrentBalance())) {
				var transaction = new Transaction();
				transaction.setAmount(transactionInput.getAmount());
				transaction.setSourceAccountId(sourceAccount.get().getId());
				transaction.setTargetAccountId(targetAccount.get().getId());
				transaction.setTargetOwnerName(targetAccount.get().getOwnerName());
				transaction.setInitiationDate(LocalDateTime.now());
				transaction.setCompletionDate(LocalDateTime.now());
				transaction.setReference(transactionInput.getReference());
				transaction.setLatitude(transactionInput.getLatitude());
				transaction.setLongitude(transactionInput.getLongitude());

				updateAccountBalance(sourceAccount.get(), transactionInput.getAmount(), ACTION.WITHDRAW);
				transactionRepository.save(transaction);

				return true;
			}
		}
		return false;
	}

	public void updateAccountBalance(Account account, double amount, ACTION action) {
		if (action == ACTION.WITHDRAW) {
			account.setCurrentBalance((account.getCurrentBalance() - amount));
		} else if (action == ACTION.DEPOSIT) {
			account.setCurrentBalance((account.getCurrentBalance() + amount));
		}
		accountRepository.save(account);
	}

	public boolean isAmountAvailble(double amount, double accountBalance) {
		return (accountBalance - amount) > 0;
	}
}
