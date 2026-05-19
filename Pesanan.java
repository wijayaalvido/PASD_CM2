public class Pesanan {
    int kodePesanan;
    String namaPesanan;
    int harga;
    String namaPembeli;

    public Pesanan(int kodePesanan, String namaPesanan, int harga, String namaPembeli) { // Constructor untuk membuat data pesanan
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.namaPembeli = namaPembeli;
    }

    public void tampilkanPesanan() { // Method untuk menampilkan data pesanan
        System.out.println(kodePesanan + "\t" + namaPesanan + "\t" + harga + "\t" + namaPembeli);
    }
}