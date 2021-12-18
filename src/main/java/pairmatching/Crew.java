package pairmatching;

import java.util.ArrayList;

public class Crew {
    private Course course;
    private String name;
    private ArrayList<String> LEVEL1Patner = new ArrayList<>();
    private ArrayList<String> LEVEL2Patner = new ArrayList<>();
    private ArrayList<String> LEVEL3Patner = new ArrayList<>();
    private ArrayList<String> LEVEL4Patner = new ArrayList<>();
    private ArrayList<String> LEVEL5Patner = new ArrayList<>();

    Crew(Course course, String name) {
        this.name = name;
        this.course = course;
    }

    public boolean PartnerCheck(String level, String partnerName) {
        if (level == "레벨1") {
            return CheckNameInLevel(LEVEL1Patner,partnerName);
        }
        if (level == "레벨2") {
            return CheckNameInLevel(LEVEL2Patner,partnerName);
        }
        if (level == "레벨3") {
            return CheckNameInLevel(LEVEL3Patner,partnerName);
        }
        if (level == "레벨4") {
            return CheckNameInLevel(LEVEL4Patner,partnerName);
        }
        return CheckNameInLevel(LEVEL5Patner,partnerName);
    }

    public boolean CheckMyName(String name) {
        if (name.equals(this.name)) {
            return true;
        }
        return false;
    }

    public static boolean CheckNameInLevel (ArrayList<String> partners,String partnerName) {
        if (partners.contains(partnerName)) {
            return true;
        }
        return false;
    }
}