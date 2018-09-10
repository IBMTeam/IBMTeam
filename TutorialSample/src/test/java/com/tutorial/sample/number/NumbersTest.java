/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */
package com.tutorial.sample.number;

import static org.junit.Assert.assertEquals;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tutorial.sample.number.Numbers;



/**
 * @author Puneet D
 *
 */
public class NumbersTest {
	
	Numbers numObj;
	
	
	@Before 
	public void setUp(){
		numObj = new Numbers();
	}
	
	@After
	public void cleanUp(){
		numObj=null;
	}
	
	
	//is the test word mandatory in the testSummation
	@Test
	public void testSummation() {
		int expectedValue= 30;
		int actualValue;
		
		actualValue=numObj.summation(10, 20);
		assertEquals(expectedValue,actualValue);
	}
	
		
	@Test
	public void testGreaterNumber_First_Greater(){
		int expectedValue = 10;
		int actualValue ;
		
		
		actualValue=numObj.greaterNumber(10,5);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGreaterNumber_Second_Greater(){
		int expectedValue = 20;
		int actualValue ;
		
		
		actualValue=numObj.greaterNumber(10,20);
		assertEquals(expectedValue,actualValue);
			
	}
	
	@Test
	public void testGreaterNumber_When_Equal(){
		int expectedValue = 20;
			
		int actualValue ;
		actualValue=numObj.greaterNumber(20,20);
		assertEquals(expectedValue,actualValue);
		
			
	}
	
	
	
	@Test
	public void testGreaterNumber_Negative_Numbers(){
		int expectedValue = -77;
		int actualValue ;
		
		actualValue=numObj.greaterNumber(-100,-77);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGreaterNumber_Negative_Positive(){
		int expectedValue = 100;
		int actualValue ;
		actualValue=numObj.greaterNumber(100,-77);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGreaterNumber_Zero(){
		int expectedValue = 0;
		int actualValue ;
		actualValue=numObj.greaterNumber(0,0);
		assertEquals(expectedValue,actualValue);
	}
	

}
