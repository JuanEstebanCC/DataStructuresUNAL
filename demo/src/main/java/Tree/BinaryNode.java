package Tree;


public class BinaryNode {
    //Implementación de un nodo para árbol binario
    private Object data;
    private BinaryNode left;
    private BinaryNode right;

    //Constructors
    public BinaryNode() {
        this.data = null;

    }

    public BinaryNode(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Getters de la clase
    public Object getData() {
        return data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    //Setters de la clase
    public void setData(Object data) {
        this.data = data;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
