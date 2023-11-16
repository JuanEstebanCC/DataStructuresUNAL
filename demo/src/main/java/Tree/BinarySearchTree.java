package Tree;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
       super();
    }

    // Metodos
    public BinaryNode find(int k) {
        return searchTree(k, root);
    }

    public BinaryNode searchTree(int k, BinaryNode v) {
        if (v == null) {
            return null;
        }
        BSTEntry u = (BSTEntry) v.getData();
        if (k == u.getKey()) { //Caso base
            return v;
        } else if (k < u.getKey()) {
            return searchTree(k, v.getLeft());
        } else {
            return searchTree(k, v.getRight());
        }
    }


    //
    public void insert(Object e, int k) {
        BSTEntry O = new BSTEntry(e, k);
        if (isEmpty()) {
            super.addRoot(O);
        } else {
            addEntry(root, O);
        }
    }

    public void addEntry(BinaryNode v, BSTEntry o) {
        BSTEntry temp = (BSTEntry) v.getData();
        BinaryNode nD = new BinaryNode(o);
        if (o.getKey() < temp.getKey()) {
            if (hasLeft(v)) {
                addEntry(v.getLeft(), o);
            } else {
                v.setLeft(nD);
            }
        } else {
            if (hasRight(v)) {
                addEntry(v.getRight(), o);
            } else {
                v.setRight(nD);
            }
        }
    }

    public BSTEntry deleteNode(int k) {
        return deleteRecursive((BSTEntry) root.getData(), k);
    }

    public BSTEntry deleteRecursive(BSTEntry v, int k) {
        if (v == null) {
            return null;
        }
        BSTEntry temp = v;
        //Realizamos la busqueda del nodo a eliminar
        if (k < temp.getKey()) {
            v.setLeft(deleteRecursive(v.getLeft(), k));
        } else if (k > temp.getKey()) {
            v.setRight(deleteRecursive(v.getRight(), k));
        } else {
            if (v.getLeft() == null) {
                return (BSTEntry) v.getRight().getData();
            } else if (v.getRight() == null) {
                return (BSTEntry) v.getLeft().getData();
            }
            v.setData(minValue(v.getRight()));
            v.setRight(deleteRecursive(v.getRight(), temp.getKey()));
        }
        return temp;
    }

    private int minValue(BSTEntry root) {
        int minValue = root.getLeft().getKey();
        while (root.getLeft() != null) {
            minValue = root.getLeft().getKey();
            root = root.getLeft();
        }
        return minValue;
    }

    /*public Object Remove(int k) {
        BinaryNode v = find(k);
        Object temp = v.getData();
        if (hasLeft(v) && hasRight(v)) { //caso 2
            BinaryNode w = predecessor(v);
            v.setData(w.getData());
            super.remove(w);
        } else { //caso 1
            super.remove(v);
        }
        return temp;
    }*/

    public BinaryNode predecessor(BinaryNode v) {
        BinaryNode temp = v.getLeft();
        return maxNode(temp);
    }

    public BinaryNode maxNode(BinaryNode temp) {
        if (hasRight(temp)) {
            return maxNode(temp.getRight());
        } else {
            return temp;
        }
    }

    public BinaryNode successor(BinaryNode v) {
        BinaryNode temp = v.getRight();
        return minNode(temp);
    }

    public BinaryNode minNode(BinaryNode temp) {
        if (hasLeft(temp)) {
            return minNode(temp.getLeft());
        } else {
            return temp;
        }
    }

    public Object getMinKeyObject() {
        if (isEmpty()) {
            return null; // Return null if the tree is empty
        }

        BinaryNode minNode = minNode(root);
        BSTEntry minEntry = (BSTEntry) minNode.getData();
        return minEntry.getData();
    }


    public Object getMaxKeyObject() {
        if (isEmpty()) {
            return null; // Return null if the tree is empty
        }

        BinaryNode maxNode = maxNode(root);
        BSTEntry maxEntry = (BSTEntry) maxNode.getData();
        return maxEntry.getData();
    }

    public void inOrder(BSTEntry node) {
        if (node != null) {
            inOrder(node.getLeft());
            BSTEntry temp = (BSTEntry) node.getData();
            System.out.print(Integer.toString(temp.getKey()) + " ");
            inOrder(node.getRight());
        }
    }
    public void inOrderShow(BinaryNode node, int level) {
        if (node != null) {
            inOrderShow(node.getRight(), level + 1);
            printTree(node, level);
            inOrderShow(node.getLeft(), level + 1);
        }
    }

    public void printTree(BinaryNode node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.getData());

    }
    
}
