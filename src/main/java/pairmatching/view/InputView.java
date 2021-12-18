package pairmatching.view;

public class InputView {
    public static void splitString(String input) {
        isValidNumPoint(input);

        input = input.replace("]","");
        input = input.replace("[","");
        input = input.replace(" ","");
        String[] inputList = input.split(",");

        isValidPairMatching(inputList);
    }

    private static void isValidPairMatching(String[] result) {
        if (!(result[0].equals("프론트엔드") || result[0].equals("백엔드"))) {
            throw new IllegalArgumentException();
        }
        if (!(result[1].equals("레벨1") || result[1].equals("레벨2") || result[1].equals("레벨3") || result[1].equals("레벨4") || result[1].equals("레벨5"))) {
            throw new IllegalArgumentException();
        }
        System.out.println("no");

        if (result[1].equals("레벨1")) {
            if (!(result[2].equals("자동차경주") || result[2].equals("로또") || result[2].equals("숫자야구게임"))) {
                throw new IllegalArgumentException();
            }
        }
        if (result[1].equals("레벨2")) {
            if (!(result[2].equals("장바구니") || result[2].equals("결제") || result[2].equals("지하철노선도"))) {
                throw new IllegalArgumentException();
            }
        }
        if (result[1].equals("레벨4")) {
            if (!(result[2].equals("성능개선") || result[2].equals("배포"))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isValidNumPoint(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                count++;
            }
        }
        if (count!=2) {
            throw new IllegalArgumentException();
        }

    }
    public static String  isValidSelect(String input) {
        if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("Q"))) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}