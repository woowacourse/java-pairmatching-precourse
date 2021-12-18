package pairmatching;

public class Except {
    public static void StartPageError() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 1,2,3,Q 중 하나를 입력해주세요");
            PrintPage.StartPage();
        }
    }
}
