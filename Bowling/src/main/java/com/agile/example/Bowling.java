package com.agile.example;

/**
 * We are using an interface to follow Spring's best practices
 * of programming by contract. 
 * 
 * 
 * @author Ivan
 *
 */
public interface Bowling {

	/**
	 * Calculates total score for a given score string
	 * 
	 * @param score string, expects numbers and the letters X- to indicate an strike
	 * @return total added score
	 */
	Integer score(String score);

}
