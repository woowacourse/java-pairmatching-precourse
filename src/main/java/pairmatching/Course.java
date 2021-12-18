package pairmatching;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public enum Course {
    BACKEND("백엔드","c:\\java-pairmatching-precourse/src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드","c:\\java-pairmatching-precourse/src/main/resources/frontend-crew.md");

    private String name;
    private String address;

    Course(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<String> getStudentList() throws IOException{
        List<String> studentList = new ArrayList<>();
        Scanner sc = new Scanner(new File(address));
        while (sc.hasNext()) {
            String str = sc.next();
            studentList.add(str);
        }
        return studentList;
    }
    // 추가 기능 구현
}
