package pairmatching;

import pairmatching.missionName.MissionName;


public class Application {
    public static void main(String[] args) {
        try {
            Executor executor = new Executor();
            executor.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
