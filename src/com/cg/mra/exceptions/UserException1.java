package com.cg.mra.exceptions;

public class UserException1 extends Exception {
	public UserException1()
	{
		System.err.println("ERROR: Cannot Recharge Account as Given Mobile No Does Not Exists");
	}

}
