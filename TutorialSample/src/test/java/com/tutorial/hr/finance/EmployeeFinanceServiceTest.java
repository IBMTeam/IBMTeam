/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.hr.finance;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tutorial.sample.authenticate.DAO;
import com.tutorial.sample.authenticate.UserInfo;

/**
 * @author HP
 *
 */
public class EmployeeFinanceServiceTest {
	
	EmployeeFinanceService empFS;
	DAO dataObj;
	
	UserInfo userInfo;
	
	
	@Before
	public void setUp(){
		empFS= new EmployeeFinanceService();
	}
	
	@After
	public void tearDown(){
		
	}
	
	//Setting the expections and drive implementation based
	//on the expectations
	//PF is calculated for all employees
	
	//formula : PF = 12% (Basic pay)
	
	//if (grossSalary > 10000) then Basic pay = 40% of (Gross Salary)
	//else Basic pay = 20% of gross salary
	//null should not be supported as monthly grossSalary
	
	@Test
	public void calculatePF(){
		
		
		int grossSalary = 12000;
		double basicPay = (0.4*grossSalary);
		//System.out.println("the Basic is "+basicPay);
		double expectedPFValue = (0.12*basicPay);
		System.out.println("Unit Test : expected value of the PF is "+expectedPFValue);
		assertEquals(expectedPFValue,empFS.getPF(grossSalary));
		
		
	}
	//gross < 10000
	@Test
	public void calculatePF_lessThan10000(){
		
		
		int grossSalary = 8000;
		double basicPay = (0.2*grossSalary);
		//System.out.println("the Basic is "+basicPay);
		double expectedPFValue = (0.12*basicPay);
		System.out.println("Unit Test : expected value of the PF is "+expectedPFValue);
		assertEquals(expectedPFValue,empFS.getPF(grossSalary));
		
		
	}
	
	//gross 0 per month
	@Test
	public void calculatePF_grossSalary0(){
			
		double PF = 0;
		System.out.println("Unit Test : expected value of the PF is "+PF);
		assertEquals(PF,empFS.getPF(0));
					
	}
	
	//gross <0 per month
	@Test
	public void calculatePF_grossSalary_Negative(){
		double PF = 0;
		int grossSalary=-1000;
		assertEquals(PF, empFS.getPF(grossSalary));
	}
	
	/*@Test(expected=NullPointerException.class)
	public void calculatePF_grossSalary_Null(){
		empFS.getPF(null);
	}*/
	
	
	private void creatDAOMock() {
		
		
		dataObj=mock(DAO.class);
		when(dataObj.getPF_byEmpId("001")).thenReturn((UserInfo)userInfo );
		
		
	}
private void createPFStub() {
		
	userInfo = new UserInfo();
	userInfo.setEmpID("001");	
	userInfo.setPF(1000000);
	userInfo.setLoanAvailed(false);
			
}

private void createPFStub_LoanAlreadyAvailed() {
	
	userInfo = new UserInfo();
	userInfo.setEmpID("001");	
	userInfo.setPF(1000000);
	userInfo.setLoanAvailed(true);
			
}

	
private void createPFLessThanOneLakhStub() {
	
	userInfo = new UserInfo();
	userInfo.setEmpID("001");	
	userInfo.setPF(10000);
	userInfo.setLoanAvailed(false);
		
}
	
	//There is demand from the employees that 
	//they should be allowed loan against their PF
	//there should be facility to see how much loan is allowed
	//and avail it .. loan amount is 50% of the PF provided PF accumulated is 
	// is greater than or equal to 100000. 
	//This is exsercise for the team

	//Assuming PF is stored in the database
	//Level 2 
	// If user has already availed one loan then do not allow another loan 
	@Test
	public void testIsLoanAllowed(){
		
		
		double loan=500000;
		String empId="001";
		createPFStub();
		creatDAOMock();
		
		EmployeeFinanceService empFinSer = new EmployeeFinanceService(dataObj);
		assertEquals(loan,empFinSer.getLoan(empId));
		Mockito.verify(dataObj).getPF_byEmpId("001");
		
		
	}

	@Test
	public void testIsLoanAllowed_LoanAlreadyAvailed(){
		
		
		double loan=0.0;
		String empId="001";
		createPFStub_LoanAlreadyAvailed();
		creatDAOMock();
		
		EmployeeFinanceService empFinSer = new EmployeeFinanceService(dataObj);
		assertEquals(loan,empFinSer.getLoan(empId));
		Mockito.verify(dataObj).getPF_byEmpId("001");
		
		
	}
	
	
	@Test
	public void testIsLoanAllowed_PF_LessThanOneLakh(){
		
		
		double loan=0.0;
		String empId="001";
		createPFLessThanOneLakhStub();
		creatDAOMock();
		
		EmployeeFinanceService empFinSer = new EmployeeFinanceService(dataObj);
		assertEquals(loan,empFinSer.getLoan(empId));
		Mockito.verify(dataObj).getPF_byEmpId("001");
		
		
	}

	
	
	
	

}
