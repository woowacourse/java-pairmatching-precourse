package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class View {
    public static Menu getMenu() {
        try {
            printMenu();
            System.out.println();
            return Menu.of(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenu();
        }
    }

    private static void printMenu() {
        System.out.println("기능을 선택하세요");
        Arrays.stream(Menu.values())
                .forEach(menu -> System.out.println(
                        menu.getSymbol() + ". " + menu.getName()
                ));
    }
}
