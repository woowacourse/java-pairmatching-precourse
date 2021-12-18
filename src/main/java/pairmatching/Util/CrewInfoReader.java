package pairmatching.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class CrewInfoReader {
	public static void getBackendCrewInfo() {
		try (FileReader rw = new FileReader("C:\\Users\\rkdtk\\Documents\\GitHub\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
			 BufferedReader br = new BufferedReader(rw);){
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				System.out.println(readLine);
			}
		}  catch (IOException e) {
			System.out.println("e");
		}
	}

	public static void getFrontendCrewInfo() {
		try (FileReader rw = new FileReader("C:\\Users\\rkdtk\\Documents\\GitHub\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
			 BufferedReader br = new BufferedReader(rw);){
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				System.out.println(readLine);
			}
		}  catch (IOException e) {
			System.out.println("e");
		}
	}
}
