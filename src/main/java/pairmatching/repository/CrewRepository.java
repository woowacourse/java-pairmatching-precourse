package pairmatching.repository;

import static pairmatching.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	private static final CrewRepository instance = new CrewRepository();

	private List<String> frontEndCrew = new ArrayList<>();
	private List<String> backEndCrew = new ArrayList<>();

	private List<String> suffledFrontEndCrew = new ArrayList<>();
	private List<String> suffledBackEndCrew = new ArrayList<>();

	private CrewRepository() {

	}

	public static CrewRepository getInstance() {
		if (instance == null) {
			return new CrewRepository();
		}
		return instance;
	}

	public void saveCrews(List<String> backEndCrew, List<String> frontEndCrew) {
		this.frontEndCrew = frontEndCrew;
		this.backEndCrew = backEndCrew;
	}

	public void saveSuffledCrew(List<String> suffledCrew, String type) {
		if (isFrontEnd(type)) {
			this.suffledFrontEndCrew = suffledCrew;
		} else if (isBackEnd(type)) {
			this.suffledBackEndCrew = suffledCrew;
		}
	}

	public List<String> findCrews(String type) {
		if (isFrontEnd(type)) {
			return this.frontEndCrew;
		} else if (isBackEnd(type)) {
			return this.backEndCrew;
		}

		return NOT_FOUNDED;
	}

	public List<String> findSuffledCrews(String type) {
		if (isFrontEnd(type)) {
			return this.frontEndCrew;
		} else if (isBackEnd(type)) {
			return this.backEndCrew;
		}

		return NOT_FOUNDED;
	}

	private boolean isFrontEnd(String type) {
		return type.equals(FRONTEND_COURSE);
	}

	private boolean isBackEnd(String type) {
		return type.equals(BACKEND_COURSE);
	}
}
