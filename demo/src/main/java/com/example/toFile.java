package com.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;

public class toFile{
    public static void main(String[] args) {
        // Array de Ejemplo
        String[] infoArray = {
                "ID: 03",
                "Nombre: Gloria Yorladis",
                "Fecha de nacimiento: 17/02/2005",
                "Email: ogle75@gmail.com",
                "Telefono: 3232612175",
                "Direccion: 42 96-40 A Picacho Medellin"
        };

        // Path del archivo txt
        String filePath = "C:\\Users\\santi\\Desktop\\Estructura de Datos\\Práctica 1\\DataStructuresUNAL\\demo\\src\\main\\java\\com\\example\\usersTXT.txt";

        try {
            // crea un FileWriter para Escribir en el archivo
            boolean fileExists = Files.exists(Path.of(filePath));

            // Se crea un FileWriter para Escribir en el archivo
            FileWriter writer = new FileWriter(filePath, true);

            // Si el archivo existe y no esta vacio, añadir una buena linea antes de escribir
            if (fileExists && Files.size(Path.of(filePath)) > 0) {
                writer.write("\n");
            }

            // Iteramos en el array de la informacion y lo escribimos en el archivo
            for (String info : infoArray) {
                writer.write(info + "|");
            }

            // Cerramos el FileWriter
            writer.close();

            System.out.println("La información ha sido añadida al archivo.");
        } catch (IOException e) {
            System.err.println("Un error añadiendo la información al archivo: " + e.getMessage());
        }
    }
}