/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Puneet D
 * 
 * 
 * provide a utility 
 * 
 * 1) to add 2 numbers and return the result- non TDD approach  
 * 2) provide which number is greater number - TDD approach 
 * 3) if both numbers are same then application should be able to return one of the numbers - TDD approach
 *  
 *
 */
public class Numbers {
	
	int number1=0;
	int number2=0;
	
	
	public int summation (int num1 , int num2){
		return num1 + num2;
	}


public int greaterNumber(int first, int second) {
		
		int greaterNumber= 0;
		
		if (first > second) {
			greaterNumber= first;
			//numberList.add(first);
			
		}else if(first < second){
			greaterNumber= second;
			
			
		} else {
			greaterNumber=first;
			
		}
		
		return greaterNumber;
	
		
	}



	
	
	
	
	

}
