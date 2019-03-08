package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

import com.cg.mra.exceptions.UserException;
import com.cg.mra.exceptions.UserException1;
import com.cg.mra.exceptions.UserException2;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		
		
		AccountServiceImpl as=new AccountServiceImpl();
		Account account=new Account();
		
		do {
		System.out.println("Select the option");
		System.out.println("  1. Account Balance Enquiry \n 2.Recharge Account \n 3. Exit");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		switch(ch){
		case 1:
			System.out.println("enter mobile number");
			String mobileNo=sc.next();
			if(mobileNo.length()==10)
			{
			account=as.getAccountDetails(mobileNo);
			if(account!=null)
			{
				System.out.println("Your Current Balance is Rs. "+account.getAccountBalance());
			}
			else
			{
				try {
					throw new UserException();
				}catch(UserException e) {}
			}
			}else
			{
				try {
					throw new UserException2();
				}catch(UserException2 e)
				{}
			}
			break;
		case 2:
			System.out.println("enter mobile number");
			 mobileNo=sc.next();
			 if(mobileNo.length()==10)
			 {
			 Account account1=as.getAccountDetails(mobileNo);
			 if(account1!=null)
			 {
			System.out.println("Enter Recharge Amount");
			double rechargeAmount=sc.nextDouble();
			int bal=as.rechargeAccount(mobileNo, rechargeAmount);
			if(bal!=0) {
			System.out.println("Your Account Recharged Successfully");
			System.out.println("Hello "+account1.getCustomerName()+",Available Balance is "+bal);
			}
			 }else
			{
				try{
					throw new UserException1();
					}
				catch(UserException1 e) {}
				
			}}else
			{
				try {
					throw new UserException2();
				}catch(UserException2 e)
				{}
			}
			 
			break;
		case 3:System.exit(0);
			break;
			default:
				System.out.println("invalid choice");
		}
		}while(true);
		
		}
	

}

