/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Wind Raider Zero
 */
public class Person {
    //diketahui
    private String name;
    private boolean isMale;
    private int age;
    private double weight;
    private double previousWeight;
    private String lastVisitDate;
    
    //ditanya
    public String StatusBeratBadan;         // value : naik, tidak, ukur pertama
    public boolean BGM;
    public boolean GarisKuning;
    public boolean Tidak2Kali;
    
    //constructor
    public Person(  String name, boolean isMale, int age, double weight, 
                    double previousWeight,String lastVisitData){
        this.name=name;
        this.isMale=isMale;
        this.age=age;
        this.weight=weight;
        this.previousWeight=previousWeight;
        this.lastVisitDate=lastVisitData;
    }
    
    //mutators
    public String getName(){return name;}
    public boolean isMale(){return isMale;}
    public int getAge(){return age;}
    public double getWeight(){return weight;}
    public double getPreviousWeight(){return previousWeight;}
    public String getLastVisitDate(){return lastVisitDate;}
    
}
