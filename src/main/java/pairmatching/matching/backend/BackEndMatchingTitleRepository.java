package pairmatching.matching.backend;

import pairmatching.matching.mathcingtitle.MatchingTitle;

import java.util.ArrayList;
import java.util.List;

public class BackEndMatchingTitleRepository {

    private List<MatchingTitle> matchingTitles = new ArrayList<>();

    private BackEndMatchingTitleRepository(){}

    private static class InnerInstanceClazz {
        private static final BackEndMatchingTitleRepository instance = new BackEndMatchingTitleRepository();
    }

    public static BackEndMatchingTitleRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void add(MatchingTitle matchingTitle) {
        matchingTitles.add(matchingTitle);
    }

    public List<MatchingTitle> findAll() {
        return matchingTitles;
    }
}
