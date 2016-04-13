package calculation;

/**
 *
 * @author Wind Raider Zero
 */
public class Calculator {
    
    public void cek2T(data.Person bayi){
        String currentDate = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date());
        int tahun = Integer.parseInt(currentDate.substring(0,4))-Integer.parseInt(bayi.getLastVisitDate().substring(0,4));
        int bulan = Integer.parseInt(currentDate.substring(5,7))-Integer.parseInt(bayi.getLastVisitDate().substring(5,7));
        
        bayi.Tidak2Kali = (tahun*12 + bulan) > 2;
    }
    
    public void calculating(data.Person bayi){
        //if(bayi.getPreviousWeight()!=0.0){
        cekWeightStatus(bayi);    
        cekBGM(bayi);
        cekBawahKuning(bayi);
        cek2T(bayi);
        //}
        //else
        
    }
    
    private void cekWeightStatus(data.Person bayi){
        if(bayi.isMale())
            bayi.StatusBeratBadan = bayi.getPreviousWeight()==0.0 ? "timbang pertama" : 
                ((bayi.getWeight()-bayi.getPreviousWeight())*1000) > data.Constants
                .maleWeightUpIndicator[bayi.getAge() > 12 ? 12:bayi.getAge() ] ? "naik" : "tidak naik";
        else
            bayi.StatusBeratBadan = bayi.getPreviousWeight()==0.0 ? "timbang pertama" : 
                ((bayi.getWeight()-bayi.getPreviousWeight())*1000) > data.Constants
                .femaleWeightUpIndicator[bayi.getAge() > 11 ? 11:bayi.getAge() ] ? "naik" : "tidak naik";
    }
    
    private void cekBGM(data.Person bayi){
        bayi.BGM = bayi.isMale() 
                ? data.Constants.maleBGM[bayi.getAge()]>bayi.getWeight()
                : data.Constants.femaleBGM[bayi.getAge()]>bayi.getWeight();
    }
    
    private void cekBawahKuning(data.Person bayi){
        bayi.GarisKuning = bayi.isMale() 
                ? ((data.Constants.maleGarisKuning[bayi.getAge()][0]<=bayi.getWeight())
                    && (bayi.getWeight()<=data.Constants.maleGarisKuning[bayi.getAge()][1]))
                : ((data.Constants.femaleGarisKuning[bayi.getAge()][0]<=bayi.getWeight())
                    && (bayi.getWeight()<=data.Constants.femaleGarisKuning[bayi.getAge()][1]))
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
