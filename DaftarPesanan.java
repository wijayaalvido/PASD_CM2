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

    public void sortPesanan() { // Method untuk mengurutkan pesanan berdasarkan nama pesanan menggunakan bubble sort
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = head;

            while (current.next != null) {
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void tampilkanPesanan() { // Method untuk menampilkan daftar pesanan
        if (isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        sortPesanan();

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