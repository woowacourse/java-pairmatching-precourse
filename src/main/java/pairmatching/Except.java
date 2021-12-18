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

    public static void PairMatchingInputError() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 입력 양식이 잘못됐어요!");
            Utils.InputPairMatching();
        }
    }

    public static void MatchingTryThreeTime() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 매칭을 실패했어요!");
        }
    }
}
