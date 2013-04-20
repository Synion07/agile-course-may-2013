package com.agile.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class BowlingTest{

	/*
	 * Use Spring to inject our class here
	 */
	@Resource(name = "bowling")
	private Bowling bowling;
	
	/**
	 * Test a normal score addition
	 */
	@Test
	public void testNormalScoreAddition(){
		// given
		String score = "31415390107133238009";
		Integer expectedScore = 63;
		
		// when
		Integer actualScore = bowling.score(score);
		
		// then
		assertThat(actualScore, is(equalTo(expectedScore)));
	}
	
	/**
	 * Test another score addition, to triangulate
	 */
	@Test
	public void testNormalScoreAdditionWithOtherScore(){
		// given
		String score = "31415390127133238009";
		Integer expectedScore = 65;
		
		// when
		Integer actualScore = bowling.score(score);
		
		// then
		assertThat(actualScore, is(equalTo(expectedScore)));
	}
	
	/**
	 * Test that spares are counted correctly (double next throw)
	 */
	@Test
	public void testSpareScoreAddition(){
		// given
		String score = "91415390107133238009";
		Integer expectedScore = 73;
		
		// when
		Integer actualScore = bowling.score(score);
		
		// then
		assertThat(actualScore, is(equalTo(expectedScore)));
	}

}
