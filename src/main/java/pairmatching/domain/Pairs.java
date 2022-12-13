package pairmatching.domain;

import pairmatching.util.UnableToSearchPairException;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private static final String NO_PAIR_ERROR = "[ERROR] 입력 정보와 일치하는 페어가 없습니다.";
    private static final String UNABLE_TO_SEARCH_PAIR_ERROR = "[ERROR] 매칭 이력이 없습니다.";
    private List<Pair> pairs = new ArrayList<>();

    public void addPair(SearchingInfoDto searchingInfoDto, Pair pair){
        if(isExistedPair(searchingInfoDto)){
            pairs.remove(findPair(searchingInfoDto));
        }
        pairs.add(pair);
    }

    private Pair findPair(SearchingInfoDto searchingInfoDto){
        return pairs.stream().filter(pair -> pair.getCourse().equals(searchingInfoDto.getCourse()))
                .filter(pair -> pair.getLevel().equals(searchingInfoDto.getLevel()))
                .filter(pair -> pair.getMission().equals(searchingInfoDto.getMission()))
                .findFirst().orElseThrow(()->new IllegalArgumentException(NO_PAIR_ERROR));
    }

    public boolean isExistedPair(SearchingInfoDto searchingInfoDto){
        return pairs.stream()
                .filter(pair->pair.getCourse().equals(searchingInfoDto.getCourse()))
                .filter(pair->pair.getLevel().equals(searchingInfoDto.getLevel()))
                .anyMatch(pair->pair.getMission().equals(searchingInfoDto.getMission()));
    }

    public void validateSearchablePairInfo(SearchingInfoDto searchingInfoDto) {
        if(!isExistedPair(searchingInfoDto)){
            throw new UnableToSearchPairException(UNABLE_TO_SEARCH_PAIR_ERROR);
        }
    }

    public String getPrintablePair(SearchingInfoDto searchingInfoDto){
        return findPair(searchingInfoDto).toPrintable();
    }
}
