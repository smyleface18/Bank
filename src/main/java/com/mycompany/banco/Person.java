/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

import com.mycompany.banco.values.SexType;
import java.util.Random;

/**
 *
 * @author caleb
 */
public class Person {
    
    String name;
    int age;
    int DNI;
    SexType sex;
    double heigth;
    double weigth;

    public Person() {
        this.name = "";
        this.age = 0;
        this.sex = SexType.M ;
        this.heigth = 0;
        this.weigth = 0;
        this.DNI = generatorDNI();
    }

    public Person(String name, int age, SexType sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.heigth = 0;
        this.weigth = 0;
        this.DNI = generatorDNI();
    }

    public Person(String name, int age, SexType sex, double heigth, double weigth) {
        this.name = name;
        this.age = age;
        this.DNI = generatorDNI();
        this.sex = sex;
        this.heigth = heigth;
        this.weigth = weigth;
    }
    
    
    public double calculateIMC(){
        final int underWeight  = -1;
        final int normalWeigth = 0;
        final int overWeigth   =1;
        final int indexIMC []  = {20,25};
        
        double imc = 0;
        imc = (this.weigth/(this.heigth*this.heigth));
        
        if(imc < indexIMC[0]){
            imc = underWeight;
        }
        
        else if (imc >=  indexIMC[0] & imc <= indexIMC[1]){
            imc = normalWeigth;
        }
        else if( imc > indexIMC[1]){
            imc = overWeigth;
        }
        
        return imc;
    }
    
    public boolean adult(){
        final int ageAdult = 18;
        boolean adult = false;
        
        if(this.age >= ageAdult){
            adult = true;
        }
        else if (this.age == 0){
            System.out.println("la edad no ha sido ingresada");
        }
        return adult;  
    }
    
    private String ckeckSex(SexType sex){
            String msg;
            if(this.sex.equals(sex)){
                msg = "sex correcto";
            }
            else {
                this.sex = SexType.M;
                msg = "sex es M";
            }
        return msg;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", DNI=" + DNI + ", sex=" + sex + ", heigth=" + heigth + ", weigth=" + weigth + '}';
    }
    
    private int generatorDNI(){
        int DNI = 0;
        
        Random random = new Random();
        DNI = random.nextInt(90000000)+10000000;
        return DNI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public int getDNI() {
        return DNI;
    }
    
    
    
    
}
