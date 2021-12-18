package pairmatching.mapper;

import java.util.Arrays;

public enum IndexMapper {
    MATCH("1", IndexMapper::mapToMatch),
    INQUIRY("2", IndexMapper::mapToInquiry),
    INIT("3", IndexMapper::mapToInit),
    QUIT("Q", IndexMapper::mapToQuit);

    private final String value;
    private final Mappable mappable;

    IndexMapper (String value, Mappable mappable) {
        this.value = value;
        this.mappable = mappable;
    }

    private static void mapToQuit() {
    }

    private static void mapToInit() {
    }

    private static void mapToInquiry() {
    }

    private static void mapToMatch() {
    }

    public static void map(String request) {
        Arrays.stream(IndexMapper.values()).filter(mapper -> mapper.isSameValue(request))
            .findFirst().get().mappable.map();
    }

    private boolean isSameValue(String request) {
        return this.value.equalsIgnoreCase(request);
    }
}
