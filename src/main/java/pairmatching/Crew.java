package pairmatching;

import java.util.ArrayList;

public class Crew {
    private Course course;
    private static String name;
    private static ArrayList<String> LEVEL1Patner = new ArrayList<>();
    private static ArrayList<String> LEVEL2Patner = new ArrayList<>();
    private static ArrayList<String> LEVEL3Patner = new ArrayList<>();
    private static ArrayList<String> LEVEL4Patner = new ArrayList<>();
    private static ArrayList<String> LEVEL5Patner = new ArrayList<>();

    Crew(Course course, String name) {
        this.name = name;
        this.course = course;
    }

    public static boolean PartnerCheck(String level, String partnerName) {
        if (level == "레벨1") {
            return CheckNameInLevel(LEVEL1Patner,partnerName);
        }
        if (level == "레벨1") {
            return CheckNameInLevel(LEVEL2Patner,partnerName);
        }
        if (level == "레벨1") {
            return CheckNameInLevel(LEVEL3Patner,partnerName);
        }
        if (level == "레벨1") {
            return CheckNameInLevel(LEVEL4Patner,partnerName);
        }
        return CheckNameInLevel(LEVEL5Patner,partnerName);
    }

    public static boolean CheckNameInLevel (ArrayList<String> partners,String partnerName) {
        if (partners.contains(partnerName)) {
            return true;
        }
        return false;
    }
}