package csci2720.app;

public class NodeType<T extends Comparable<T>> {

    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    public NodeType() {
        this.info = null;
        this.next = null;
        this.back = null;
    } // NodeType

} // NodeType
