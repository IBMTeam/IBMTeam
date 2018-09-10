/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.authenticate;

/**
 * @author Puneet D
 *
 */
public class UserInfo {
	String Name;
	String DOB;
	String Country;
	int pfStored;
	String empID;
	boolean loanAvailed;
	
	
	public void setName(String name) {
		Name = name;
	}

	public void setDOB(String dob) {
		DOB = dob;
		
	}

	public void setCountry(String country) {
		Country = country;
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	public String getDOB() {
		// TODO Auto-generated method stub
		return DOB;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return Country;
	}

	public void setPF(int pf) {
		// TODO Auto-generated method stub
		
		pfStored=pf; 
		
	}
	
	public int getPF(){
		return pfStored;
	}

	public void setEmpID(String empId) {
		// TODO Auto-generated method stub
		
		empID = empId;
		
	}

	public void setLoanAvailed(boolean loanAvailedRef) {
		// TODO Auto-generated method stub
		loanAvailed=loanAvailedRef;
	}
	
	public boolean getLoanAvailed(){
		return loanAvailed;
	}

	
	
}
