package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.util.Constant;
import pairmatching.util.CrewParse;
import pairmatching.util.FileInput;

public class PairMatchingController {

	public void start() {
		List<Crew> crewList = new ArrayList<>();
		crewList.addAll(CrewParse.make(Course.BACKEND, FileInput.input(Constant.backendCrewFileName)));
		crewList.addAll(CrewParse.make(Course.FRONTEND, FileInput.input(Constant.frontendCrewFileName)));
		Crews crews = new Crews(crewList);

	}
}
