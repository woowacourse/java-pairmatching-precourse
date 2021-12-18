package pairmatching.mapper;

import java.util.Arrays;

import pairmatching.controller.PairMatchingController;
import pairmatching.dto.RequestDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public enum IndexMapper {
    MATCH("1", IndexMapper::mapToMatch),
    INQUIRY("2", IndexMapper::mapToInquiry),
    INIT("3", IndexMapper::mapToInit),
    QUIT("Q", IndexMapper::mapToQuit);

    private final String value;
    private final Mappable mappable;
    private static PairMatchingController pairMatchingController = PairMatchingController.getInstance();

    IndexMapper (String value, Mappable mappable) {
        this.value = value;
        this.mappable = mappable;
    }

    private static void mapToQuit() {
    }

    private static void mapToInit() {
    }

    private static void mapToInquiry() {
        OutputView.printProcess(pairMatchingController.requestProcess());
        OutputView.printMission(pairMatchingController.requestMission());
        String request = InputView.printProcessLevelMissionSelection();
        pairMatchingController.requestPairMatching(new RequestDto(request));
    }

    private static void mapToMatch() {
        OutputView.printProcess(pairMatchingController.requestProcess());
        OutputView.printMission(pairMatchingController.requestMission());
        String request = InputView.printProcessLevelMissionSelection();
        if (pairMatchingController.hasAlreadyMatching(new RequestDto(request))) {
            String YesOrNo = InputView.printRematching();
            if ("아니오".equals(YesOrNo)) {
                return;
            }
        };
        pairMatchingController.match(new RequestDto(request));
    }

    public static void map(String request) {
        Arrays.stream(IndexMapper.values()).filter(mapper -> mapper.isSameValue(request))
            .findFirst().get().mappable.map();
    }

    private boolean isSameValue(String request) {
        return this.value.equalsIgnoreCase(request);
    }
}
