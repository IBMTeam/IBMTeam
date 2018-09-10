/**
 * 
 */
package com.tutorial.sample.number;

/**
 * @author Admin
 *
 */
public class NumberOperation {

	public int getNumbersSum(int number1, int number2) {
		// TODO Auto-generated method stub
		int summation = number1 + number2;
		
		
		return summation;
		
	}

	public int getGreaterNumber(int number1, int number2) {
		
		if (number1> number2) {
			return number1;
		}else if(number2>number1){
				return number2;
			}else {
				return number2; 
			}
	}

}
