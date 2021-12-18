package pairmatching.model;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import pairmatching.service.MakingShuffleList;
import pairmatching.util.MissionException;
import pairmatching.view.UserView;

public class PairMatching {
	public List<String> backendCrew;
	public List<String> frontendCrew;
	public List<MissionInfo> missionInfoSet;
	public MissionException missionException;

	public PairMatching() {
		backendCrew = makeInitList("backend-crew.md");
		frontendCrew = makeInitList("frontend-crew.md");
		missionInfoSet = new ArrayList<MissionInfo>();
		missionException = new MissionException();
	}

	public List<String> makeInitList(String str) {
		Charset ch = Charset.forName("UTF-8");
		URL resource = getClass().getClassLoader().getResource(str);
		String filePath = resource.getFile();
		Path path = new File(resource.getPath()).toPath();
		List<String> contents = new ArrayList<>();
		try {
			contents = Files.readAllLines(path, ch);
		} catch (IOException e) {
			;
		}
		return contents;
	}

	public void makePair(String CourseLevelMission) {
		String[] str = CourseLevelMission.split(", ", -1);
		MissionInfo missionInfo;
		str[2] = missionException.checkMissionNameIsInLevel(str[1], str[2]);

		for (int i = 0; i < missionInfoSet.size(); i++) {

			if (!rematch(CourseLevelMission, i)) {
				return;
			}

		}

		List<String> crew = backendCrew;

		if (str[0].equals("프론트엔드")) {
			crew = frontendCrew;
		}

		crew = checkReduplication(crew, str[0], str[1]);

		missionInfo = new MissionInfo(str[0], str[1], str[2]);
		missionInfo.missionList = crew;
		missionInfoSet.add(missionInfo);
		MakingShuffleList.printPairList(missionInfo.missionList);
	}

	public boolean findPair(String CourseLevelMission) {

		for (int i = 0; i < missionInfoSet.size(); i++) {

			if (missionInfoSet.get(i).find(CourseLevelMission)) {
				MakingShuffleList.printPairList(missionInfoSet.get(i).missionList);
				return true;
			}

		}
		throw new IllegalArgumentException("\n해당 매칭이 없습니다.\n");
	}

	public boolean rematch(String CourseLevelMission, int i) {
		if (missionInfoSet.get(i).find(CourseLevelMission)) {

			if (!UserView.reMatch()) {
				return false;
			}

		}

		return true;
	}

	public List<String> checkReduplication(List<String> crew, String course, String level) {
		for (int i = 0; i < 3; i++) {
			int j;
			for (j = 0; j < missionInfoSet.size(); j++) {
				crew = MakingShuffleList.shuffle(crew);
				if (missionInfoSet.get(j).checkReDuple(course, level, crew))
					break;
			}

			if (j == missionInfoSet.size())
				return crew;
		}

		throw new IllegalArgumentException("[ERROR] 적절한 페어 만들기 실패");
	}

}
