package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PairInfo {

	private Course course;
	private Mission mission;

	private List<Pair> pairList = new ArrayList<>();

	public PairInfo(Course course, Mission mission) {
		this.course = course;
		this.mission = mission;
	}

	@Override
	public boolean equals(Object other) {
		PairInfo otherInfo = (PairInfo) other;

		return this.course == otherInfo.course
			&& this.mission == otherInfo.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, mission, pairList);
	}
}
