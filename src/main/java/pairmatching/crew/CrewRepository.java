package pairmatching.crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.utils.CrewListInitializer;

public class CrewRepository {

    private static final List<Crew> backendCrews = new ArrayList<>();
    private static final List<Crew> frontendCrews = new ArrayList<>();

    public static List<Crew> getBackendCrews() {
        if (backendCrews.isEmpty()) {
            init();
        }
        return Collections.unmodifiableList(backendCrews);
    }

    public static List<Crew> getFrontendCrews() {
        if (frontendCrews.isEmpty()) {
            init();
        }
        return Collections.unmodifiableList(frontendCrews);
    }

    private static void init() {
        backendCrews.addAll(CrewListInitializer.getBackendCrews());
        frontendCrews.addAll(CrewListInitializer.getFrontEndCrews());
    }

}
