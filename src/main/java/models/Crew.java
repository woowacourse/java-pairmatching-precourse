package models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Crew {

    static ArrayList<String> BackendCrews;
    static ArrayList<String> FrontendCrews;
    static boolean[][] BackMatch;
    static boolean[][] FrontMatch;

    public static void generateBackend(ArrayList<String> backend) {
        BackendCrews = backend;
    }

    public static void generateFrontend(ArrayList<String> frontend) {
        FrontendCrews = frontend;
    }

    public static void initBackMatch() {
        BackMatch = new boolean[BackendCrews.size()][BackendCrews.size()];
    }

    public static void initFrontMatch() {
        FrontMatch = new boolean[FrontendCrews.size()][FrontendCrews.size()];
    }

    public static boolean shuffleCrew(int type) {
        if (type == 0) {
            if (!shuffleBackend()) {
                return false;
            }
            if (!lastMatch(type)) {
                return false;
            }
        }
        if (type == 1) {
            if (!shuffleFrontend()) {
                return false;
            }
            if (!lastMatch(type)) {
                return false;
            }
        }
        return true;
    }

    public static boolean shuffleBackend() {
        List<Integer> pivots = new ArrayList<Integer>();
        for (int i = 0; i < BackendCrews.size(); i++) {
            pivots.add(i);
        }
        List<Integer> shufflePivot = Randoms.shuffle(pivots);

        int idx = 0;
        int loopNum = BackendCrews.size() / 2;
        for (int i = 0; i < loopNum; i++) {
            if (checkBackMatch(shufflePivot.get(idx), shufflePivot.get(idx + 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean shuffleFrontend() {
        List<Integer> pivots = new ArrayList<Integer>();
        for (int i = 0; i < FrontendCrews.size(); i++) {
            pivots.add(i);
        }
        List<Integer> shufflePivot = Randoms.shuffle(pivots);
        int idx = 0;
        int loopNum = FrontendCrews.size() / 2;
        for (int i = 0; i < loopNum; i++) {
            if (checkFrontMatch(shufflePivot.get(idx), shufflePivot.get(idx + 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkBackMatch(int a, int b) {
        if (BackMatch[a][b]) {
            return true;
        }
        return false;
    }

    public static boolean checkFrontMatch(int a, int b) {
        if (FrontMatch[a][b]) {
            return true;
        }
        return false;
    }

    public static boolean lastMatch(int type) {
        if (type == 0 && BackendCrews.size() % 2 == 1) {
            // shufflePivot.get(BackendCrews.size() - 1);
            // 홀수인 경우 3명이 한 묶음이 되어 매칭되도록
        }
        return true;
    }
}
