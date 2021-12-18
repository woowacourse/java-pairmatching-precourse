package pairmatching.domain;

import java.util.stream.Stream;

public enum Course {
	  BACKEND("백엔드"),
	  FRONTEND("프론트엔드");

	  private String name;

	  Course(String name) {
	    this.name = name;
	  }

	  public String getCourse() {
		  return name;
	  }
	  
	  public static boolean hasCourse(String value) {
		  return Stream.of(Course.values())
				  .filter(course -> course.equals(value))
				  .findFirst()
				  .isPresent();
	  }
	}
