package com.example;
import Tree.*;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println(tree.isEmpty());
        System.out.println(tree.getSize());

        //Agreguemos valores a la raiz

        tree.addRoot(1);

        System.out.println(tree.isEmpty());

        //Agreguemos valores a la izquierda
        tree.addLeft(tree.getRoot(), 2);
        tree.addRight(tree.getRoot(), 3);
        tree.addLeft(tree.left(tree.getRoot()), 4);
        tree.addRight(tree.left(tree.getRoot()), 5);
        System.out.println(tree.parent(tree.left(tree.getRoot())).getData());

        //Recorrido preOrder
        tree.preOrder(tree.getRoot());

        System.out.println();
        //Recorrido inOrder
        tree.inOrder(tree.getRoot());

        System.out.println();
        //Recorrido postOrder
        tree.postOrder(tree.getRoot());
    }
}