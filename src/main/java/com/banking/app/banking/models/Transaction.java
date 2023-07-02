package com.banking.app.banking.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction", schema = "online_bank")
@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_sequence", schema = "online_bank", initialValue = 5)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
	private long id;
	private long sourceAccountId;
	private long targetAccountId;
	private String targetOwnerName;
	private double amount;
	private LocalDateTime initiationDate;
	private LocalDateTime completionDate;
	private String reference;
	private Double latitude;
	private Double longitude;

	@Override
	public String toString() {
		return "Transaction [sourceAccountId=" + sourceAccountId + ", targetAccountId=" + targetAccountId
				+ ", targetOwnerName=" + targetOwnerName + ", amount=" + amount + ", initiationDate=" + initiationDate
				+ ", completionDate=" + completionDate + ", reference=" + reference + "]";
	}

}
