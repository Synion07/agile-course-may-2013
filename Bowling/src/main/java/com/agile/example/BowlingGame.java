package com.agile.example;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.springframework.stereotype.Component;

/**
 * Implementing class, here lies the full code.
 * 
 * @author Ivan
 *
 */
@Component("bowling")
public class BowlingGame implements Bowling {
	
	private static final Integer FRAME_SIZE = 2;
	private static final Integer TOTAL_PINS = 10;
	private static final Integer BONUS = 2;
	private static final Integer REGULAR = 1;
	
	@Override
	public Integer score(String score) {
		Integer totalScore = 0;
		Integer thisScore = 0;
		Deque<Integer> lastValues = new LinkedList<>();
		Deque<Integer> nextMultiplier = new LinkedList<>();
		for (Character character: score.toCharArray()){
			switch (character){			
			case 'X':
				totalScore += 10;
				nextMultiplier.add(BONUS);
				nextMultiplier.add(BONUS);
				break;
			case '-':
				continue;
			default:
				if (lastValues.size() == FRAME_SIZE){
					if (lastValues.pop() + lastValues.pop() == TOTAL_PINS){
						nextMultiplier.add(BONUS);
					}
					else{
						nextMultiplier.add(REGULAR);
					}
				}
				else{
					nextMultiplier.add(REGULAR);
				}
				thisScore = Integer.valueOf(character.toString());
				totalScore += nextMultiplier.pop() * thisScore;
				lastValues.add(thisScore);
				break;
			}
		}
		return totalScore;
	}

}
