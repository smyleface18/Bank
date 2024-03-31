/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

import com.mycompany.banco.Person;
/**
 *
 * @author caleb
 */
public class BankAccount {
    
    double money;
    Person headline;

    public BankAccount(Person headline) {
        this.headline = headline;
    }

    public BankAccount(double money, Person headline) {
        this.money = money;
        this.headline = headline;
    }
    
    
    public void depositMoney(double money){
        if(money > 0){
            this.money =  this.money + money;
        }
        else{System.out.println("no puede depositar una cantidad negativa");}       
    }
    
    public void withdrawals(double exitMoney){
        if(exitMoney <= this.money){
            this.money = this.money - exitMoney;
        }
        else{System.out.println("no existe la cantidad de dinero que quiere retirar");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" + "money=" + money + ", headline=" + headline + '}';
    }
    
    
    
    
    
}
