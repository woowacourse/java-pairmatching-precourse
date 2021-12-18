package pairmatching.util;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairInfoDto;
import pairmatching.service.MissionService;

public class Parser {
	public static PairInfoDto splitInformation(String input, MissionService missionService) {
		return getPairInfoDto(missionService, input.split(", "));
	}

	private static PairInfoDto getPairInfoDto(MissionService missionService, String[] infos) {
		return new PairInfoDto(Course.getValueOf(infos[0]), Level.getValueOf(infos[1]),
			missionService.findByName(infos[2]));
	}
}
