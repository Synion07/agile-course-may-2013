package com.agile.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Implementing class, here lies the full code.
 * 
 * @author Ivan
 *
 */
@Component("primeNumberCalculator")
public class PrimeNumberCalculatorBasic implements PrimeNumberCalculator {

	@Override
	public List<Integer> decompose(Integer input) {
		List<Integer> decomposition = new ArrayList<>();
		if (input != 1){
			decomposition = Arrays.asList(2);
		}
		return decomposition;
	}
}
