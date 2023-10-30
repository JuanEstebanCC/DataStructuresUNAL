package Tree;
import Queue.Queue;

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

    //Retorno del padre de un nodo
    public BinaryNode parent(BinaryNode node) {
        if (isRoot(node)) {
            return null;
        } else {
            Queue queue = new Queue();
            queue.enqueue(root);
            BinaryNode temp = root;

            while (!queue.isEmpty() && left((BinaryNode) queue.first())!= node && right((BinaryNode) queue.first()) != node) {
                temp = (BinaryNode) queue.dequeue();
                if (hasLeft(temp)) {
                    queue.enqueue(left(temp));
                }
                if (hasRight(temp)) {
                    queue.enqueue(right(temp));
                }
            return temp;
            }

        }
        return node;	
    }

    //Retorno de la profundidad de un nodo
    public int depth(BinaryNode node) {
        if (isRoot(node)) {
            return 0;
        } else {
            return 1 + depth(parent(node));
        }
    }

    //Retorno de la altura de un nodo
    public int height(BinaryNode node) {
        if (!isInternal(node)) {
            return 0;
        } else {
            int h = 0;
            if (hasLeft(node)) {
                h = Math.max(h, height(left(node)));
            }
            if (hasRight(node)) {
                h = Math.max(h, height(right(node)));
            }
            return 1 + h;
        }
    }

    //Agregar una raíz
    public void addRoot(Object element) {
        root = new BinaryNode(element);
        size = 1;
    }

    //Agregar hijos
    public void addLeft(BinaryNode node, Object element) {
        BinaryNode newNode = new BinaryNode(element);
        node.setLeft(newNode);
        size++;
    }

    public void addRight(BinaryNode node, Object element) {
        BinaryNode newNode = new BinaryNode(element);
        node.setRight(newNode);
        size++;
    }
    
}
