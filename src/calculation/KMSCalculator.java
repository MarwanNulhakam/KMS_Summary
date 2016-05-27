package calculation;

import java.text.SimpleDateFormat;

/**
 *
 * @author Wind Raider Zero
 */

public class KMSCalculator {
    
//    public void cek2T(data.Person bayi){
//        String currentDate = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date());
//        int tahun = Integer.parseInt(currentDate.substring(0,4))-Integer.parseInt(bayi.getLastVisitDate().substring(0,4));
//        int bulan = Integer.parseInt(currentDate.substring(5,7))-Integer.parseInt(bayi.getLastVisitDate().substring(5,7));
//        int hari = Integer.parseInt(currentDate.substring(8))-Integer.parseInt(bayi.getLastVisitDate().substring(8));
//        bayi.Tidak2Kali = (tahun*360 + bulan*30 + hari) > 60;
//    }
    
    public int monthAges(String lastVisitDate,String currentDate){
        int tahun = Integer.parseInt(currentDate.substring(0,4))-Integer.parseInt(lastVisitDate.substring(0,4));
        int bulan = Integer.parseInt(currentDate.substring(5,7))-Integer.parseInt(lastVisitDate.substring(5,7));
        int hari = Integer.parseInt(currentDate.substring(8))-Integer.parseInt(lastVisitDate.substring(8));
        return(tahun*12 + bulan + (int)(hari/30));
    }
    
