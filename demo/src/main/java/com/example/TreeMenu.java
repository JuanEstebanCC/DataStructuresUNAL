package com.example;

import Tree.BinarySearchTree;

import java.util.Scanner;

public class TreeMenu {
  public void TreeMenu(){
      Scanner sc = new Scanner(System.in);
      int opcion = 0;
      BinarySearchTree bst = new BinarySearchTree();
      do {
          System.out.println("----------------------");
          System.out.println("Bienvenido al sistema:");
          System.out.println("1. Insertar");
          System.out.println("2. Eliminar");
          System.out.println("3. Buscar");
          System.out.println("4. Valor máximo y mínimo");
          System.out.println("5. Mostrar Arbol");
          System.out.println("6. Recorrido Inorder");
          System.out.println("7. Salir");
          System.out.println("----------------------");
          System.out.print("Ingrese el número de opción: ");
          opcion = sc.nextInt();
          sc.nextLine();
          switch (opcion) {
              case 1:
                  System.out.println("Inserte el objeto: ");
                  String obj = sc.nextLine();
                  System.out.println("Inserte la key: ");
                  int key = sc.nextInt();
                  bst.insert(obj,key);
                  break;
              case 2:
                  System.out.println("Inserte la key del nodo que desea eliminar: ");
                  key = sc.nextInt();
                  bst.Remove(key);
                  break;
              case 3:
                  System.out.println("Inserte la key del nodo que desea buscar: ");
                  key = sc.nextInt();
                  bst.find(key);
                  break;
              case 4:
                  System.out.println("El objeto con key más grande es:");
                  bst.getMaxKeyObject();
                  System.out.println("El objeto con key más pequeña es:");
                  bst.getMinKeyObject();
                  break;
              case 5:
                  System.out.println(" show arbol");
              case 6:
                  System.out.println("Resultado del inorder");
                  if (bst.isEmpty()) {
                      System.out.println("Tree is empty.");
                  } else {
                      System.out.print("Inorder Traversal Keys: ");
                      bst.inOrder(bst.root);
                      System.out.println();
                  }
              case 7:
                  System.out.println("Gracias por usar el sistema!");
                  break;
              default:
                  System.out.println("Opción no válida!");
                  break;
          }
      } while (opcion != 7);
      sc.close();
  }



}
