package pairmatching.view.input;

import java.io.IOException;
import java.util.List;

public interface CrewNameInput {
    List<String> readNames(final String path) throws IOException;
}
