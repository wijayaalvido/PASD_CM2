public class DaftarPesanan {
    NodePesanan head, tail;
    int totalPendapatan = 0;

    public boolean isEmpty() { // Method untuk mengecek apakah daftar pesanan kosong
        return head == null;
    }

    public void tambahPesanan(Pesanan data) { // Method untuk menambah pesanan ke daftar
        NodePesanan newNode = new NodePesanan(null, data, null); // Membuat node baru dengan data pesanan

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        totalPendapatan += data.harga;
    }

   public void sortPesanan() {

        if (head == null) return;

        for (NodePesanan i = head; i.next != null; i = i.next) {

            for (NodePesanan j = head; j.next != null; j = j.next) {

                if (j.data.namaPesanan.compareToIgnoreCase(j.next.data.namaPesanan) > 0) {

                    Pesanan temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }

     public void sortHargaDesc() {

        if (head == null) return;

        for (NodePesanan i = head; i.next != null; i = i.next) {

            for (NodePesanan j = head; j.next != null; j = j.next) {

                if (j.data.harga < j.next.data.harga) {

                    Pesanan temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }

    public void tampilkanPesanan(int modeSort) {

    if (isEmpty()) {
        System.out.println("Belum ada pesanan.");
        return;
    }

    // Mode 1 = urut nama pesanan
    if (modeSort == 1) {
        sortPesanan();
    }

    // Mode 2 = urut harga
    else if (modeSort == 2) {
        sortHargaDesc();
    }

    NodePesanan current = head;

    System.out.printf("%-8s %-20s %-10s %-15s\n",
            "Kode", "Nama Pesanan", "Harga", "Pembeli");

    while (current != null) {

        System.out.printf("%-8d %-20s %-10d %-15s\n",
                current.data.kodePesanan,
                current.data.namaPesanan,
                current.data.harga,
                current.data.namaPembeli);

        current = current.next;
    }

    System.out.println("Total Pendapatan: Rp " + totalPendapatan);
    }
}