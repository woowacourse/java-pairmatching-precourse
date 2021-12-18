package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private static List<Crew> crews = new ArrayList<>();

    private CrewRepository() {
    }

    public static void init(String courseName, String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (true) {
            String name = br.readLine();
            if (name == null) break;
            addCrew(courseName, name);
        }
        br.close();
    }

    public static void addCrew(String courseName, String name) {
        crews.add(new Crew(courseName, name));
    }

    public static void print() {
        for (Crew c : crews) {
            System.out.println(c.toString());
        }
    }
}
