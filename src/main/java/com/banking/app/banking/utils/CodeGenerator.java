package com.banking.app.banking.utils;

import com.mifmif.common.regex.Generex;
import static com.banking.app.banking.constants.Constants.ACCOUNT_NUMBER_PATTERN_STRING;
import static com.banking.app.banking.constants.Constants.SORT_CODE_PATTERN_STRING;

public class CodeGenerator {
	Generex sortCodeGenerex = new Generex(SORT_CODE_PATTERN_STRING);
	Generex accountNumberGenerex = new Generex(ACCOUNT_NUMBER_PATTERN_STRING);

	public CodeGenerator() {
		super();
	}

	public String generateSortCode() {
		return sortCodeGenerex.random();
	}

	public String generateAccountNumber() {
		return accountNumberGenerex.random();
	}
}
