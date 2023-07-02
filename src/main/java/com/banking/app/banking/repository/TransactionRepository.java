package com.banking.app.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.app.banking.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findBySourceAccountIdOrderByInitiationDate(Long id);
}
