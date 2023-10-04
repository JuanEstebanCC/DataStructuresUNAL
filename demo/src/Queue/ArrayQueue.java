package Queue;


public class ArrayQueue {
    // Atributes
    private Object[] data;
    private int first;
    private int rear;


    // Constructor
    public ArrayQueue(int capacity){
        this.data = new Object[capacity];
        this.first = -1;
        this.rear = -1;
    }

    // Methods
    public int getSize(){
        int temp;
        temp = data.length - first + rear;
        temp = temp%data.length + 1;
        return  temp;
    }

    public boolean isEmpty(){ return getSize() == 0; }

    public void enqueue(Object e){
        if (getSize() < data.length()){
            rear = (rear + 1)%data.length;
            data[rear] = e;
        }
    }

    public Object dequeue(){
       if (isEmpty()) {
           return null;
       } else{
           Object temp = dat[first];
           data[first] = null;
           first = (first + 1)%data.length();
           return temp;
        }
    }
}