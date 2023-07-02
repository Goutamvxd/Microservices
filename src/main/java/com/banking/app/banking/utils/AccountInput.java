package com.banking.app.banking.utils;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountInput {
	@NotBlank
	private String sortCode;
	@NotBlank
	private String accountNumber;

	public AccountInput() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, sortCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountInput other = (AccountInput) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(sortCode, other.sortCode);
	}

	@Override
	public String toString() {
		return "AccountInput [sortCode=" + sortCode + ", accountNumber=" + accountNumber + "]";
	}

}
