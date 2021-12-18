package pairmatching.repository;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public interface CrewRepository {

	void load();

	List<Crew> findAll(Course course);

}
