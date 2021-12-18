package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> getCrewNames(Course c) {
        return crews.stream().filter(cr -> cr.isSameCourse(c)).map(n -> n.getName()).collect(Collectors.toList());
    }

    public static Crew getCrewByName(String name) {
        return crews.stream().filter(c -> c.isSameName(name)).findFirst().orElse(null);
    }

    public static void print() {
        for (Crew c : crews) {
            System.out.println(c.toString());
        }
    }
}
