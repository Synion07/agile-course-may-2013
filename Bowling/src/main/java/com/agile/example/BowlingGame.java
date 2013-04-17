package com.agile.example;

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
		Integer nextMultiplier = REGULAR;
		Integer afterNextMultiplier = REGULAR;
		for (Character character: score.toCharArray()){
			switch (character){			
			case 'X':
				totalScore += 10 * nextMultiplier;
				// update multipliers
				nextMultiplier = afterNextMultiplier + 1;
				afterNextMultiplier = BONUS;
				break;
			case '-':
				continue;
			default:
				thisScore = Integer.valueOf(character.toString());
				totalScore += nextMultiplier * thisScore;
				lastValues.add(thisScore);
				if (lastValues.size() == FRAME_SIZE){
					if (lastValues.pop() + lastValues.pop() == TOTAL_PINS){
						afterNextMultiplier += 1;
					}
				}
				// update multipliers
				nextMultiplier = afterNextMultiplier;
				afterNextMultiplier = REGULAR;
				break;
			}
			System.out.println(totalScore);
			System.out.println("next" + nextMultiplier);
			System.out.println("after" + afterNextMultiplier);

		}
		return totalScore;
	}

}
