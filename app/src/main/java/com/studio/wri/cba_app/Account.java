package com.studio.wri.cba_app;
import java.io.Serializable;
/**
 * Created by isaac on 2015-11-27.
 */
public class Account implements Serializable {
    public String type;
    public Double amount;

    public Account(String type, Double amount){
        this.type = type;
        this.amount = amount;
    }
}
