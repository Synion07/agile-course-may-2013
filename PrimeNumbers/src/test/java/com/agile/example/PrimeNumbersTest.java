package com.agile.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Use Spring runner to load objects from context, 
 * use our custom context configuration to allow annotations.
 * 
 * @author Ivan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class PrimeNumbersTest{

	/**
	 * Use Spring to inject our class here
	 */
	@Resource(name = "primeNumberCalculator")
	private PrimeNumberCalculator calculator;
	
	/**
	 * Decomposing 1 should give an empty list
	 */
	@Test
	public void testDecompose1(){
		// given
		Integer input = 1;
		
		// when
		List<Integer> output = calculator.decompose(input);
		
		// then
		assertThat(output, is(emptyCollectionOf(Integer.class)));
	}
	
	/**
	 * Decomposing 2 should return:
	 * 2
	 */
	@Test
	public void testDecompose2(){
		// given
		List<Integer> expectedDecomposition = Arrays.asList(2);
		Integer input = 2;
		
		// when
		List<Integer> actualDecomposition = calculator.decompose(input);
		
		// then
		assertThat(actualDecomposition, contains(expectedDecomposition.toArray()));
	}
	
	/**
	 * Decomposing 3 should return:
	 * 3
	 */
	@Test
	public void testDecompose3(){
		// given
		List<Integer> expectedDecomposition = Arrays.asList(3);
		Integer input = 3;
		
		// when
		List<Integer> actualDecomposition = calculator.decompose(input);
		
		// then
		assertThat(actualDecomposition, contains(expectedDecomposition.toArray()));		
	}

}
