package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Pair {

	List<String[]> pairSet;
	public Pair(){
		pairSet = new ArrayList<>();
	}

	public void getPair(String name1, String name2){
		pairSet.add(new String[]{name1, name2});
	}
	public void getPair(String name1, String name2, String name3){
		pairSet.add(new String[]{name1, name2, name3});
	}

	public void printPair(){
		StringBuilder sb = new StringBuilder();
		for(String[] pair : pairSet){
			sb.append(String.join(" : ", pair)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
