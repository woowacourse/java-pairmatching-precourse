package pairmatching.domain;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CrewInfoReader {

	private static ClassLoader loader = CrewInfoReader.class.getClassLoader();
	public static List<String> readCrewListByType(String type) {
		String line = null;
		List<String> crewList = new ArrayList<>();
		try(FileInputStream file = new FileInputStream(loader.getResource(type+".md").getFile());
			BufferedReader br = new BufferedReader(new InputStreamReader(file, "utf-8"))){

			while((line = br.readLine()) != null){
				crewList.add(line);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return crewList;
	}
}
