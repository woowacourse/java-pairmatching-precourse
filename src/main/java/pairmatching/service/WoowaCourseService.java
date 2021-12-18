package pairmatching.service;

import java.util.Optional;

import pairmatching.domain.WoowaCourse;
import pairmatching.repository.WoowaCourseRepository;

public class WoowaCourseService {

	private final WoowaCourseRepository woowaCourseRepository;

	public WoowaCourseService(WoowaCourseRepository woowaCourseRepository) {
		this.woowaCourseRepository = woowaCourseRepository;
	}

	public boolean isDuplicated(WoowaCourse woowaCourse) {
		Optional<WoowaCourse> one = woowaCourseRepository.findOne(woowaCourse);
		return one.isPresent();
	}

}
