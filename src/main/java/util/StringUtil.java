package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class StringUtil {

    public static String removeAllSpaces(final String input) {
        return input.replace(" ", "");
    }

    public static String joinNonEmptyStrings(String delimiter, String... parts) {
        return Arrays.stream(parts)
                .filter(part -> !part.isEmpty())
                .collect(Collectors.joining(delimiter));
    }
}
