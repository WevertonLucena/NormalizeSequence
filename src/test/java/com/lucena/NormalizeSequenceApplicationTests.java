package com.lucena;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucena.service.Normalize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NormalizeSequenceApplicationTests {
	
	@Autowired
	Normalize normalize;

	@Test
	public void firtSequenceTest() {
		
		int result = normalize.normalizeSequence("}{", 0, 0);
		assertEquals(result, 2);
	}
	
	@Test
	public void secondSequenceTest() {
		
		int result = normalize.normalizeSequence("{}{}", 0, 0);
		assertEquals(result, 0);
	}
	
	@Test
	public void thirdSequenceTest() {
		
		int result = normalize.normalizeSequence("{{{}", 0, 0);
		assertEquals(result, 1);
	}

}
