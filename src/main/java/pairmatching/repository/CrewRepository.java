package pairmatching.repository;

import java.util.List;
import pairmatching.domain.Crew;

public interface CrewRepository {

	void load();

	Crew findOne(String name);

	List<Crew> getAll();

}
