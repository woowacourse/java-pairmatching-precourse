package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrewMaker {
	public static void run() {
		makeBackEndCrew();
		makeFrontEndCrew();
	}

	private static void makeBackEndCrew() {
		try{
			File file = new File("src/main/resources/backend-crew.md");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String name = "";
			while((name = bufReader.readLine()) != null){
				CrewRepository.addBackEndCrew(Crew.from(Course.BACKEND, name));
			}
			bufReader.close();
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	private static void makeFrontEndCrew() {
		try{
			File file = new File("src/main/resources/frontend-crew.md");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String name = "";
			while((name = bufReader.readLine()) != null){
				CrewRepository.addFrontEndCrew(Crew.from(Course.FRONTEND, name));
			}
			bufReader.close();
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
