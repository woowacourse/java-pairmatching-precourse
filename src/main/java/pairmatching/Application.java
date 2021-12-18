package pairmatching;

import java.io.IOException;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.models.Course;
import pairmatching.utils.NameList;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO 구현 진행
        NameList s = new NameList();
        List<String> n = s.shuffleName(Course.FRONTEND.getName());
        n.forEach(System.out::println);
    }
}
