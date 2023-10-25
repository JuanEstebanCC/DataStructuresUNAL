package Tree;

public class BinaryTree {
    //Atributos de la clase
    private BinaryNode root; //Raíz del árbol
    private int size; //Tamaño del árbol

    //Constructores
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    //Verificación de atributos
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isRoot(BinaryNode node) {
        return node == root;
    }

    //Verificación de hijos
    public boolean hasLeft(BinaryNode node) {
        return node.getLeft() != null;
    }

    public boolean hasRight(BinaryNode node) {
        return node.getRight() != null;
    }

    //Verifica si un nodo es interno
    public boolean isInternal(BinaryNode node) {
        return hasLeft(node) || hasRight(node);
    }


    //Getters de la clase
    public int getSize() {
        return size;
    }

    public BinaryNode getRoot() {
        return root;
    }	

    //Retorno de hijos de un nodo
    public BinaryNode left(BinaryNode node) {
        return node.getLeft();
    }

    public BinaryNode right(BinaryNode node) {
        return node.getRight();
    }

    
}