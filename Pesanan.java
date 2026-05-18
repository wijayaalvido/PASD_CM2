public class Pesanan {
    int kodePesanan;
    String namaPesanan;
    int harga;
    String namaPembeli;

    public Pesanan(int kodePesanan, String namaPesanan, int harga, String namaPembeli) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.namaPembeli = namaPembeli;
    }

    public void tampilkanPesanan() {
        System.out.println(kodePesanan + "\t" + namaPesanan + "\t" + harga + "\t" + namaPembeli);
    }
}