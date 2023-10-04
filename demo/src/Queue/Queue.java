package Queue;

import SimpleList.List;

public class Queue {
    // Atributes
    private List data;

    // Constructor
    public Queue() {
        this.data = new List();
    }

    // Methods

    public int getSize(){
        return data.size();
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    public void enqueue(Object e){
        data.addLast(e);
    }

    public Object dequeue(){
        if (isEmpty()){
            return null;
        }else{
            return data.removeFirst();
        }
    }

    public Object first(){
        if (isEmpty()){
            return null;
        }else{
            return data.First().getData();
        }
    }
}
