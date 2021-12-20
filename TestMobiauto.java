package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestMobiauto {
	

	public static void main(String[] args) {
		
		TestMobiauto testMobiauto = new TestMobiauto();
		
		//testMobiauto.writeOneTo100();
		
		//testMobiauto.totalAngryBirdStars();
		
		//testMobiauto.totalCreepyTimeOccurrences();
		
		//testMobiauto.championTeamBasedOnResults();
	}
	
	// Exercise 1
	public void writeOneTo100() {
		
		List<Integer> numbers = (ArrayList<Integer>) Arrays.stream(IntStream.rangeClosed(1, 100).toArray()).boxed().collect(Collectors.toList());
		
		for(Integer i : numbers) {
			
			if(i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if(i % 5 == 0) {
				System.out.println("Buzz");
			} else if(i % 3 == 0) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
	}
	
	//Exercise 2 
	public void totalAngryBirdStars() {
		
		String[] resultArray = {"---","*--","**-","***", "---", "*--"};
		
		List<String> results = Arrays.asList(resultArray);
		
		int totalStarsResult = 0;
		for(String stage: results) {
			
			for(int i = 0; i < stage.length(); i++) {
				
				if(stage.charAt(i) == '*') {
					totalStarsResult++;
				}
			}
		}
		
		System.out.println(totalStarsResult);
	}

	//Exercise 3 
	public void totalCreepyTimeOccurrences() {
		
		String[] givenTimesArray = {"11:00","13:13","10:00","15:51","22:22"};
		List<String> givenTimes = Arrays.asList(givenTimesArray);
		
		int totalCreepyTimes = 0;
		
		for(String time : givenTimes) {
			
			if((time.charAt(0) == time.charAt(3)) && (time.charAt(1) == time.charAt(4))) { //check AB:AB
				totalCreepyTimes++;
				
			} else if((time.charAt(0) == time.charAt(1)) && (time.charAt(3) == time.charAt(4))) { //check AA:BB
				totalCreepyTimes++;
				
			} else if((time.charAt(0) == time.charAt(4)) && (time.charAt(1) == time.charAt(3))) { //check AB:BA
				totalCreepyTimes++;
				
			} else if((time.charAt(0) == time.charAt(1)) && (time.charAt(0) == time.charAt(3)) && (time.charAt(0) == time.charAt(4))) { //check AA:AA
				totalCreepyTimes++;
				
			}
			
		}
		
		System.out.println(totalCreepyTimes);
	}

	//Exercise 4
	public void championTeamBasedOnResults() {
		
		int[] wins = {1,0,3,3};
		int[] ties = {3,4,0,1};
		
		HashMap<Integer, Integer> mapTeamPoints = new HashMap();
		
		for(int i = 0; i < wins.length; i++) {
			mapTeamPoints.put(i, Math.multiplyExact(3, wins[i]));
			
			mapTeamPoints.put(i, Math.addExact(mapTeamPoints.get(i), ties[i]));
		}
		
		int champion = mapTeamPoints.entrySet().stream()
			.max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
			.get().getKey();
		
		System.out.println(champion);
	}
}
