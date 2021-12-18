package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class CrewList {
	private final Course course;
	private final List<Crew> crews;

	public CrewList(Course course) {
		this.course = course;
		this.crews = new ArrayList<>();
	}

	public void addCrew(Crew crew) {
		if (crew.isCourse(course)) {
			crews.add(crew);
		}
		// 에러 메세지 출력
	}

}
