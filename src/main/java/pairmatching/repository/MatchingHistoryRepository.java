package pairmatching.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.Course;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.constants.Level;

public class MatchingHistoryRepository {

    Set<MatchingHistory> matchingHistories = new HashSet<>();

    public void deleteMatchingHistory(Course course) {
        MatchingHistory matchingHistoryByCourse = findMatchingHistoryByCourse(course);
        matchingHistories.remove(matchingHistoryByCourse);
    }

    public void save(MatchingHistory matchingHistory) {
        matchingHistories.add(matchingHistory);
    }

    public MatchingHistory findMatchingHistoryByCourse(Course course) {
        for (MatchingHistory matchingHistory : matchingHistories) {
            if (matchingHistory.getCourse().getLevel().equals(course.getLevel()) && matchingHistory.getCourse()
                    .getPosition().equals(course.getPosition()) && matchingHistory.getCourse().getMission()
                    .equals(course.getMission())) {
                return matchingHistory;
            }
        }
        return null;
    }

    public List<MatchingHistory> findMatchingHistoryByLevel(Level level) {
        List<MatchingHistory> findMatchingHistories = new ArrayList<>();
        for (MatchingHistory matchingHistory : matchingHistories) {
            if (matchingHistory.getCourse().getLevel().equals(level)) {
                findMatchingHistories.add(matchingHistory);
            }
        }
        return findMatchingHistories;
    }

    public void clearMatchingHistory() {
        matchingHistories.clear();
    }
}
