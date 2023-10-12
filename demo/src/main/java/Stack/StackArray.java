package Stack;

public class StackArray {
    private Object[] array;
    private int top;

    //Constructors
    public StackArray(int n) {
        this.array = new Object[n];
        this.top = -1;
    }

    //Methods
    public int getSize() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top + 1 == 0;
    }

    public Object top() {
        if (isEmpty()) {
            return null;
        } else {
            return array[top];
        }
    }

    public void push(Object e) {
        if (top + 1 == array.length) {
            System.out.println("Stack is full");
        } else {
            array[top + 1] = e;
            top++;
        }
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        } else {
            Object temp = array[top];
            array[top] = null;
            top--;
            return temp;
        }
    }
}