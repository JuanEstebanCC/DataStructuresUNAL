package DoubleList;

public class DoubleList{
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    //Constructors
    public DoubleList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Methods
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public DoubleNode First() {
        return head;
    }

    public DoubleNode Last() {
        return tail;
    }

    public void addFirst(Object e){
        DoubleNode node = new DoubleNode(e);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
            size++;
        }
    }

    public void addLast(Object e){
        DoubleNode node = new DoubleNode(e);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            size++;
        }
    }
}