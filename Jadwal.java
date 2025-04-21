public class Jadwal {
    Dosen dosen;
    MataKuliah mataKuliah;
    String hari;
    String jam;

    public Jadwal(Dosen dosen, MataKuliah mataKuliah, String hari, String jam) {
        this.dosen = dosen;
        this.mataKuliah = mataKuliah;
        this.hari = hari;
        this.jam = jam;
    }

    public int hitungMenit() {
        return mataKuliah.sks * 50;
    }

    public void tampilData() {
        System.out.println("Dosen\t: " + dosen.namaDosen);
        System.out.println("Mata Kuliah\t: " + mataKuliah.namaMK);
        System.out.println("SKS\t: " + mataKuliah.sks);
        System.out.println("Hari\t: " + hari);
        System.out.println("Jam\t: " + jam);
        System.out.println("Durasi\t: " + hitungMenit() + " menit");
        System.out.println();
    }
}
