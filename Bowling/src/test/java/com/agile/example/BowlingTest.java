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

}
