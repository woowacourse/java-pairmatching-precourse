package pairmatching.model;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PairMatching {
	public List<String> backendCrew;
	public List<String> frontendCrew;
	public List<MissionInfo> missionInfoSet;

	public PairMatching() {
		backendCrew = makeInitList("backend-crew.md");
		frontendCrew = makeInitList("frontend-crew.md");
		missionInfoSet = new ArrayList<MissionInfo>();
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

	public List<String> makePair(String CourseLevelMission) {
		String[] str = CourseLevelMission.split(", ", -1);
		MissionInfo missionInfo;

		if (str[0].equals("백엔드")) {
			missionInfo = new MissionInfo(str[0], str[1], str[2], backendCrew);
		} else {
			missionInfo = new MissionInfo(str[0], str[1], str[2], frontendCrew);
		}
		missionInfoSet.add(missionInfo);
		return missionInfo.missionList;
	}

	public boolean findPair(String CourseLevelMission) {
		for (int i = 0; i < missionInfoSet.size(); i++) {
			if (missionInfoSet.get(i).find(CourseLevelMission))
				return true;
		}
		return false;
	}
}
