package com.example;

public class Main {
    public static void main(String[] args) {

        // Creando un objeto de tipo Registro
        Registro registro = new Registro(20);

        // Importamos del archivo usersTXT.txt

        registro.Import();

        // Imprimamos los usuarios cargados
        for (int i = 0; i < registro.numRegistros(); i++) {
            System.out.println(registro.getRegistro()[i].toString());
        }
    }
}