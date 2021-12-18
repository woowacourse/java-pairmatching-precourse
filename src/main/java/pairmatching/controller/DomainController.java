package pairmatching.controller;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.DomainValidator;

public class DomainController {

	public static final String DOMAIN_SEPARATOR = ", ";

	public static List<String> getDomains() {
		String inputString = Console.readLine();
		try {
			DomainValidator.validateInputForm(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getDomains();
		}
		return Arrays.asList(inputString.split(DOMAIN_SEPARATOR));
	}
}
