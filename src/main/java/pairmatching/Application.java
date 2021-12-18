package pairmatching;

import java.io.IOException;
import java.util.List;

public class Application {

    private static void forTest() throws IOException{
        Course tes = Course.FRONTEND;
        List<String> a = tes.getStudentList();
        System.out.println(a.get(0));
    }

    public static void main(String[] args) throws IOException{
        forTest();

        // TODO 구현 진행
    }
}
