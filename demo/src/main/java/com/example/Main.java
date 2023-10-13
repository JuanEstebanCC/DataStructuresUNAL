package com.example;

public class Main {
    public static void main(String[] args) {

    // Cargamos los usuarios en el registro para operarlos
    Registro registro = new Registro(10);
    registro.Import();

    // Hacemos el menu de ingreso
    registro.toFile();

    }
}