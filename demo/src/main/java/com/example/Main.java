package com.example;

public class Main {
    public static void main(String[] args) {

    // Probando carga de usuarios

    Registro registro = new Registro(10);

    registro.Import();

    for (int i = 0; i < registro.numRegistros(); i++) {
        System.out.println(registro.getRegistro()[i].toString());
    }

    }
}