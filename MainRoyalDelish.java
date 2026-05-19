import java.util.Scanner;
public class MainRoyalDelish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPembeli antrian = new AntrianPembeli(); // Membuat objek antrian pembeli
        DaftarPesanan daftar = new DaftarPesanan(); // Membuat objek daftar pesanan

        int pilihan;
        int nomorAntrian = 1;

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
                    daftar.tampilkanPesanan();
                    break;

                case 5:
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilihan != 5);
    }
}