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
            DoubleNode temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
            if (isEmpty()) {
                tail = null;
            } else {
                head.setPrev(null);
            }
            return temp.getData();
        }
    }

    public Object removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            DoubleNode temp = tail;
            tail = tail.getPrev();
            temp.setPrev(null);
            size--;
            if (isEmpty()) {
                head = null;
            } else {
                tail.setNext(null);
            }
            return temp.getData();
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

    public void addBefore(DoubleNode n, Object e) {
        if (n == this.First()) {
            this.addFirst(e);
        } else {
            DoubleNode node = new DoubleNode(e);
            node.setPrev(n.getPrev());
            node.setNext(n);
            n.getPrev().setNext(node);
            n.setPrev(node);
            size++;
        }
    }

    public void addAfter(DoubleNode n, Object e) {
        if (n == this.Last()) {
            this.addLast(e);
        } else {
            DoubleNode node = new DoubleNode(e);
            node.setPrev(n);
            node.setNext(n.getNext());
            n.getNext().setPrev(node);
            n.setNext(node);
            size++;
        }
    }

}