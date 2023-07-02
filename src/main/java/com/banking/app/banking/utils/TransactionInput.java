package com.banking.app.banking.utils;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionInput {

	@Autowired
	private AccountInput sourceAccount;
	@Autowired
	private AccountInput targetAccount;

	@Positive(message = "Transfer amount must be positive")
	@Min(value = 1, message = "Amount must be larger than 1")
	private double amount;

	private String reference;

	@Min(value = -90, message = "Latitude must be between -90 and 90")
	@Max(value = 90, message = "Latitude must be between -90 and 90")
	private Double latitude;

	@Min(value = -180, message = "Longitude must be between -180 and 180")
	@Max(value = 180, message = "Longitude must be between -180 and 180")
	private Double longitude;

	@Override
	public String toString() {
		return "TransactionInput [sourceAccount=" + sourceAccount + ", targetAccount=" + targetAccount + ", amount="
				+ amount + ", reference=" + reference + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
