public class Dosen {

    String nidn, namaDosen;

    Dosen(String nidn, String namaDosen){
        this.nidn=nidn;
        this.namaDosen=namaDosen;
    }

    public String getNIDN() {
        return nidn;
    }
    
    public String getNama() {
        return namaDosen;
    }

    void tampilData(){
        System.out.println("NIDN: "+ nidn);
        System.out.println("Nama : "+ namaDosen);
    }
}