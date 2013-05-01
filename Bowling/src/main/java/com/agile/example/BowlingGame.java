package com.agile.example;

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
	private static final Integer TOTAL_FRAMES = 10;

	@Override
	public Integer score(String score) {
		Integer totalScore = 0;

		char[] rolls = score.toCharArray();
		
		Integer rollIndex = 0;
		
		for (Integer frame = 0; frame < TOTAL_FRAMES; frame++){
			if (isStrike(rolls, rollIndex)){
				totalScore += TOTAL_PINS + strikeBonus(rolls, rollIndex);
				rollIndex += FRAME_SIZE;
			}
			else if (isSpare(rolls, rollIndex)){
				totalScore += TOTAL_PINS + spareBonus(rolls, rollIndex);
				rollIndex += FRAME_SIZE;
			}
			else{
				totalScore += frameScore(rolls, rollIndex);
				rollIndex += FRAME_SIZE;
			}
		}

		return totalScore;
	}
	
	

	private Integer strikeBonus(char[] rolls, Integer rollIndex) {
		// Special case for last frame
		if (rolls[rollIndex + 1] == '-'){
			return rollScore(rolls, rollIndex + 2) + rollScore(rolls, rollIndex + 3);
		}
		else{
			return rollScore(rolls, rollIndex + 1) + rollScore(rolls, rollIndex + 2);
		}
		
	}

	private Boolean isStrike(char[] rolls, Integer rollIndex) {
		return rolls[rollIndex] == 'X';
	}

	private Integer spareBonus(char[] rolls, Integer rollIndex) {
		return rollScore(rolls, rollIndex + 2);
	}

	private Boolean isSpare(char[] rolls, Integer rollIndex) {
		return frameScore(rolls, rollIndex) == 10;
	}
	
	private Integer frameScore(char[] rolls, Integer rollIndex){
		return rollScore(rolls, rollIndex) + rollScore(rolls, ++rollIndex);
	}
	
	private Integer rollScore(char[] rolls, Integer rollIndex){
		
		char roll = rolls[rollIndex];
		
		switch(roll){
		case 'X':
			return 10;
		case '-':
			return rollScore(rolls, ++rollIndex);
		default:
			return Integer.parseInt(Character.toString(roll));
		}
		
	}
	
	

}
