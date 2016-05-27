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
    private String dateOfBirth;
    private double weight;
    private double previousWeight;
    private double secondLastWeight;
    private String lastVisitDate;
    private String secondLastVisitDate;
    
    //ditanya
    public String StatusBeratBadan;         // value : naik, tidak, ukur pertama
    public boolean BGM;
    public boolean GarisKuning;
    public boolean Tidak2Kali;
    
    //constructor
    public Person(  String name, boolean isMale, String dateOfBirth,double weight, 
                    double previousWeight,String lastVisitDate, double secondLastWeight,
                    String secondLastVisitDate){
        this.name=name;
        this.isMale=isMale;
        this.dateOfBirth=dateOfBirth;
        this.age=monthAges(dateOfBirth,new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        this.weight=weight;
        this.previousWeight=previousWeight;
        this.lastVisitDate=lastVisitDate;
        this.secondLastWeight=secondLastWeight;
        this.secondLastVisitDate=secondLastVisitDate;
    }
    private int monthAges(String lastVisitDate,String currentDate){
        int tahun = Integer.parseInt(currentDate.substring(0,4))-Integer.parseInt(lastVisitDate.substring(0,4));
        int bulan = Integer.parseInt(currentDate.substring(5,7))-Integer.parseInt(lastVisitDate.substring(5,7));
        int hari = Integer.parseInt(currentDate.substring(8))-Integer.parseInt(lastVisitDate.substring(8));
        return(tahun*12 + bulan + (int)(hari/30));
    }
    //mutators
    public String getName(){return name;}
    public boolean isMale(){return isMale;}
    public int getAge(){return age;}
    public String getDateOfBirth(){return dateOfBirth;}
    public double getWeight(){return weight;}
    public double getPreviousWeight(){return previousWeight;}
    public String getLastVisitDate(){return lastVisitDate;}
    public double getSecondLastWeight(){return secondLastWeight;}
    public String getSecondLastVisitDate(){return secondLastVisitDate;}
    
}
