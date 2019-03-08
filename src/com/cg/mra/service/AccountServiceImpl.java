package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService{
	AccountDaoImpl a=new AccountDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account getAccountDetails(String mobileNo) {
		Account account=a.getAccountDetails(mobileNo);
		return account;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int bal=a.rechargeAccount(mobileNo, rechargeAmount);
		return bal;
	}

}
