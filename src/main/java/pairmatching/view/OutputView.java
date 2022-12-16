package pairmatching.view;

public class OutputView {

    public void printFunctionSelectMessage() {
        println("기능을 선택하세요.");
        println("1. 페어 매칭");
        println("2. 페어 조회");
        println("3. 페어 초기화");
        println("Q. 종료");
    }

    public void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printEnter() {
        System.out.println();
    }

}

