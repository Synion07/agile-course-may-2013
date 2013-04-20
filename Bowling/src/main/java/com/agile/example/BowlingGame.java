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
	private static final Integer SPARE_BONUS = 2;
	
	@Override
	public Integer score(String score) {
		Integer totalScore = 0;
		Deque<Integer> lastValues = new LinkedList<>();
		Boolean isSpare = false;
		for (Character character: score.toCharArray()){
			Integer thisScore = Integer.valueOf(character.toString());
			if (lastValues.size() == FRAME_SIZE){
				isSpare = (lastValues.pop() + lastValues.pop()) == TOTAL_PINS;
			}
			totalScore += isSpare ? SPARE_BONUS * thisScore : thisScore;
			lastValues.add(thisScore);
			isSpare = false;
		}
		return totalScore;
	}

}
