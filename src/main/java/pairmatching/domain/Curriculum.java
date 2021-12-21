package pairmatching.domain;

import static pairmatching.util.Validator.*;

public class Curriculum {
	private Course course;
	private Level level;
	private String mission;

	public Curriculum(Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public Course getCourse() {
		return this.course;
	}

	@Override
	public boolean equals(Object object) {
		validateCurriculumObject(object);
		Curriculum curriculum = (Curriculum)object;
		if (this.course != curriculum.course) {
			return false;
		}
		if (this.level != curriculum.level) {
			return false;
		}
		return this.mission.equals(curriculum.mission);
	}
}
