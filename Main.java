import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Deklarasi scanner untuk memasukkan inputan
        Scanner input = new Scanner(System.in);
        
        // Akun default
        String[][] userData = {{"naufal", "000"},{"putra", "111"},{"farhan", "222"}};

        // Lokasi default
        String[] arrayLokasi = new String[100];
            arrayLokasi[0] = "Malang";
            arrayLokasi[1] = "Jakarta";
            arrayLokasi[2] = "Surabaya";
            arrayLokasi[3] = "Bandung";
            arrayLokasi[4] = "Medan";
            arrayLokasi[5] = "Makassar";
            arrayLokasi[6] = "Yogyakarta";
            arrayLokasi[7] = "Semarang";
        // Tarif berdasarkan tujuan pengiriman
        double[] arrayTarifLokasi = new double[100];
            arrayTarifLokasi[0] = 8000;
            arrayTarifLokasi[1] = 45000;
            arrayTarifLokasi[2] = 25000;
            arrayTarifLokasi[3] = 16000;
            arrayTarifLokasi[4] = 23000;
            arrayTarifLokasi[5] = 34000;
            arrayTarifLokasi[6] = 36000;
            arrayTarifLokasi[7] = 23000;
            
        // Layanan pengiriman default
        String[] arrayLayanan = new String[20];
            arrayLayanan[0] = "Reguler";
            arrayLayanan[1] = "Ekonomi";
            arrayLayanan[2] = "Sameday";
        // Tarif berdasarkan jenis layanan
        double[] arrayTarifLayanan = new double[20];
            arrayTarifLayanan[0] = 10000;
            arrayTarifLayanan[1] = 6000;
            arrayTarifLayanan[2] = 20000;

        boolean login = false;
        boolean found = false;
        boolean exit = false;
        boolean isLoop = false;
        // Variabel untuk switch case menu
        int menuUtama, subMenu;
        // Variabel Searching
        String key;
        int beratBarang;
        double biayaAkhir;
        String lokasiPengiriman;
        double tarifPerKg = 5000;
        int pilihanLayanan;
        double tarifLayanan = 0;
        String namaPengirim;
        double biayaJarak = 0;

        // Array History Pemesanan
        String[][] historyTransaksi = new String[100][4];

        int pilihanBahasa = 1, inputPilihanBahasa;

        // Array Multi Bahasa
        String[][] multilingual = {
            {"Welcome to the Expedition System", "Selamat Datang di Sistem Ekspedisi"},
            // Bahasa menu utama
            {"Delivery of Goods", "Pengiriman Barang"}, //1
            {"Location Management", "Manajemen Lokasi"},
            {"Cost Management", "Manajemen Tarif"},
            {"Change Language", "Ganti Bahasa"},
            {"Exit", "Keluar"},

            // Bahasa input pilihan
            {"Enter Options: ", "Masukkan Pilihan: "}, //6

            // Bahasa menu pengiriman barang
            {"Transactions", "Melakukan Transaksi"},
            {"Editing Transactions", "Mengedit Transaksi"},
            {"Remove Transactions", "Menghapus Transaksi"},
            {"Displyas Transactions' Data", "Menampilkan Data Transaksi"}, //10
            {"Back to the Main Menu", "Kembali ke Menu Utama"},

            // Bahasa menu manajemen lokasi
            {"Add Location", "Menambahkan Lokasi"}, //12
            {"Remove Location", "Menghapus Lokasi"},
            {"Displays Location's Data", "Menampilkan Data Lokasi"},
            {"Back to the Main Menu", "Kembali ke Menu Utama"},

            // Bahasa menu Manajemen Tarif
            {"Add Service Types", "Tambahkan Jenis Layanan"},
            {"Change Cost Service", "Merubah Tarif Layanan"},
            {"Remove Service", "Menghapus Layanan"},
            {"Displays Services' Data", "Menampilkan Layanan Data"},
            {"Exit", "Keluar"}, //20

                // submenu Transactions
                {"Enter the Sender's Name","Masukkan Nama Pengirim"}, // 21
                {"Enter the weight of the item", "Masukkan Berat Barang"},
                {"Enter Destination", "Masukkan Kota Tujuan"},
                {"Destination not Found", "KOta Tujuan tidak ditemukan"}
        };

        System.out.println("=============================================");
        System.out.println("\u001B[33m     "+multilingual[0][pilihanBahasa]+"     \u001B[0m");
        System.out.println("=============================================");

        while (!login) {
            System.out.print("Masukkan Username: ");
            String inputUsername = input.next();

            System.out.print("Masukan Password: ");
            String inputPassword = input.next();

            for (int i = 0; i < userData.length ; i++ ) {
                if (userData[i][0].equals(inputUsername) && userData[i][1].equals(inputPassword)) {
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
            System.out.println("\u001B[33m   " + multilingual[0][pilihanBahasa] + "   \u001B[0m");
            System.out.println("=======================================");
            System.out.println("[1]. " + multilingual[1][pilihanBahasa]);
            System.out.println("[2]. " + multilingual[2][pilihanBahasa]);
            System.out.println("[3]. " + multilingual[3][pilihanBahasa]);
            System.out.println("[4]. " + multilingual[4][pilihanBahasa]);
            System.out.println("[5]. " + multilingual[5][pilihanBahasa]);
            System.out.println("=======================================");
            

            System.out.print(multilingual[6][pilihanBahasa] );
            menuUtama = input.nextInt();
            input.nextLine();

            isLoop = true;

            do {
                switch (menuUtama) {
                    case 1:
                        System.out.println("=======================================");
                        System.out.println("\u001B[33m"           + multilingual[1][pilihanBahasa] +          "\u001B[0m");
                        System.out.println("=======================================");
                        System.out.println(" \u001B[32m[1]." + multilingual[7][pilihanBahasa]+            "\u001B[0m");
                        System.out.println(" \u001B[33m[2]." + multilingual[8][pilihanBahasa]+              "\u001B[0m");
                        System.out.println(" \u001B[31m[3]." + multilingual[9][pilihanBahasa]+             "\u001B[0m");
                        System.out.println(" [4]." + multilingual[10][pilihanBahasa]+      "\u001B[0m");
                        System.out.println(" [5]." + multilingual[11][pilihanBahasa]+           "\u001B[0m");
                        System.out.println("=======================================");
                        System.out.print( multilingual[6][pilihanBahasa] );
                        subMenu = input.nextInt();
                        input.nextLine();

                        switch (subMenu) {
                            case 1:
                                System.out.print (multilingual[21][pilihanBahasa]);
                                namaPengirim = input.nextLine();
                                System.out.print (multilingual[22][pilihanBahasa]);
                                beratBarang = input.nextInt();
                                //Mencari Kota Pengiriman pada Array
                                do {
                                    System.out.print (multilingual[23][pilihanBahasa]);
                                    lokasiPengiriman = input.next();
                                    for (int i = 0; i < arrayLokasi.length; i++) {
                                        if (arrayLokasi[i] != null && arrayLokasi[i].equalsIgnoreCase(lokasiPengiriman)) {
                                            biayaJarak = arrayTarifLokasi[i];
                                            found = true;
                                            break;
                                        }
                                    }
                                    if(found != true) {
                                        System.out.println(multilingual[24][pilihanBahasa]);
                                    }    
                                } while (found == false);
                                found = false;

                                //Memilih Jenis Layanan pada Array

                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] != null) {
                                        System.out.println("["+i+"]. "+arrayLayanan[i]+" - "+arrayTarifLayanan[i]);
                                        
                                    }
                                }
                                System.out.print (multilingual[6][pilihanBahasa]);
                                pilihanLayanan = input.nextInt();
                                tarifLayanan = arrayTarifLayanan[pilihanLayanan];                      

                                biayaAkhir = tarifLayanan + (tarifPerKg * beratBarang) + biayaJarak;
                                System.out.println(biayaAkhir);

                                for (int i = 0; i < historyTransaksi.length; i++) {
                                    if (historyTransaksi[i][0] == null) {
                                        historyTransaksi[i][0] = namaPengirim;
                                        historyTransaksi[i][1] = lokasiPengiriman;
                                        historyTransaksi[i][2] = arrayLayanan[pilihanLayanan];
                                        historyTransaksi[i][3] = Double.toString(biayaAkhir);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                /*for (int i = 0; i < historyTransaksi.length; i++) {
                                    for (int j = 0; j < historyTransaksi[i].length; j++) {
                                        if (arrayLayanan[i] != null && arrayLayanan[i].equalsIgnoreCase(key)) {
                                            System.out.print("Masukkan Nama Layanan Baru: ");
                                            arrayLayanan[i] = input.next();
                                            System.out.print("Masukkan Tarif Baru: ");
                                            arrayTarifLayanan[i] = input.nextDouble();
                                            found = true;
                                            break;
                                        }
                                    }
                                }*/
                                System.out.println("Under Development");                                          
                                break;
                            case 3:
                                System.out.println("Under Development"); 
                                break;
                            case 4:
                                for (int i = 0; i < historyTransaksi.length; i++) {
                                   if (historyTransaksi[i][0] != null) {
                                        System.out.println("=======================================");
                                        System.out.println("\u001B[33m           History Transaksi "+(i+1)+"          \u001B[0m");
                                        System.out.println("=======================================");
                                        System.out.println("Nama Pengirim: "+historyTransaksi[i][0]);
                                        System.out.println("Tujuan Pengiriman: "+historyTransaksi[i][1]);
                                        System.out.println("Jenis Layanan: "+historyTransaksi[i][2]);
                                        System.out.println("Total Biaya: "+historyTransaksi[i][3]);
                                        System.out.println("=======================================");
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
                    case 2:
                        System.out.println("=======================================");
                        System.out.println("\u001B[33m" + multilingual[2][pilihanBahasa]+   "\u001B[0m");
                        System.out.println("=======================================");
                        System.out.println("+ \u001B[32m[1]." + multilingual[12][pilihanBahasa]+              "\u001B[0m");
                        System.out.println("+ \u001B[31m[2]." + multilingual[13][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("+ [3]."+ multilingual[14][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("+ [4]."+ multilingual[15][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("=======================================");
                        System.out.print(multilingual[6][pilihanBahasa]);                        subMenu = input.nextInt();
                        input.nextLine();
            
                        switch (subMenu) {
                            case 1:
                                for (int i = 0; i < arrayLokasi.length; i++) {
                                    if (arrayLokasi[i] == null) {
                                        System.out.print("Masukkan nama lokasi: ");
                                        arrayLokasi[i] = input.nextLine();
                                        System.out.print("Masukkan tarif: ");
                                        arrayTarifLokasi[i] = input.nextDouble();
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
                                        System.out.println("["+i+"]. "+arrayLokasi[i]+" - "+arrayTarifLokasi[i]);
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
                        System.out.println("\u001B[33m"+ multilingual[3][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("=======================================");
                        System.out.println("+ \u001B[32m[1]." + multilingual[16][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("+ \u001B[33m[2]." + multilingual[17][pilihanBahasa]+  "\u001B[0m+");
                        System.out.println("+ \u001B[31m[3]." + multilingual[18][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("+ [4]." + multilingual[19][pilihanBahasa]+  "\u001B[0m");
                        System.out.println("+ [5]." + multilingual[20][pilihanBahasa]+ "\u001B[0m");
                        System.out.println("=======================================");
                        System.out.print(multilingual[6][pilihanBahasa]);
                        subMenu = input.nextInt();
                        input.nextLine();

                        switch (subMenu) {
                            case 1:
                                for (int i = 0; i < arrayLayanan.length; i++) {
                                    if (arrayLayanan[i] == null) {
                                        System.out.print("Masukkan Nama Layanan: ");
                                        arrayLayanan[i] = input.next();
                                        System.out.print("Masukkan Tarif: ");
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
                        do {
                            System.out.println("Pilih bahasa (Choose a language):");
                            System.out.println("1. English");
                            System.out.println("2. Indonesian");
                            System.out.print("Masukkan Pilihan: ");
                            inputPilihanBahasa = input.nextInt();

                            switch (inputPilihanBahasa) {
                                case 1:
                                    pilihanBahasa = inputPilihanBahasa-1;
                                    break;
                                case 2:
                                    pilihanBahasa = inputPilihanBahasa-1;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } while (inputPilihanBahasa > multilingual[0].length);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                break;
            } while (isLoop);


        } while (!exit);


    }
}
