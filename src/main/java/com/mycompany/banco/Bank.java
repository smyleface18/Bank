/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

import java.util.Scanner;
import com.mycompany.banco.values.SexType;
import java.util.ArrayList;

/**
 *
 * @author caleb
 */
public class Bank {

    public static ArrayList <BankAccount> accountList = new ArrayList<>();  
    
    public static void main(String[] args) {
       
        Scanner read = new Scanner (System.in);
        
        do{
            System.out.println("************   MENU  ************ ");
            System.out.println("   OPCION                 ESCRIBIR ");
            System.out.println("");
            System.out.println("Crear cuenta              (crear)");
            System.out.println("ver estado de la cuenta   (ver)");
            System.out.println("Accion                    (accion)");
            System.out.println("cambiar datos             (cambiar)");
            System.out.println("salir                     (salir)");
            String word = read.next();
            
            if(word.equalsIgnoreCase("crear")){
                BankAccount account = createAccount();
                System.out.println(account.headline.getDNI());
                accountList.add(account);
            }
            else if( word.equalsIgnoreCase("ver")){
                System.out.println("ingresa el DNI de la persona");
                int DNI = read.nextInt();
                BankAccount account = searchAccount(DNI);
                System.out.println("Que quieres ver?");
                System.out.println("IMC");
                System.out.println("Cuenta");                
                System.out.println("edad");
                word = read.next();
                if(word.equalsIgnoreCase("imc")){
                    System.out.println("-1 bajo peso");
                    System.out.println("0  peso normal");
                    System.out.println("1 sobre peso");
                    System.out.println("su imc es ="+account.headline.calculateIMC());
                }
                else if(word.equalsIgnoreCase("cuenta")){
                    System.out.println(account.toString());
                }
                else if(word.equalsIgnoreCase("edad")){
                    System.out.println("mayor de edad? "+account.headline.adult());
                }
            }
            else if(word.equalsIgnoreCase("accion")){
                System.out.println("ingresa el DNI de la persona");
                int DNI = read.nextInt();
                BankAccount account = searchAccount(DNI);
                System.out.println("Que quiere realizar?");
                System.out.println("Ingresar dinero");
                System.out.println("retirar dinero");
                word = read.next();
                if(word.equalsIgnoreCase("ingresar")){
                    System.out.println("ingrese la cantidad que va a ingresar");
                    double money = read.nextDouble();
                    account.depositMoney(money);
                }
                else if(word.equalsIgnoreCase("retirar")){
                    System.out.println("ingrese la cantidad que va a retirar");
                    double money = read.nextDouble();
                    account.withdrawals(money);
                }
            }
            
            else if(word.equalsIgnoreCase("cambiar")){
                System.out.println("ingresa el DNI de la persona");
                int DNI = read.nextInt();
                BankAccount account = searchAccount(DNI);
                System.out.println("Que dato quires cambiar?");
                System.out.println("edad");
                System.out.println("altura");                
                System.out.println("peso");
                word = read.next();
                if(word.equalsIgnoreCase("edad")){
                    System.out.println("ingrese la edad");
                    int age = read.nextInt();
                    account.headline.setAge(age);
                }
                else if(word.equalsIgnoreCase("altura")){
                    System.out.println("ingrese la altura");
                    double heigth = read.nextDouble();
                    account.headline.setHeigth(heigth);
                }
                
                else if(word.equalsIgnoreCase("peso")){
                    System.out.println("ingrese el peso");
                    double weigth = read.nextDouble();
                    account.headline.setWeigth(weigth);
                }
            }
            
            else {break;}
            
        }
        while(true);
        
    }
    
    public static BankAccount createAccount(){
        Scanner read = new Scanner(System.in);
        String name;
        int age;
        double weigth;
        String sexo;
        double heigth;
        SexType sex;
        double money;
        
        System.out.println("name");
        name = read.next();
        System.out.println("Edad");
        age = read.nextInt();
        System.out.println("sexo");
        sexo = read.next();
            if(sexo.equalsIgnoreCase("M")){
                sex = SexType.M;
            }
            else{ sex = SexType.F;}
            
        System.out.println("Peso (kg)");
        weigth = read.nextDouble();
        System.out.println("altura (m)");
        heigth = read.nextDouble();
        
        Person person = new Person(name,age,sex,heigth,weigth);
        
        System.out.println("ingrese el dinero inicial de la cuenta");
        money = read.nextDouble();
        
        return new BankAccount(money,person);

    }
    
    public static BankAccount searchAccount(int DNI){
        BankAccount account = null;
        for(BankAccount bankAccount:accountList){
            if(DNI == bankAccount.headline.DNI){
                account = bankAccount;
                break;
            }
            else {System.out.println("ese DNI no existe");
            } 
        }
        return account;
    }
}
