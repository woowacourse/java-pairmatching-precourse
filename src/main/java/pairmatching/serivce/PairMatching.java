package pairmatching.serivce;

import java.util.ArrayList;
import pairmatching.repository.BackEndRepository;
import pairmatching.repository.FrontEndRepository;
import pairmatching.type.File;

public class PairMatching {
	private BackEndRepository backEnd;
	private FrontEndRepository frontEnd;

	public void setCrews() {
		backEnd = getBackEnd();
		frontEnd = getFrontEnd();
	}

	private BackEndRepository getBackEnd() {
		String fileName = File.BACK_END.getName();
		ArrayList<String> crewNames = pairmatching.file.File.readFile(fileName);

		BackEndRepository backEndRepositories = new BackEndRepository(crewNames);

		return backEndRepositories;
	}

	private FrontEndRepository getFrontEnd() {
		String fileName = File.FRONT_END.getName();
		ArrayList<String> crewNames = pairmatching.file.File.readFile(fileName);

		FrontEndRepository frontEndRepositories = new FrontEndRepository(crewNames);

		return frontEndRepositories;
	}
}
