/**
 * 
 */
package com.tutorial.sample.authenticate;

/**
 * @author Admin
 *
 */
public class UserCheckSevice {

	LDAPReturnService lReturnService;

	public UserCheckSevice(LDAPReturnService ldapreturnSer) {
		lReturnService = ldapreturnSer;
		// TODO Auto-generated constructor stub
	}

	public Boolean checkUserName(userDetails userDetails) {
		
		String name = userDetails.getUserName();
		System.out.println(":::::::::"+name);
		String ldapName = (String) lReturnService.getUserName();
		if(name.equals(ldapName)){
			
			System.out.println("aa gaya bhai");
			return true;
		}else {
		return false;
		}
		// TODO Auto-generated method stub
		
	}

}
