public class AntrianPembeli {
    NodePembeli head, tail;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(Pembeli data) {
        NodePembeli newNode = new NodePembeli(null, data, null);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Pembeli hapusAntrian() {
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

    public void cetakAntrian() {
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