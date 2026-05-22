import java.util.Scanner;
public class MainRoyalDelish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPembeli antrian = new AntrianPembeli(); // Membuat objek antrian pembeli
        DaftarPesanan daftar = new DaftarPesanan(); // Membuat objek daftar pesanan

        // Menambahkan 4 data pembeli dummy langsung melalui constructor
        // agar antrian sudah terisi saat program dijalankan

        antrian.tambahAntrian(new Pembeli(1, "Andi", "081234567890"));
        antrian.tambahAntrian(new Pembeli(2, "Budi", "082345678901"));
        antrian.tambahAntrian(new Pembeli(3, "Citra", "083456789012"));
        antrian.tambahAntrian(new Pembeli(4, "Dina", "084567890123"));

        // Nomor antrian dimulai dari 5 karena data awal sudah ada 4
        int nomorAntrian = 5;

        int pilihan;

        do {
            System.out.println("\n================================");
            System.out.println("====== RESTO ROYAL DELISH ======");
            System.out.println("================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian & Input Pesanan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli: ");
                    String nama = sc.nextLine();

                    System.out.print("No HP       : ");
                    String hp = sc.nextLine();

                    Pembeli pembeli = new Pembeli(nomorAntrian, nama, hp);
                    antrian.tambahAntrian(pembeli);

                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + nomorAntrian);
                    nomorAntrian++;
                    break;

                case 2:
                    antrian.cetakAntrian();
                    break;

                case 3:
                    Pembeli dipanggil = antrian.hapusAntrian();

                    if (dipanggil != null) {
                        System.out.println("Pembeli dipanggil:");
                        dipanggil.tampilkanData();

                        System.out.print("Kode Pesanan: ");
                        int kode = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nama Pesanan: ");
                        String namaPesanan = sc.nextLine();

                        System.out.print("Harga: ");
                        int harga = sc.nextInt();

                        Pesanan pesanan = new Pesanan(kode, namaPesanan, harga, dipanggil.namaPembeli);
                        daftar.tambahPesanan(pesanan);

                        System.out.println("Pesanan berhasil ditambahkan.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== MODE LAPORAN PESANAN ===");
                    System.out.println("1. Urut Nama Pesanan (A-Z)");
                    System.out.println("2. Urut Harga (Termahal -> Termurah)");
                    System.out.print("Pilih mode: ");

                    int mode = sc.nextInt();

                    // Menampilkan laporan sesuai mode yang dipilih
                    daftar.tampilkanPesanan(mode);
                    while (mode != 1 && mode != 2) {
                        System.out.println("Mode tidak valid! Silakan pilih 1 atau 2.");
                        System.out.print("Pilih mode: ");
                        mode = sc.nextInt();
                    }
                    break;

                case 5:
                    daftar.sortHargaDesc();
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilihan != 0);
    }
}