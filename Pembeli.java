public class Pembeli {
    String namaPembeli;
    String noHp;
    int noAntrian;

    public Pembeli(int noAntrian, String namaPembeli, String noHp) { // Constructor untuk membuat data pembeli
        this.noAntrian = noAntrian; 
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    public void tampilkanData() { // Method untuk menampilkan data pembeli
        System.out.println(noAntrian + "\t" + namaPembeli + "\t" + noHp);
    }
}