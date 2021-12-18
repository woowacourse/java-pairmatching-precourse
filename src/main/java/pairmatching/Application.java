package pairmatching;

import java.io.IOException;
import java.util.List;

import pairmatching.models.Course;
import pairmatching.models.Mission;
import pairmatching.utils.MissionList;
import pairmatching.utils.NameList;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO 구현 진행
        MissionList l = new MissionList();
        List<Mission> mi = l.initMissionList();
        mi.forEach(m -> {
            System.out.println(m.getLevel());
            m.getMissionList().forEach(System.out::println);
        });
    }
}
