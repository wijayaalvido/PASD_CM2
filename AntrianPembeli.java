public class AntrianPembeli {
    NodePembeli head, tail;
    int size = 0;

    public boolean isEmpty() { // Method untuk mengecek apakah antrian kosong
        return head == null;
    }

    public void tambahAntrian(Pembeli data) { // Method untuk menambah pembeli ke antrian
        NodePembeli newNode = new NodePembeli(null, data, null); // Membuat node baru dengan data pembeli

        if (isEmpty()) { // Jika antrian kosong, head dan tail akan menunjuk ke node baru
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Pembeli hapusAntrian() { // Method untuk menghapus pembeli dari antrian
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return null;
        }

        Pembeli removed = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return removed;
    }

    public void cetakAntrian() { // Method untuk mencetak daftar pembeli yang sedang mengantri
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }

        NodePembeli current = head;
        System.out.println("No\tNama\tNo HP");
        while (current != null) {
            current.data.tampilkanData();
            current = current.next;
        }
    }
}