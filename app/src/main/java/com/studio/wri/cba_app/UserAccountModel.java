package com.studio.wri.cba_app;
import java.io.Serializable;
/**
 * Created by isaac on 2015-11-28.
 */
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class UserAccountModel implements Serializable {
    Account[] accounts = {new Account("Checking",5700.00,false),
            new Account("Savings",14803.47,false),
            new Account("Student Loan",22380.86,true),
            new Account("VISA",800.00,true) };

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
            amounts[i] = String.format("%1$,.2f", accounts[i].amount);
        }

        return amounts;
    }

    public String getSenderAccountName(){
        return accounts[transferFromAccount].type;
    }

    public String getSenderAccountAmount(){
        return String.format("%1$,.2f",accounts[transferFromAccount].amount);
    }

    public String getReceiverAccountName(){
        return accounts[transferToAccount].type;
    }

    public String getReceiverAccountAmount(){
        return String.format("%1$,.2f", accounts[transferToAccount].amount);
    }

    public boolean performTransfer(double amount){
        Account sender = accounts[transferFromAccount];
        Account receiver = accounts[transferToAccount];

        //insufficient funds
        if(sender.amount<amount)
            return false;

        //adjust the transfer behavior if the account is debt
        if(receiver.isDebt)
            receiver.amount -= amount;
        else
            receiver.amount += amount;

        if(sender.isDebt)
            sender.amount += amount;
        else
        sender.amount -= amount;

        transferToAccount = -1;
        transferFromAccount = -1;

        return true;
    }



}
