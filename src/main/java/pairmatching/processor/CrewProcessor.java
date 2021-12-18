package pairmatching.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.io.FileInputHandler;
import pairmatching.type.Course;
import pairmatching.type.Crew;
import pairmatching.util.CrewUtil;

public class CrewProcessor {

	Map<Course, List<Crew>> courseCrewMap = new HashMap<Course, List<Crew>>();

	public CrewProcessor(FileInputHandler fileInputHandler) {
		List<Course> courseList = Course.courseList();
		for (Course course : courseList) {
			List<Crew> crewList = CrewUtil.generateCrewList(fileInputHandler.readCrewMember(course.getFilePath()),
				course);
			courseCrewMap.put(course, crewList);
		}
	}
}
