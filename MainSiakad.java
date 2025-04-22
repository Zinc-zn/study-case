import java.util.Scanner;

public class MainSiakad {
    static Dosen[] dataDosen = {
        new Dosen("D001", "Budi Hartono"),
        new Dosen("D002", "Rina Marlina"),
        new Dosen("D003", "Agus Wijaya"),
        new Dosen("D004", "Siti Aminah"),
        new Dosen("D005", "Andi Pratama")
    };

    static MataKuliah[] dataMataKuliah = {
        new MataKuliah("MK001", "Struktur Data", 3),
        new MataKuliah("MK002", "Pemrograman Java", 3),
        new MataKuliah("MK003", "Basis Data", 3),
        new MataKuliah("MK004", "Algoritma dan Pemrograman", 2),
        new MataKuliah("MK005", "Matematika Diskrit", 2),
        new MataKuliah("MK006", "Jaringan Komputer", 3),
        new MataKuliah("MK007", "Pemrograman Web", 3)
    };

    static Jadwal[] dataJadwal = {
        new Jadwal(dataDosen[0], dataMataKuliah[0], "Senin", "08:00"),
        new Jadwal(dataDosen[1], dataMataKuliah[1], "Selasa", "10:00"),
        new Jadwal(dataDosen[2], dataMataKuliah[2], "Rabu", "09:00"),
        new Jadwal(dataDosen[0], dataMataKuliah[3], "Kamis", "13:00"),
        new Jadwal(dataDosen[3], dataMataKuliah[4], "Jumat", "07:00"),
        new Jadwal(dataDosen[4], dataMataKuliah[5], "Senin", "11:00"),
        new Jadwal(dataDosen[1], dataMataKuliah[6], "Rabu", "14:00")
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tampilkan Data Dosen");
            System.out.println("2. Tampilkan Data Mata Kuliah");
            System.out.println("3. Tampilkan Data Jadwal");
            System.out.println("4. Urutkan Jadwal Berdasarkan Hari & Jam");
            System.out.println("5. Cari Jadwal Berdasarkan Nama Dosen");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanDataDosen();
                    break;
                case 2:
                    tampilkanDataMataKuliah();
                    break;
                case 3:
                    tampilkanDataJadwal();
                    break;
                case 4:
                    urutkanJadwal();
                    break;
                case 5:
                    System.out.print("Masukkan nama dosen: ");
                    String namaDosen = sc.nextLine();
                    cariJadwal(namaDosen);
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (pilihan != 0);
        
        sc.close();
    }

    static void tampilkanDataDosen() {
        System.out.println("=== DATA DOSEN ===");
        for (Dosen d : dataDosen) {
            d.tampilData();
        }
    }

    static void tampilkanDataMataKuliah() {
        System.out.println("=== DATA MATA KULIAH ===");
        for (MataKuliah mk : dataMataKuliah) {
            mk.tampilData();
        }
    }

    static void tampilkanDataJadwal() {
        System.out.println("=== DATA JADWAL KULIAH ===");
        for (Jadwal j : dataJadwal) {
            j.tampilData();
        }
    }
    static void urutkanJadwal() {
        String[] urutanHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

        
        for (int i = 0; i < dataJadwal.length-1; i++) {
            for (int j = 0; j < dataJadwal.length-1-i; j++) {
                int bandingHari = getIndexHari(dataJadwal[j].hari, urutanHari)-getIndexHari(dataJadwal[j+1].hari, urutanHari);
                if (bandingHari >0) {
                    Jadwal temp = dataJadwal[j];
                    dataJadwal[j]=dataJadwal[j+1];
                    dataJadwal[j+1]=temp;
                }else if (bandingHari==0) {
                    int bandingJam = compareJam(dataJadwal[j].jam, dataJadwal[j + 1].jam);
                
                    if (bandingJam>0) {
                        Jadwal temp = dataJadwal[j];
                        dataJadwal[j]= dataJadwal[j+1];
                        dataJadwal[j+1]=temp;

                    }
                }
            }
        }

        // Output hasil sorting
        System.out.println("=== JADWAL KULIAH TERURUT (Hari & Jam) ===");
        for (Jadwal j : dataJadwal) {
            System.out.println(j.hari+" - "+ j.jam+" | "+ j.dosen.namaDosen+" - "+ j.mataKuliah.namaMK);
        }
    }

    static int getIndexHari(String hari, String[] urutanHari) {
        for (int i = 0; i < urutanHari.length; i++) {
            if (urutanHari[i].equalsIgnoreCase(hari)) return i;
        }
        return 999;
    }
    static int compareJam(String jam1, String jam2) {
       
        String[] splitJam1 = jam1.split(":");
        String[] splitJam2 = jam2.split(":");
        
       
        int jamCompare = Integer.parseInt(splitJam1[0]) - Integer.parseInt(splitJam2[0]);
        
       
        if (jamCompare == 0) {
            return Integer.parseInt(splitJam1[1]) - Integer.parseInt(splitJam2[1]);
        }
        return jamCompare;
    }

    static void cariJadwal(String namaDosen) {
        System.out.println("=== HASIL PENCARIAN JADWAL ===");
    
        boolean ditemukan = false;
        int counter = 0;
    
        for (int i = 0; i < dataJadwal.length; i++) {
            counter++;
    
            if (dataJadwal[i].dosen.namaDosen.equalsIgnoreCase(namaDosen)) {
                ditemukan = true;
    
                System.out.println("Dosen: " + dataJadwal[i].dosen.namaDosen);
                System.out.println("Mata Kuliah: " + dataJadwal[i].mataKuliah.namaMK);
                System.out.println("Hari: " + dataJadwal[i].hari);
                System.out.println("Jam: " + dataJadwal[i].jam);
                System.out.println();
            }
        }
    
        if (!ditemukan) {
            System.out.println("Tidak ditemukan jadwal untuk dosen dengan nama: " + namaDosen);
        }
    
        // (opsional) info debug:
        // System.out.println("Jumlah iterasi: " + counter);
    }
    
}