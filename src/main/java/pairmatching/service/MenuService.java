package pairmatching.service;

import pairmatching.validation.MenuValidation;

public class MenuService {
    public int parseInput(String input) {
        MenuValidation.isValidMenu(input);
        if (input.equals("Q")) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}
