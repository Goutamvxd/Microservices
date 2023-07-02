package com.banking.app.banking.utils;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountInput {

	@NotBlank(message = "Bank name is mandatory")
	private String bankName;
	@NotBlank(message = "Owner name is mandatory")
	private String ownerName;

	public CreateAccountInput() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankName, ownerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateAccountInput other = (CreateAccountInput) obj;
		return Objects.equals(bankName, other.bankName) && Objects.equals(ownerName, other.ownerName);
	}

	@Override
	public String toString() {
		return "CreateAccountInput [bankName=" + bankName + ", ownerName=" + ownerName + "]";
	}

}
