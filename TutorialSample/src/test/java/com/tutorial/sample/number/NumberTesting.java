/**
 * 
 */
package com.tutorial.sample.number;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Admin
 *
 */
public class NumberTesting {
	
	
	@Before 
	public void setUp(){
		
	}
	
	@After
	public void cleanUp(){
		
	}
	
	@Test
	public void getNumbersSum(){
		
		int number1 = 10 ;
		int number2=20;
		int valueExpected=30;
		int valueReceived;
		
		NumberOperation numOperation = new NumberOperation();
		valueReceived=numOperation.getNumbersSum(number1,number2);
		assertEquals(valueExpected,valueReceived);
	}
	
	@Test
	public void getNumbersSum_OneNumberZero(){
		
		int number1 = 0 ;
		int number2=20;
		int valueExpected=20;
		int valueReceived;
		
		NumberOperation numOperation = new NumberOperation();
		valueReceived=numOperation.getNumbersSum(number1,number2);
		assertEquals(valueExpected,valueReceived);
	}
	
	@Test
	public void testGreaterNumber(){
		int number1 = 0 ;
		int number2=20;
		int valueExpected=20;
		int valueReceived;
		
		NumberOperation numOperation = new NumberOperation();
		valueReceived=numOperation.getGreaterNumber(number1,number2);
		assertEquals(valueExpected,valueReceived);
		
	}
	
	@Test
	public void testGreaterNumber_OneNegativeNumber(){
		int number1 = -1 ;
		int number2=20;
		int valueExpected=20;
		int valueReceived;
		
		NumberOperation numOperation = new NumberOperation();
		valueReceived=numOperation.getGreaterNumber(number1,number2);
		assertEquals(valueExpected,valueReceived);
		
	}
	
	@Test
	public void testGreaterNumber_BothNegativeNumbers(){
		int number1 = -1 ;
		int number2=-20;
		int valueExpected=-1;
		int valueReceived;
		
		NumberOperation numOperation = new NumberOperation();
		valueReceived=numOperation.getGreaterNumber(number1,number2);
		assertEquals(valueExpected,valueReceived);
		
	}
	
	@Test
	public void testGreaterNumber_BothZero(){
		int number1 = 0 ;
		int number2=0;
		int valueExpected=0;
		int valueReceived;
		
		NumberOperation numOperation = new NumberOperation();
		valueReceived=numOperation.getGreaterNumber(number1,number2);
		assertEquals(valueExpected,valueReceived);
		
	}
	
	
	
	
	

}
