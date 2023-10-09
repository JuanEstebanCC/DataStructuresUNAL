package com.example;

public class Main {
    public static void main(String[] args) {

        //Testing the Usuario class

        //Creating a new user
        Usuario user1 = new Usuario();

        //Setting the user's attributes
        user1.leerUsuario();

        //Printing the user's attributes
        System.out.println(user1.toString());
    }
}