/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

/**
 *
 * @author Wind Raider Zero
 */
public class mainClass {
    public static void main(String[]args){
        data.Person babyMarwan = new data.Person("marwan",    true, "2016/01/01",      
//                                                   name,is male?,  dateOfBirth,     
                
                                                       5.7,         6.2, "2016/04/10", 5.5, "2016/03/12");
//                                          current weight, prev weight, last visit  

        calculation.KMSCalculator machine = new calculation.KMSCalculator();
        machine.calculating(babyMarwan);
        machine.printStatus(babyMarwan);
    }
}
