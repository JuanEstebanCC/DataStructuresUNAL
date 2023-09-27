package Stack;

import SimpleList.List;

public class Stack {
    private List list;
    private int size;

    //Constructors
    public Stack() {
        this.list = new List();
        this.size = list.getSize();
    }

    //Methods

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object top() {
        return list.First();
    }

    public void push(Object e) {
        list.addFirst(e);
    }

    public Object pop() {
        return list.removeFirst();
    }

}