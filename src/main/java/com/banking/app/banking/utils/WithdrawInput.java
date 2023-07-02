package com.banking.app.banking.utils;

import java.util.Objects;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawInput extends AccountInput {

	String sortCode;
	String accountNumber;

	@Positive(message = "Transfer amount must be positive")
	private double amount;

	public WithdrawInput( ) {
		super();
		this.sortCode = super.getSortCode();
		this.accountNumber = super.getAccountNumber();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(accountNumber, amount, sortCode);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WithdrawInput other = (WithdrawInput) obj;
		return Objects.equals(accountNumber, other.accountNumber)
				&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(sortCode, other.sortCode);
	}

	@Override
	public String toString() {
		return "WithdrawInput [sortCode=" + sortCode + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}

}
