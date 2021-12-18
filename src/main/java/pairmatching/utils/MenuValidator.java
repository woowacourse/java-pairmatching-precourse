package pairmatching.utils;

import java.util.List;

public class MenuValidator {
    public static boolean validateInputMenu(String inputMenu, List<String> menu) {
        return menu.contains(inputMenu);
    }
}
