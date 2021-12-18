package pairmatching;

public class CourseService {

    public void isExistCourse(String input) throws IllegalArgumentException {
        boolean exist = false;
        for (Course c : Course.values()) {
            if (c.getName().equals(input)) {
                exist = true;
            }
        }
        if (!exist) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 코스 이름입니다.");
        }
    }
}
