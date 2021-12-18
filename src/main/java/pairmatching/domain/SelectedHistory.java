package pairmatching.domain;

import java.util.List;
import java.util.Objects;

public class SelectedHistory {
	private String selectedCourse;
	private String selectedLevel;
	private String selectedMission;
	private String result;

	public SelectedHistory(String selectedCourse, String selectedLevel, String selectedMission) {
		this.selectedCourse = selectedCourse;
		this.selectedLevel = selectedLevel;
		this.selectedMission = selectedMission;
		this.result = null;
	}

	public static SelectedHistory from(List<String> matchingInfo) {
		return new SelectedHistory(matchingInfo.get(0), matchingInfo.get(1), matchingInfo.get(2));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SelectedHistory that = (SelectedHistory)o;
		return Objects.equals(selectedCourse, that.selectedCourse) && Objects.equals(selectedLevel,
			that.selectedLevel) && Objects.equals(selectedMission, that.selectedMission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(selectedCourse, selectedLevel, selectedMission);
	}

	public String course() {
		return this.selectedCourse;
	}

	public boolean isSame(List<String> matchingInfo) {
		return Objects.equals(this.selectedCourse, matchingInfo.get(0)) && Objects.equals(this.selectedLevel, matchingInfo.get(1)) && this.selectedMission.equals(
			matchingInfo.get(2));
	}

	public String result() {
		return this.result;
	}

	public void addResult(String matchingResult) {
		this.result = matchingResult;
	}
}
