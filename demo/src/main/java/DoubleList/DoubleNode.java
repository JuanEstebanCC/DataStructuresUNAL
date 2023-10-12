package DoubleList;

public class DoubleNode {
    private Object data;
    private DoubleNode next;
    private DoubleNode prev;

    //Constructors
    public DoubleNode() {
        this(null);
    }

    public DoubleNode(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    //Getters y Setters
    public Object getData() {
        return data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
}