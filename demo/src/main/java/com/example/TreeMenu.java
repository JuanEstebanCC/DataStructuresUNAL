package com.example;

import Tree.BinaryNode;
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
          System.out.println("1. Insertar Usuario");
          System.out.println("2. Eliminar Usuario");
          System.out.println("3. Buscar Usuario");
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
                  //Se guardan los atributos del usuario
                  System.out.println("Inserte el nombre del usuario: ");
                  String nombre = sc.nextLine();
                  System.out.println("----------------------");
                  System.out.println("Inserte la ID del usuario: ");
                  int id = sc.nextInt();
                  System.out.println("----------------------");
                  
                  User user = new User(nombre, id);
                  
                  bst.insert(user, user.SumaDigitos());
                  break;
              case 2:
                  System.out.println("Inserte la key del usuario que desea eliminar: ");
                  int key = sc.nextInt();
                  Object removedObject = bst.deleteNode(key);
                  if (removedObject != null) {
                      System.out.println("Objeto eliminado: " + removedObject);
                  } else {
                      System.out.println("No se encontró el nodo con la key especificada.");
                  }
                  break;
              case 3:
                  System.out.println("Inserte la key del usuario que desea buscar: ");
                  key = sc.nextInt();
                  BinaryNode foundNode = bst.find(key);
                  if (foundNode != null) {
                      System.out.println("Usuario encontrado: ");
                      System.out.println(foundNode.getData().toString());
                  } else {
                      System.out.println("El usuario no se encuentra en el árbol.");
                  }
                  break;
              case 4:
                  System.out.println("El usuario con key más grande es: " + bst.getMaxKeyObject());
                  System.out.println("El usuario con key más pequeña es: " + bst.getMinKeyObject());
                  break;
              case 5:
                  System.out.println("Mostrar árbol");
                  break;
              case 6:
                  System.out.println("Resultado del inorder");
                  if (bst.isEmpty()) {
                      System.out.println("No hay usuarios en el arbol");
                  } else {
                      System.out.println("Claves InOrder: ");
                      bst.inOrder(bst.getRoot());  // Pass bst.root as an argument
                      System.out.println();
                  }
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



}
