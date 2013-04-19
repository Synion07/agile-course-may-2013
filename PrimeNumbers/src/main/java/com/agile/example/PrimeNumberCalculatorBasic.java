package com.agile.example;

import java.util.ArrayList;
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
		Integer currentNum = input;
		Integer divider = 2;
		while(currentNum != 1){
			if (currentNum % divider == 0){
				decomposition.add(divider);
				currentNum /= divider;
			}
			else{
				divider++;
			}
		}
		return decomposition;
	}
}
