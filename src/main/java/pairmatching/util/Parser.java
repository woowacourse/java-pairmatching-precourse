package pairmatching.util;

import static pairmatching.exception.ErrorCode.INVALID_INPUT;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pairmatching.exception.ExceptionHandler;

public class Parser {
    private static final String DELIMITER = ";";
    private static final Pattern REGEX_PROCESS_PATTERN = Pattern.compile("(백엔드|프론트엔드),\\\\s(레벨[1-5]),\\\\s[가-힣]+");

    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static List<String> parseProcessInput(String process) {
        INVALID_INPUT.validate(() -> isEndWithDelimiter(process));
        INVALID_INPUT.validate(() -> isInvalidProcessPattern(process));
        return ExceptionHandler.tryOnParseException(() -> parsingStringToList(process));
    }

    //== Parsing Method ==//
    private static List<String> parsingStringToList(String input) {
        Matcher matcher = REGEX_PROCESS_PATTERN.matcher(input);

        if (matcher.matches()) {
            List<String> parsedValues = new ArrayList<>();
            validateMatcher(matcher);

            parsedValues.add(matcher.group(1)); // Course
            parsedValues.add(matcher.group(2)); // Level
            parsedValues.add(matcher.group(3)); // Mission
            return parsedValues;
        }
        return null;
    }

    private static void validateMatcher(Matcher matcher) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            INVALID_INPUT.validate(() -> hasWhitespace(matcher.group(finalI)));
        }
    }

    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 패턴에 맞는가
    private static boolean isInvalidProcessPattern(String input) {
        return matchWithRegex(input, REGEX_PROCESS_PATTERN);
    }

    // 끝이 DELIMITER로 끝나는가
    private static boolean isEndWithDelimiter (String input) {
        return input.endsWith(DELIMITER);
    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
