package SimpleList;

public class List {
    Node head;
    Node tail;
    int size;

    //Constructors
    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Methods
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public Node First() {
        return head;
    }
    public Node Last() {
        return tail;
    }

    public void addFirst(Object e){
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
            size++;
        }
    }
    public void addLast(Object e){
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
            size++;
        }
    }
    public Object removeFirst() {
        if (!isEmpty()) {
            Node temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        } else {
            return null;
        }
    }

    public Object removeLast() {
        if (size == 1) {
            return removeFirst();
        } else {
            Node temp = tail;
            Node prev = head;
            while (prev.getNext() != tail) {
                prev = prev.getNext();
            }
            prev.setNext(null);
            tail = prev;
            size--;
            return temp.getData();
        }
    }
}
