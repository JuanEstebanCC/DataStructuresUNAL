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

    public Object removeFirst(){
        if (isEmpty()) {
            return null;
        } else {
            Object temp = head.getData();
            temp.setNext(null);
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = null;
            } else {
                head.setPrev(null);
            }
            return temp;
        }
    }

    public Object removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Object temp = tail.getData();
            temp.setPrev(null);
            tail = tail.getPrev();
            size--;
            if (isEmpty()) {
                head = null;
            } else {
                tail.setNext(null);
            }
            return temp;
        }
    }

    public Object remove(DoubleNode n) {
        if (n == this.First()) {
            return removeFirst();
        } else if (n == this.Last()) {
            return removeLast();
        } else {
            Object temp = n.getData();
            n.getPrev().setNext(n.getNext());
            n.getNext().setPrev(n.getPrev());
            n.setNext(null);
            n.setPrev(null);
            size--;
            return temp;
        }
    }


}