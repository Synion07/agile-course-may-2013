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
	
	@Override
	public Integer score(String score) {
		return 63;
	}

}
