package pairmatching.repository;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public interface CrewRepository {

	void load();

	void reset();

	List<Crew> findAll(Course course);

}
