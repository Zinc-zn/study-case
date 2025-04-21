class MataKuliah {
    String kodeMK;
    String namaMK;
    int sks;
    
    public MataKuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }
    
    public String getKode() {
        return kodeMK;
    }
    
    public String getNama() {
        return namaMK;
    }
    
    public int getSks() {
        return sks;
    }
    
    public void tampilData() {
        System.out.println("Kode: " + kodeMK + ", Nama: " + namaMK + ", SKS: " + sks);
    }
}