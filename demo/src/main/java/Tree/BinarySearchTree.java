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

    public Object Remove(int k) {
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
    }

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

}
