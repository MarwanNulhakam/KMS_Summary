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
        data.Person babyMarwan = new data.Person("marwan",    true,           8,      
//                                                   name,is male?,  age(month),     
                
                                                       5.7,         6.2, "2016/03/10", 5.5, "2016/02/12");
//                                          current weight, prev weight, last visit  

        data.Person babyZay = new data.Person("zay",    true,           6,      
//                                             name, is male,   age(month),     
                
                                                       6.2,         5.7, "2016/03/10", 4.8, "2016/02/01");
//                                          current weight, prev weight, last visit 

        data.Person babyRana = new data.Person("rana",    false,           4,      
//                                               name,  is male,  age(month),     
                
                                                       6.0,         0, "2016/01/10", 4.4, "2015/12/08");
//                                          current weight, prev weight, last visit  

        
        calculation.KMSCalculator machine = new calculation.KMSCalculator();
        
        machine.calculating(babyZay);
        machine.calculating(babyMarwan);
        machine.calculating(babyRana);
        
        machine.printStatus(babyZay);
        System.out.println("\n\n");
        machine.printStatus(babyMarwan);
        System.out.println("\n\n");
        machine.printStatus(babyRana);
        
    }
}
