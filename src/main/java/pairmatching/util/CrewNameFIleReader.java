package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrewNameFIleReader {
    private static final String BACKEND_NAMES_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_NAMES_PATH = "src/main/resources/frontend-crew.md";

    public static List<String> createBackendNames() {
        try (Stream<String> stream = Files.lines(Paths.get(BACKEND_NAMES_PATH))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> createFrontendNames() {
        try (Stream<String> stream = Files.lines(Paths.get(FRONTEND_NAMES_PATH))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}