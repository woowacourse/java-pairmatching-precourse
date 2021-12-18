package pairmatching;

import java.util.ArrayList;

public class Crew {
    private Course course;
    private static String name;
    private ArrayList<String> level1Mission = new ArrayList<>();
    private ArrayList<String> level2Mission = new ArrayList<>();
    private ArrayList<String> level4Mission = new ArrayList<>();


    Crew(String name) {
        this.name = name;
    }

    public static void PrintName() {
        System.out.println(name);
    }

}