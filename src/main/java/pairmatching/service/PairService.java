package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.BackCrews;
import pairmatching.domain.BackPairs;
import pairmatching.domain.Course;
import pairmatching.domain.FrontCrews;
import pairmatching.domain.FrontPairs;
import pairmatching.dto.CrewDto;
import pairmatching.dto.PairDto;
import pairmatching.dto.RequestDto;

public class PairService {
    private List<BackPairs> backPairsList = new ArrayList<>();
    private List<FrontPairs> frontPairsList = new ArrayList<>();

    public List<PairDto> match(RequestDto requestDto) {
        if (Course.isBackend(requestDto.getCourse())) {
            List<CrewDto> crewDtos = BackCrews.crews().stream().map(CrewDto::new).collect(Collectors.toList());
            return createPairs(requestDto.getMission(), requestDto.getLevel(), requestDto.getCourse(), Randoms.shuffle(crewDtos.stream().map(CrewDto::getName).collect(Collectors.toList())));
        }
        List<CrewDto> crewDtos = FrontCrews.crews().stream().map(CrewDto::new).collect(Collectors.toList());
        return createPairs(requestDto.getMission(), requestDto.getLevel(), requestDto.getCourse(), Randoms.shuffle(crewDtos.stream().map(CrewDto::getName).collect(Collectors.toList())));
    }

    private List<PairDto> createPairs(String mission, String level, String course, List<String> shuffledCrews) {
        int limit = 2;

        if (Course.isBackend(course)) {
            BackPairs backPairs = new BackPairs(level, mission);
            if (shuffledCrews.size() % 2 == 0) {
                for (int i = 0; i < shuffledCrews.size(); i += limit) {
                    List<String> names = shuffledCrews.subList(i, i + limit);
                    backPairs.addPair(new PairDto(names));
                }
            }

            if (shuffledCrews.size() % 2 != 0) {
                for (int i = 0; i < shuffledCrews.size(); i += limit) {
                    if (i == shuffledCrews.size() - 3) {
                        List<String> names = shuffledCrews.subList(i, shuffledCrews.size());
                        backPairs.addPair(new PairDto(names));
                    }
                    List<String> names = shuffledCrews.subList(i, i + limit);
                    backPairs.addPair(new PairDto(names));
                }
            }
            backPairsList.add(backPairs);
            return backPairs.pairs().stream().map(PairDto::new).collect(Collectors.toList());
        }
        FrontPairs frontPairs = new FrontPairs(level, mission);
        if (shuffledCrews.size() % 2 == 0) {
            for (int i = 0; i < shuffledCrews.size(); i += limit) {
                List<String> names = shuffledCrews.subList(i, i + limit);
                frontPairs.addPair(new PairDto(names));
            }
        }

        if (shuffledCrews.size() % 2 != 0) {
            for (int i = 0; i < shuffledCrews.size(); i += limit) {
                if (i == shuffledCrews.size() - 3) {
                    List<String> names = shuffledCrews.subList(i, shuffledCrews.size());
                    frontPairs.addPair(new PairDto(names));
                    break;
                }
                List<String> names = shuffledCrews.subList(i, i + limit);
                frontPairs.addPair(new PairDto(names));
            }
        }
        frontPairsList.add(frontPairs);
        return frontPairs.pairs().stream().map(PairDto::new).collect(Collectors.toList());
    }

    public boolean hasAlreadyMatching(RequestDto requestDto) {
        if (Course.isBackend(requestDto.getCourse())) {
            return backPairsList.stream().anyMatch(backPairs -> backPairs.isSame(requestDto));
        }
        return frontPairsList.stream().anyMatch(frontPairs -> frontPairs.isSame(requestDto));
    }

    public List<PairDto> getPair(RequestDto requestDto) {
        if (Course.isBackend(requestDto.getCourse())) {
            BackPairs backPairs = backPairsList.stream().filter(pairs -> pairs.isSame(requestDto)).findFirst().get();
            return backPairs.pairs().stream().map(PairDto::new).collect(Collectors.toList());
        }
        FrontPairs frontPairs = frontPairsList.stream().filter(pairs -> pairs.isSame(requestDto)).findFirst().get();
        return frontPairs.pairs().stream().map(PairDto::new).collect(Collectors.toList());
    }
}
