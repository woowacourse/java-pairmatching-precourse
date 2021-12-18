package pairmatching.controller;

public class ValidationController {
    public static void chooseFunctionValidation(String input) {
        if (!isNumValidation(input)){
            throw new IllegalArgumentException("[ERROR] 잘못된 값 입력입니다");
        }
    }

    private static boolean isNumValidation(String input) {
        try {
            int num = Integer.parseInt(input);
            if (!(1 <= num && num <= 3)){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean checkSpellQValidation(String input) {
        if (input.equals("Q")){
            return true;
        }
        return false;
    }
}
