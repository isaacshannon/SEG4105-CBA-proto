package com.studio.wri.cba_app;
/**
 * Created by isaac on 2015-11-28.
 */
public class UserAccountModel {
    Account[] accounts = {new Account("Checking",5700.00),
            new Account("Savings",14803.47),
            new Account("Student Loan",22380.86),
            new Account("VISA",800.00) };

    public int transferFromAccount = -1;
    public int transferToAccount = -1;

    public UserAccountModel(){

    }

    public String[] getAccountTypes(){
        int len = accounts.length;
        String[] types = new String[len];

        for(int i=0;i<len;i++){
           types[i] = accounts[i].type;
        }

        return types;
    }

    public String[] getAccountAmounts(){
        int len = accounts.length;
        String[] amounts = new String[len];

        for(int i=0;i<len;i++){
            amounts[i] = String.valueOf(accounts[i].amount);
        }

        return amounts;
    }



}
