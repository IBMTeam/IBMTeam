/**
 * 
 */
package com.tutorial.hr.finance;

import com.tutorial.sample.authenticate.DAO;
import com.tutorial.sample.authenticate.UserInfo;

/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

//A service to calculate PF
//Setting the expections and drive implementation based
	//on the expectations
	//PF is calculated for all employees
	
	//formula : PF = 12% (Basic pay)
	
	//if (grossSalary > 10000) then Basic pay = 40% of (Gross Salary)
	//else Basic pay = 20% of gross salary
	//0 should not be supported as monthly grossSalary
public class EmployeeFinanceService {

	DAO dataObj;
	
	public EmployeeFinanceService(DAO dataObjRef) {
		// TODO Auto-generated constructor stub
		dataObj= dataObjRef;
		
		
	}

	public EmployeeFinanceService() {
		// TODO Auto-generated constructor stub
	}

	public Object getPF(int grossSalary) {
		double basicPay;
		double PF;
		
		if(grossSalary <= 0){ return 0.0;}
		
		if (grossSalary>10000){
			basicPay=grossSalary*0.4;
		}else {
			basicPay=grossSalary*0.2;
		}
		PF=0.12*basicPay;
		System.out.println("CHecking Build trigger again ...Implementation : calculated PF is checking"+PF);
		System.out.println("file changed to vaidate check in to gitHub");
		return PF;
	}

	public Object getLoan(String empId) {
		// TODO Auto-generated method stub
		double loan = 0;
		UserInfo userInfo = (UserInfo) dataObj.getPF_byEmpId(empId);
		int pf=userInfo.getPF();
		System.out.println("Value of the PF is "+pf);
		System.out.println("loan availed"+userInfo.getLoanAvailed());
		if(!userInfo.getLoanAvailed()){
			if(pf>=100000){
				loan= pf/2;
			}else {
				loan = 0 ;
				System.out.println("checking to gitHub repository");
			}
		}else {
			loan = 0;
		}
		
		System.out.println("value of the loan"+loan);
		return loan;
	}

}
