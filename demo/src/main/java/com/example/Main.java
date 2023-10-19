package com.example;

import java.time.LocalDateTime;

import Stack.Stack;

public class Main {
    public static void main(String[] args) {
        //Menu menu = new Menu();
        //menu.registroCredenciales.integridadMensajes();
        //menu.menuIngreso();

        //Mensaje m = new Mensaje("","",LocalDateTime.now(),0,0);
        //m.crearMensaje();
        //System.out.println(m.toString());

        Stack pila = new Stack();

        pila.push("Hola");
        pila.push("Mundo");
        pila.push("Cruel");
        pila.push("!");

        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        System.out.println(pila.pop());



    }
}