    public void cek2T(data.Person bayi){
        boolean status = true;
//        
//        if(monthAges(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()),bayi.getLastVisitDate())>2){
//            bayi.Tidak2Kali = status;
//            return;
//        }
//        
//        if(bayi.isMale()) 
//            status = status && ((bayi.getPreviousWeight()!=0.0) ?
//                ((bayi.getWeight()-bayi.getPreviousWeight()+0.000000000000004)*1000) < data.RefferenceTableForKMS
//                .maleWeightUpIndicator[bayi.getAge() > 12 ? 12:bayi.getAge() ] : true);
//        else
//            status = status && ((bayi.getPreviousWeight()!=0.0) ?
//                ((bayi.getWeight()-bayi.getPreviousWeight()+0.000000000000004)*1000) < data.RefferenceTableForKMS
//                .femaleWeightUpIndicator[bayi.getAge() > 12 ? 12:bayi.getAge() ] : true);
//
//        if(bayi.isMale()) 
//            status = status && ((bayi.getSecondLastWeight()!=0.0) ?
//                ((bayi.getPreviousWeight()-bayi.getSecondLastWeight()+0.000000000000004)*1000) < data.RefferenceTableForKMS
//                .maleWeightUpIndicator[bayi.getAge()-monthAges(bayi.getLastVisitDate(),bayi.getSecondLastVisitDate()) > 12 ? 12:bayi.getAge() ] : true);
//        else
//            status = status && ((bayi.getSecondLastWeight()!=0.0) ?
//                ((bayi.getPreviousWeight()-bayi.getSecondLastWeight()+0.000000000000004)*1000) < data.RefferenceTableForKMS
//                .femaleWeightUpIndicator[bayi.getAge()-monthAges(bayi.getLastVisitDate(),bayi.getSecondLastVisitDate()) > 12 ? 12:bayi.getAge() ] : true);
        System.out.println("check 2T");
        String measureDate[] = {new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()),bayi.getLastVisitDate()};
        double weight[] = {bayi.getWeight(),bayi.getPreviousWeight()};
        status = status && (!cekWeightStatus(bayi.isMale(), bayi.getDateOfBirth(), measureDate, weight).equalsIgnoreCase("naik"));
        String measureDate2[] = {bayi.getLastVisitDate(),bayi.getSecondLastVisitDate()};
        double weight2[] = {bayi.getPreviousWeight(),bayi.getSecondLastWeight()};
        status = status && (!cekWeightStatus(bayi.isMale(), bayi.getDateOfBirth(), measureDate2, weight2).equalsIgnoreCase("naik"));
        bayi.Tidak2Kali = status;
    }
    
    public void calculating(data.Person bayi){
        if(bayi.getAge()<0){
            javax.swing.JOptionPane.showMessageDialog(null, "Tanggal yang anda masukkan salah", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        cekWeightStatus(bayi);
        cekBGM(bayi);
        cekBawahKuning(bayi);
        cek2T(bayi);
    }
    
    private void cekWeightStatus(data.Person bayi){
        System.out.println("check weight status");
        String measureDate[] = {new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()),bayi.getLastVisitDate()};
        double weight[] = {bayi.getWeight(),bayi.getPreviousWeight()};
        bayi.StatusBeratBadan = cekWeightStatus(bayi.isMale(),bayi.getDateOfBirth(),measureDate,weight);
    }
    
    private String cekWeightStatus(boolean isMale, String dateOfBirth, String measureDate[], double weight[]){
        int age = monthAges(dateOfBirth,measureDate[0]);
        System.out.println(""+age);
        System.out.println(""+((weight[0]-weight[1]+0.000000000000004)*1000));
        System.out.println(""+data.RefferenceTableForKMS.maleWeightUpIndicator[age > 12 ? 12:age ]);
        String result="";
        if(isMale) 
            result = monthAges(measureDate[1],measureDate[0])>1 ? "timbang pertama" :((weight[0]-weight[1]+0.000000000000004)*1000) 
                    >= data.RefferenceTableForKMS.maleWeightUpIndicator[age > 12 ? 12:age ] 
                    ? "naik" : "tidak naik";
        else
            result = monthAges(measureDate[1],measureDate[0])>1 ? "timbang pertama" : ((weight[0]-weight[1]+0.000000000000004)*1000) 
                    >= data.RefferenceTableForKMS.femaleWeightUpIndicator[age > 11 ? 11:age ]
                    ? "naik" : "tidak naik";
        
        return result;
    }
    
    private void cekBGM(data.Person bayi){
        bayi.BGM = bayi.isMale() 
                ? data.RefferenceTableForKMS.maleBGM[bayi.getAge()]>bayi.getWeight()
                : data.RefferenceTableForKMS.femaleBGM[bayi.getAge()]>bayi.getWeight();
    }
    
    private void cekBawahKuning(data.Person bayi){
        bayi.GarisKuning = bayi.isMale() 
                ? ((data.RefferenceTableForKMS.maleGarisKuning[bayi.getAge()][0]<=bayi.getWeight())
                    && (bayi.getWeight()<=data.RefferenceTableForKMS.maleGarisKuning[bayi.getAge()][1]))
                : ((data.RefferenceTableForKMS.femaleGarisKuning[bayi.getAge()][0]<=bayi.getWeight())
                    && (bayi.getWeight()<=data.RefferenceTableForKMS.femaleGarisKuning[bayi.getAge()][1]))
                ;
    }
    
    public void printStatus(data.Person bayi){
        System.out.println("\t\t\t Tanggal : "+ new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
        System.out.println("IDENTITAS BAYI :");
        System.out.println("Nama        : "+bayi.getName());
        System.out.println("JK          : "+ (bayi.isMale() ? "laki-laki":"perempuan"));
        System.out.println("Usia        : "+ bayi.getAge()+" bulan");
        System.out.println("Berat Badan :"+ bayi.getWeight()+" kilogram");
        System.out.println("");
        System.out.println("STATUS BERAT BADAN :");
        System.out.println("status :"+bayi.StatusBeratBadan);
        System.out.println("BGM    :"+ (bayi.BGM ? "ya":"tidak"));
        System.out.println("Dalam Garis Kuning : "+(bayi.GarisKuning ? "ya":"tidak"));
        System.out.println("Tidak naik timbangan 2 kali :"+(bayi.Tidak2Kali ? "ya":"tidak"));
        
    }
    
    /*
    private String name;
    private boolean isMale;
    private int age;
    private double weight;
    private double previousWeight;
    private String lastVisitDate;
    */
}
