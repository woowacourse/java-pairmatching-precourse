package pairmatching.view.Message;

public class QuestionMessage {
    private static String REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오";
    public static void printQuestionRematch(){
        System.out.println(REMATCH);
    }
}
