package Tree;

public class BSTEntry {
    // Atributos de un nodo de un arbol binario de busqueda
    private Object data;
    private int k;
    private BSTEntry left;
    private BSTEntry right;


    // Constructores

    public BSTEntry(Object e, int k) {
        this.data = e;
        this.k = k;
    }

    // Getters and setters
    public Object getData() {
        return data;
    }

    public int getKey() {
        return k;
    }
    public BSTEntry getLeft() {
        return left;
    }

    public BSTEntry getRight() {
        return right;
    }
        public void setData(Object data) {
        this.data = data;
    }

    public void setKey(int k) {
        this.k = k;
    }

    public void setLeft(BSTEntry left) {
        this.left = left;
    }

    public void setRight(BSTEntry right) {
        this.right = right;
    }

}