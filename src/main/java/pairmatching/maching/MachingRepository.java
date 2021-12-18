package pairmatching.maching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.edu.Course;
import pairmatching.edu.Level;

public class MachingRepository {
	private static final List<Maching> machingList = new ArrayList<>();

	public static List<Maching> machingList() {
		return (machingList);
	}

	public static void addMathing(Maching maching) {
		machingList.add(maching);
	}

	public static boolean existByCourseLevel(Course course, Level level) {
		int size = machingList.stream()
			.filter(maching -> maching.getCourse().getName().equals(course.getName()))
			.filter(maching -> maching.getLevel().getName().equals(level.getName()))
			.collect(Collectors.toList())
			.size();
		if (size > 0) {
			return true;
		}
		return false;
	}

	public static boolean existByCourseLevelMission(Course course, Level level, String mission) {

		if (existByLevel(level) && existByCourse(course)) {
			if (existByMission(mission)) {
				return true;
			}
		}
		return false;
	}

	public static boolean existByCourse(Course course) {
		for (Maching m : machingList) {
			if (m.getCourse().getName().equals(course.getName())) {
				return true;
			}
		}
		return false;
	}

	public static boolean existByMission(String mission) {
		for (Maching m : machingList) {
			if (m.getMission().equals(mission)) {
				return true;
			}
		}
		return false;
	}

	public static boolean existByLevel(Level level) {
		for (Maching m : machingList) {
			if (m.getLevel().getName().equals(level.getName())) {
				return true;
			}
		}
		return false;
	}

	public static Maching findByCourseLevelMission(Course course, Level level, String mission) {
		if (existByLevel(level) && existByCourse(course)) {
			if (existByMission(mission)) {
				return getmat(mission);
			}
		}
		return null;
	}

	public static Maching getmat(String mission) {
		for (Maching m : machingList) {
			if (m.getMission().equals(mission)) {
				return m;
			}
		}
		return null;
	}

	public static void deleteAll() {
		machingList.clear();
	}

}
