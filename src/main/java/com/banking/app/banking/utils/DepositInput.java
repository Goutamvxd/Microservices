package com.banking.app.banking.utils;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositInput {

	@NotBlank(message = "Target account no is mandatory")
	private String targetAccountNo;

	@Positive(message = "Transfer amount must be positive")
	private double amount;

	public DepositInput() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, targetAccountNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepositInput other = (DepositInput) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(targetAccountNo, other.targetAccountNo);
	}

	@Override
	public String toString() {
		return "DepositInput [targetAccountNo=" + targetAccountNo + ", amount=" + amount + "]";
	}

}
