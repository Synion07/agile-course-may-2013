package com.agile.example;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class PrimeNumbersTest{

	/*
	 * Use Spring to inject our class here
	 */
	@Resource(name = "primeNumberCalculator")
	private PrimeNumberCalculator calculator;
	
	@Test
	public void testDecompose1(){
		fail();
	}

}
