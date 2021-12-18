package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.controller.CrewController;
import pairmatching.model.Operation;

public class Application {
	public static void main(String[] args) {
		String function = Operation.selectFunction();
		List<String> domainList = Operation.selectDomain();
		List<String> crews = InitialCrewSetting(domainList);
		Operation.execute(function, domainList, crews);
	}

	private static List<String> InitialCrewSetting(List<String> domainList) {
		try {
			return CrewController.makeList(domainList, new ArrayList<>());
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
			return InitialCrewSetting(domainList);
		}
	}
}
