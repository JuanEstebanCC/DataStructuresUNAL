package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;

public class Registro {
    private Usuario[] registro;
    private int numRegistros;


    //Constructor, inicializamos numRegistros a 0, puesto que aún no hay registros
    public Registro(int n) {
        registro = new Usuario[n];
        numRegistros = 1;
    }

    public Boolean agregar(Usuario u) {
        //Verificando que el usuario no exista
        for (int i = 0; i < numRegistros; i++) {
            if (registro[i].getId() == u.getId()) {
                System.out.println("El usuario ya existe");
                return false;
            }
        }

        if (numRegistros < registro.length) {
            //@TODO Agregar el usuario al registro y organizarlo por id
            //Aca solo se esta agregando el usuario al final del arreglo, deberia organizarse
            registro[numRegistros] = u;
            numRegistros++;
            return true;
        } else {
            System.out.println("No se pueden agregar más registros");
            return false;
        }
    }

    public Usuario eliminar(long id) {
        int i = 0;
        //Buscando la posicion del usuario a eliminar
        while (i < numRegistros && registro[i].getId() != id) {
            i++;
        }
        if (i == numRegistros) {
            System.out.println("No se encontró el usuario");
            return null;
        } else {
            Usuario eliminado = registro[i];
            //Eliminando el usuario y reorganizando el arreglo
            for (int j = i; j < numRegistros - 1; j++) {
                registro[j] = registro[j + 1];
            }
            //Actualizando el numero de registros
            numRegistros--;
            registro[numRegistros - 1] = null;
            return eliminado;
        }

    }


    public int buscarPosicion(long id) {
        if (numRegistros > 0) {
            int i = 0;
            while (i < numRegistros && registro[i].getId() != id) {
                i++;
            }
            if (i == numRegistros) {
                return -1;
            } else {
                return i;
            }
        } else {
            return -1;
        }
    }

    public Usuario buscarUsuario(long id) {
        if (numRegistros > 0) {
            int i = 0;
            while (i < numRegistros && registro[i].getId() != id) {
                i++;
            }
            if (i == numRegistros) {
                return null;
            } else {
                return registro[i];
            }
        } else {
            return null;
        }
    }

    // Metodo para mandar un array con los datos y escribirlo en el archivo txt
    public void toFile (String filePath) {

        String[] infoArray = {
                "ID: 03",
                "Nombre: Gloria Yorladis",
                "Fecha de nacimiento: 17/02/2005",
                "Email: ogle75@gmail.com",
                "Telefono: 3232612175",
                "Direccion: 42 96-40 A Picacho Medellin"
        };

        // Path del archivo txt
        filePath = "C:\\Users\\santi\\Desktop\\Estructura de Datos\\Práctica 1\\DataStructuresUNAL\\demo\\src\\main\\java\\com\\example\\usersTXT.txt";

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

    // Metodo para leer los usuarios en el archivo txt
    public void Importn (String fileName){
          Import importado = new Import(fileName);
    }

}
