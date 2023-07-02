package com.banking.app.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.app.banking.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findBySortCodeAndAccountNumber(String sortCode, String accountNumber);

	Optional<Account> findByAccountNumber(String accountNumber);
}
