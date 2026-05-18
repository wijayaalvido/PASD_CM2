public class Pembeli {
    String namaPembeli;
    String noHp;
    int noAntrian;

    public Pembeli(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    public void tampilkanData() {
        System.out.println(noAntrian + "\t" + namaPembeli + "\t" + noHp);
    }
}