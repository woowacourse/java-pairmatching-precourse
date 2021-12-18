package pairmatching.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.utils.Constant;
import pairmatching.view.OutputView;

public class MatchingService {
	public static List<String> backendList;
	public static List<String> frontendList;
	public static InputService inputservice= new InputService();
	
	public void makeList() {
		backendList = fileToList(Constant.PATH_BACKEND);
		frontendList = fileToList(Constant.PATH_FRONTEND);
	}
	
	private List<String> fileToList(String path_str) {
		List<String> list = null;
		Path path= Paths.get(path_str);
		Charset cs= StandardCharsets.UTF_8;
		try {
			list = Files.readAllLines(path, cs);
		} catch (IOException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		return list;
	}
	
	//기능선택
	public void selectFunction() {
		String function;
		do {
			function= inputservice.readFunction();
			if(function.equals(Constant.COURSE_MATCHING_NUMBER)) {
				matching();
				continue;
			}
			//if(function.equals(Constant.COURSE_INQUERY_NUMBER))
			//if(function.equals(Constant.COURSE_INTI_NUMBER))
		}while(function.equals(Constant.COURSE_QUIT));
		
		
	}
	//매칭
	public void matching() {
		//선택한 코스정보 읽어오기
		OutputView.print_Information();
		String input= inputservice.readCourse();
		//매칭 정보 있는지 확인
		if(Crew.getHistory(input.split(Constant.DELIMITER_SELECT)[0], input)) { //이력있음
			OutputView.print_ExistHistory();
			String answer= inputservice.readAnswer();
			if(answer.equals(Constant.ANSWER_NO)) return;
			
		}
		//
	}
	
	public void inquery() {
		
	}
	
	public void init() {
		
	}
	
	
	//결과출력

}
