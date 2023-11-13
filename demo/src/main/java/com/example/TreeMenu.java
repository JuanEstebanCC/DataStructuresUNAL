package com.example;

import Tree.BinaryNode;
import Tree.BinarySearchTree;

import java.util.Scanner;

public class TreeMenu {
  public TreeMenu(){
      Scanner sc = new Scanner(System.in);
      int opcion = 0;
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
                  insertar();
                  break;
              case 2:
                  eliminar();
                  break;
              case 3:
                  buscar();
                  break;
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

  public void insertar(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Inserte el objeto: ");
      String obj = sc.nextLine();
      System.out.println("Inserte la key: ");
      int key = sc.nextInt();
      BinarySearchTree.insert(obj,key);
  }

  public void eliminar(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Inserte la key del nodo que desea eliminar: ");
      String key = sc.nextLine();
      BinarySearchTree.Remove(key);
  }


  public void buscar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte la key del nodo que desea buscar: ");
        String key = sc.nextLine();
        BinarySearchTree.find(key);
  }

  public void maxAndMin(){
        System.out.println("El objeto con key más grande es:");
        BinarySearchTree.maxNode();
        System.out.println("El objeto con key más pequeña es:");
        BinarySearchTree.minNode();
  }
  public void mostarArbol(){

  }
  public void recorridoInoder(){
      System.out.println("Resultado del inorder");
      BinarySearchTree.inOrder();
  }
}
