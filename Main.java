import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Deklarasi scanner untuk memasukkan inputan
        Scanner input = new Scanner(System.in);

        String[] usernames = {"naufal", "putra", "farhan"};
        String[] passwords = {"000", "111", "222"};

        String[] arrayLokasi = new String[100];
            arrayLokasi[0] = "Malang";
            arrayLokasi[1] = "Jakarta";
            arrayLokasi[2] = "Surabaya";
            arrayLokasi[3] = "Bandung";
            arrayLokasi[4] = "Medan";
            arrayLokasi[5] = "Makassar";
            arrayLokasi[6] = "Yogyakarta";
            arrayLokasi[7] = "Semarang";
            
        String[] arrayLayanan = new String[20];
            arrayLayanan[0] = "Reguler";
            arrayLayanan[1] = "Sameday";

        double[] arrayTarifLayanan = new double[20];
            arrayTarifLayanan[0] = 10000;
            arrayTarifLayanan[1] = 20000;

        boolean login = false;
        boolean found = false;
        boolean exit = false;
        boolean isLoop = false;
        int menuUtama, subMenu;
        String key;
        int beratBarang, jarakPengiriman;
        double biayaAkhir;
        String lokasiPengiriman;
        double tarifPerKg = 5000, tarifPerKm = 1000;
        int pilihanLayanan;
        double tarifLayanan = 0;
        String namaPengirim;

        String[] historyNamaPengirim = new String[100];
        String[] historyTujuan = new String[100];
        String[] historyLayanan = new String[100];
        double[] historyBiaya = new double[100];

        System.out.println("=============================================");
        System.out.println("\u001B[33m     Selamat Datang di Sistem Ekspedisi     \u001B[0m");
        System.out.println("=============================================");

        while (!login) {
            System.out.print("Masukkan Username: ");
            String inputUsername = input.next();

            System.out.print("Masukan Password: ");
            String inputPassword = input.next();

            for (int i = 0; i < usernames.length ; i++ ) {
                if ((usernames[i].equals(inputUsername)) && (passwords[i].equals(inputPassword))) {
                    System.out.println("Login Berhasil");
                    login = true;
                    break;
                }    
            }
            if(!login){
                System.out.println("Login Gagal, silahkan coba lagi!");
            }
        }

        do {
            System.out.println("=======================================");
            System.out.println("\u001B[33m   Selamat Datang di Sistem Ekspedisi   \u001B[0m");
            System.out.println("=======================================");
            System.out.println("+ [1]. Pengiriman Barang              \u001B[0m+");
            System.out.println("+ [2]. Manajemen Lokasi               \u001B[0m+");
            System.out.println("+ [3]. Manajemen Tarif                \u001B[0m+");
            System.out.println("+ [4]. Keluar                         \u001B[0m+");
            System.out.println("=======================================");

            System.out.print("Masukkan Pilihan: ");
            menuUtama = input.nextInt();
            input.nextLine();

            isLoop = true;

            do {
                switch (menuUtama) {
                    case 1:
                        System.out.println("=======================================");
                        System.out.println("\u001B[33m           Pengiriman Barang          \u001B[0m");
                        System.out.println("=======================================");
                        System.out.println("+ \u001B[32m[1]. Melakukan Transaksi            \u001B[0m+");
                        System.out.println("+ \u001B[33m[2]. Mengedit Transaksi             \u001B[0m+");
                        System.out.println("+ \u001B[31m[3]. Menghapus Transaksi            \u001B[0m+");
                        System.out.println("+ [4]. Menampilkan Data Transaksi     \u001B[0m+");
                        System.out.println("+ [5]. Kembali ke Menu Utama          \u001B[0m+");
                        System.out.println("=======================================");
                        System.out.print("Masukkan Pilihan: ");
                        subMenu = input.nextInt();
                        input.nextLine();

                        switch (subMenu) {
                            case 1:
                                System.out.print ("Masukkan Nama Pengirim: ");
                                namaPengirim = input.next();
                                System.out.print ("Masukkan Berat Barang: ");
                                beratBarang = input.nextInt();
                                System.out.print ("Masukkan Jarak Pengiriman: ");
                                jarakPengiriman = input.nextInt();
                                //Mencari Kota Pengiriman pada Array
                                do {
                                    System.out.print ("Masukkan Kota Tujuan: ");
                                    lokasiPengiriman = input.next();
                                    for (int i = 0; i < arrayLokasi.length; i++) {
                                        if (arrayLokasi[i] != null && arrayLokasi[i].equalsIgnoreCase(lokasiPengiriman)) {
                                            found = true;
                                            break;
                                        }
                                    }
                                    if(found != true) {
                                        System.out.println("Kota tidak ditemukan");
                                    }    
                                } while (found == false);
                                found = false;

                                //Memilih Jenis Layanan pada Array

                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] != null) {
                                        System.out.println("["+i+"]. "+arrayLayanan[i]+" - "+arrayTarifLayanan[i]);
                                        
                                    }
                                }
                                System.out.print ("Masukkan Pilihan: ");
                                pilihanLayanan = input.nextInt();
                                tarifLayanan = arrayTarifLayanan[pilihanLayanan];                      

                                biayaAkhir = tarifLayanan + (tarifPerKg * beratBarang) + (tarifPerKm * jarakPengiriman);
                                System.out.println(biayaAkhir);

                                for (int i = 0; i < historyNamaPengirim.length; i++) {
                                    if (historyNamaPengirim[i] != null) {
                                        historyNamaPengirim[i] = namaPengirim;
                                        historyLayanan[i] = arrayLayanan[pilihanLayanan];
                                        historyTujuan[i] = lokasiPengiriman;
                                        historyBiaya[i] = tarifLayanan;
                                    }
                                }
                                break;
                            case 2:                                          
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                isLoop = false;
                                break;
                            default:
                            System.out.println("Invalid choice. Please try again.");
                        }
                        break;                        
                    case 2:
                        System.out.println("=======================================");
                        System.out.println("\u001B[33m           Manajemen Lokasi           \u001B[0m");
                        System.out.println("=======================================");
                        System.out.println("+ \u001B[32m[1]. Menambahkan Lokasi             \u001B[0m+");
                        System.out.println("+ \u001B[31m[2]. Menghapus Lokasi               \u001B[0m+");
                        System.out.println("+ [3]. Menampilkan Data Lokasi        \u001B[0m+");
                        System.out.println("+ [4]. Kembali ke Menu Utama          \u001B[0m+");
                        System.out.println("=======================================");
                        System.out.print("Masukkan Pilihan: ");
                        subMenu = input.nextInt();
                        input.nextLine();
            
                        switch (subMenu) {
                            case 1:
                                for (int i = 0; i < arrayLokasi.length; i++) {
                                    if (arrayLokasi[i] == null) {
                                        System.out.print("Masukkan nama lokasi: ");
                                        arrayLokasi[i] = input.next();
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Masukkan lokasi yang ingin dihapus: ");
                                key = input.next();
                                for (int i = 0; i < arrayLokasi.length; i++) {
                                    if (arrayLokasi[i] != null && arrayLokasi[i].equalsIgnoreCase(key)) {
                                        System.out.println(arrayLokasi[i]+" Telah Dihapus!");
                                        arrayLokasi[i] = null;
                                        found = true;
                                        break;
                                    }
                                }
                                if(found == true) {
                                    found = false;
                                } else {
                                    System.out.println("Key tidak ditemukan");
                                }                                            
                                break;
                            case 3:
                                System.out.println("=======================================");
                                System.out.println("\u001B[33m           Data Lokasi           \u001B[0m");
                                System.out.println("=======================================");
                                for (int i = 0; i < arrayLokasi.length; i++) {
                                    if (arrayLokasi[i] != null) {
                                        System.out.println("["+i+"]. "+arrayLokasi[i]);
                                    }
                                }
                                break;
                            case 4:
                                isLoop = false;
                                break;
                            default:
                            System.out.println("Invalid choice. Please try again.");
                        }
                        break;
                    case 3:
                        System.out.println("=======================================");
                        System.out.println("\u001B[33m           Manajemen Tarif            \u001B[0m");
                        System.out.println("=======================================");
                        System.out.println("+ \u001B[32m[1]. Menambahkan Jenis Layanan      \u001B[0m+");
                        System.out.println("+ \u001B[33m[2]. Mengubah Tarif Layanan         \u001B[0m+");
                        System.out.println("+ \u001B[31m[3]. Menghapus Layanan              \u001B[0m+");
                        System.out.println("+ [4]. Menampilkan Data Layanan       \u001B[0m+");
                        System.out.println("+ [5]. Keluar                         \u001B[0m+");
                        System.out.println("=======================================");
                        System.out.print("Masukkan Pilihan: ");
                        subMenu = input.nextInt();
                        input.nextLine();

                        switch (subMenu) {
                            case 1:
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] == null) {
                                        System.out.print("Masukkan nama layanan: ");
                                        arrayLayanan[i] = input.next();
                                        System.out.print("Masukkan tarif: ");
                                        arrayTarifLayanan[i] = input.nextDouble();
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Masukkan nama layanan: ");
                                key = input.next();
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] != null && arrayLayanan[i].equalsIgnoreCase(key)) {
                                        System.out.print("Masukkan Nama Layanan Baru: ");
                                        arrayLayanan[i] = input.next();
                                        System.out.print("Masukkan Tarif Baru: ");
                                        arrayTarifLayanan[i] = input.nextDouble();
                                        found = true;
                                        break;
                                    }
                                }
                                if(found == true) {
                                    found = false;
                                } else {
                                    System.out.println("Key tidak ditemukan");
                                }                                            
                                break;
                            case 3:
                                System.out.print("Masukkan layanan yang ingin dihapus: ");
                                key = input.next();
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] != null && arrayLayanan[i].equalsIgnoreCase(key)) {
                                        System.out.println(arrayLayanan[i]+" - "+arrayTarifLayanan[i]+" Telah Dihapus!");
                                        arrayLokasi[i] = null;
                                        arrayTarifLayanan[i] = 0;
                                        found = true;
                                        break;
                                    }
                                }
                                if(found == true) {
                                    found = false;
                                } else {
                                    System.out.println("Key tidak ditemukan");
                                }                                            
                                break;
                            case 4:
                                System.out.println("=======================================");
                                System.out.println("\u001B[33m           Data Layanan           \u001B[0m");
                                System.out.println("=======================================");
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] != null) {
                                        System.out.println("["+i+"]. "+arrayLayanan[i]+" - "+arrayTarifLayanan[i]);
                                    }
                                }
                                break;
                            case 5:
                                isLoop = false;
                                break;
                            default:
                            System.out.println("Invalid choice. Please try again.");
                        }
                        break;

                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (isLoop);


        } while (exit == false);


    }
}