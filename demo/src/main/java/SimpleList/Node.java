package SimpleList;

public class Node {
    private Object data;
    private Node next;

    //Constructoress, uno para settearlo por defecto y otro para settearlo con un valor
    public Node() {
        this(null);
    }
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    //Getters y Setters
    public Object getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
