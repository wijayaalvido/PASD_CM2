public class NodePesanan {
    Pesanan data;
    NodePesanan prev, next;

    public NodePesanan(NodePesanan prev, Pesanan data, NodePesanan next) { // Constructor untuk membuat node pesanan
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}