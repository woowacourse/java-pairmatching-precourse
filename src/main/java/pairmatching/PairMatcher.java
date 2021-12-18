package pairmatching;

import pairmatching.data.ProgramData;
import pairmatching.exception.PairMatchFailedException;
import pairmatching.io.ConsoleInputHandler;
import pairmatching.io.ConsoleOutputHandler;
import pairmatching.processor.CrewProcessor;
import pairmatching.type.CourseLevelMissionInfo;

public class PairMatcher {
	CrewProcessor crewProcessor;
	ConsoleOutputHandler outputHandler;
	ConsoleInputHandler inputHandler;

	public PairMatcher(CrewProcessor crewProcessor, ConsoleOutputHandler outputHandler, ConsoleInputHandler inputHandler) {
		this.crewProcessor = crewProcessor;
		this.outputHandler = outputHandler;
		this.inputHandler = inputHandler;
	}

	public void start() {
		String select = "";
		while(!select.equals(ProgramData.PROGRAM_EXIT)) {
			select = inputHandler.getValidSelect();
			if(select.equals(ProgramData.SELECT_MATCH)) {
				pairCreate();
			}
			if(select.equals(ProgramData.SELECT_LOOKUP)) {
				pairSearch();
			}
			if(select.equals(ProgramData.SELECT_INIT)) {
				System.out.println("dummy");
			}
		}
	}

	private void pairCreate() {
		CourseLevelMissionInfo clm = inputHandler.getValidCourseLevelMissionInfo();
		crewProcessor.matchPair(clm.getCourse(), clm.getLevel(), clm.getMission());
	}

	private void pairSearch() {
		CourseLevelMissionInfo clm = inputHandler.getValidCourseLevelMissionInfo();
		crewProcessor.printPairInfoirmation(clm.getCourse(), clm.getLevel(), clm.getMission());
	}
}
