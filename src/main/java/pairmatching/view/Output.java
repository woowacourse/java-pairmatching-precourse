package pairmatching.view;

import static pairmatching.utils.Message.*;

import java.util.List;

public class Output {

    public static void LIST() {
        System.out.println("\n" + LIST);
    }

    public static void matching(List<String> names) {
        System.out.println("\n" + MATCHING_RESULT);
        if (names.size() % 2 == 0) {
            backMatching(names);
        }
        if (names.size() % 2 != 0) {
            frontMatching(names);
        }
    }

    private static void backMatching(List<String> names) {
        for (int i = 0; i < names.size() - 1; i += 2) {
            System.out.println(names.get(i) + " : " + names.get(i + 1));
        }
    }

    private static void frontMatching(List<String> names) {
        int i;
        for (i = 0; i < names.size() - 3; i += 2) {
            System.out.println(names.get(i) + " : " + names.get(i + 1));
        }
        System.out.println(names.get(i) + " : " + names.get(i + 1) + " : " + names.get(i + 2));
    }
}
