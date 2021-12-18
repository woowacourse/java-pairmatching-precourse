package pairmatching.matching.frontend;

import pairmatching.matching.mathcingtitle.MatchingTitle;

import java.util.ArrayList;
import java.util.List;

public class FrontEndMatchingTitleRepository {

    private List<MatchingTitle> matchingTitles = new ArrayList<>();

    private FrontEndMatchingTitleRepository(){}

    private static class InnerInstanceClazz{
        private static final FrontEndMatchingTitleRepository instance = new FrontEndMatchingTitleRepository();
    }

    public static FrontEndMatchingTitleRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void add(MatchingTitle matchingTitle) {
        matchingTitles.add(matchingTitle);
    }

    public List<MatchingTitle> findAll() {
        return matchingTitles;
    }
}
