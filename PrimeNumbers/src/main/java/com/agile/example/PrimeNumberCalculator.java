package com.agile.example;

import java.util.List;

/**
 * We are using an interface to follow Spring's best practices
 * of programming by contract. 
 * 
 * 
 * @author Ivan
 *
 */
public interface PrimeNumberCalculator {

	/**
	 * Decomposes an integer into prime numbers
	 * 
	 * @param input
	 * @return
	 */
	List<Integer> decompose(Integer input);

}
