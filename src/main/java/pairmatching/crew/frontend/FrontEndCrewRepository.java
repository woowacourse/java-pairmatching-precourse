package pairmatching.crew.frontend;

import pairmatching.crew.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FrontEndCrewRepository {

    private Map<String, Crew> frontEndCrewMap = new ConcurrentHashMap<>();

    private FrontEndCrewRepository(){}

    private static class InnerInstanceClazz {
        private static final FrontEndCrewRepository instance = new FrontEndCrewRepository();
    }

    public static FrontEndCrewRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void add(Crew crew) {
        frontEndCrewMap.put(crew.getName(), crew);
    }

    public List<Crew> findAll() {
        return new ArrayList<>(frontEndCrewMap.values());
    }
}
