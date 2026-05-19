public class NodePembeli {
    Pembeli data;
    NodePembeli prev, next;

    public NodePembeli(NodePembeli prev, Pembeli data, NodePembeli next) { // Constructor untuk membuat node pembeli
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}