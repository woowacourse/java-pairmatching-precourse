package pairmatching.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.data.ProgramData;
import pairmatching.exception.PairMatchFailedException;
import pairmatching.io.ConsoleInputHandler;
import pairmatching.io.ConsoleOutputHandler;
import pairmatching.io.FileInputHandler;
import pairmatching.type.Course;
import pairmatching.type.Crew;
import pairmatching.type.Level;
import pairmatching.type.PairLog;
import pairmatching.util.CrewUtil;

public class CrewProcessor {

	ConsoleInputHandler inputHandler;
	ConsoleOutputHandler outputHandler;

	public Map<Course, List<Crew>> courseCrewMap = new HashMap<Course, List<Crew>>();
	public List<PairLog> pairLogList = new ArrayList<PairLog>();

	public CrewProcessor(ConsoleInputHandler inputHandler, ConsoleOutputHandler outputHandler, FileInputHandler fileInputHandler) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		List<Course> courseList = Course.courseList();
		for (Course course : courseList) {
			List<Crew> crewList = CrewUtil.generateCrewList(fileInputHandler.readCrewMember(course.getFilePath()),
				course);
			courseCrewMap.put(course, crewList);
		}
	}

	public void matchPair(Course course, Level level, String mission) {
		if(getDuplicatePairResult(course, level, mission) != null && inputHandler.getValidDuplicatePairSelect()) {
			return;
		}
		try {
			PairLog pairLog = createValidPair(course, level, mission);
			pairLogList.remove(getDuplicatePairResult(course, level, mission));
			pairLogList.add(pairLog);
			outputHandler.printPairInformation(pairLog);
		} catch (IllegalArgumentException iae) {
			outputHandler.printErrorMessage(iae);
			return;
		}
	}

	private PairLog createValidPair(Course course, Level level, String mission) {
		PairLog pairLog = null;
		for(int i=0;i<ProgramData.PAIR_MATCH_REPEAT;i++) {
			shuffleCrewList(course);
			List<Crew> shuffledCrewList = courseCrewMap.get(course);
			List<List<Crew>> pairList = CrewUtil.generatePairList(shuffledCrewList);
			if(!checkDuplicateCrewPair(course, level, pairList)) {
				pairLog = new PairLog(course, level, mission, pairList);
				break;
			}
		}
		if(pairLog == null) {
			throw new PairMatchFailedException(ProgramData.PAIR_MATCH_FAIL_ERROR);
		}
		return pairLog;
	}

	public void shuffleCrewList(Course course) {
		List<Crew> crewList = courseCrewMap.get(course);
		crewList = Randoms.shuffle(crewList);
		courseCrewMap.put(course, crewList);
	}

	private PairLog getDuplicatePairResult(Course course, Level level, String mission) {
		for(PairLog pairLog:pairLogList) {
			if(pairLog.checkDuplicate(course, level, mission)) {
				return pairLog;
			}
		}
		return null;
	}

	private boolean checkDuplicateCrewPair(Course course, Level level, List<List<Crew>> pairs) {
		for(PairLog pairLog: pairLogList) {
			if(!pairLog.isSameLevel(course, level)) {
				continue;
			}
			if(pairLog.checkDuplicatePairExist(pairs)) {
				return true;
			}
		}
		return false;
	}

	public void printPairInfoirmation(Course course, Level level, String mission) {
		PairLog pairLog = getDuplicatePairResult(course, level, mission);
		outputHandler.printPairInformation(pairLog);
	}
}
