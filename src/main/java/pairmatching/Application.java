package pairmatching;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException{
        View view = new View();
        Controller controller = new Controller(view);
        controller.start();
        // TODO 구현 진행
    }
}
