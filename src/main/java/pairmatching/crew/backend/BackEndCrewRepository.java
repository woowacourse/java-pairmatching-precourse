package pairmatching.crew.backend;

import pairmatching.crew.Crew;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BackEndCrewRepository {

    private Map<String, Crew> backEndCrewMap = new ConcurrentHashMap<>();

    private BackEndCrewRepository(){}

    private static class InnerInstanceClazz {
        private static final BackEndCrewRepository instance = new BackEndCrewRepository();
    }

    public static BackEndCrewRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void add(Crew crew) {
        backEndCrewMap.put(crew.getName(), crew);
    }
}
