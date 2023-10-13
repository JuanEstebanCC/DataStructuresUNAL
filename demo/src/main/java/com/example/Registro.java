package com.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Registro {
    private Usuario[] registro;
    private int numRegistros;

    //Constructor, inicializamos numRegistros a 0, puesto que aún no hay registros
    public Registro(int n) {
        registro = new Usuario[n];
        numRegistros = 0;
    }

    //Métodos de acceso
    public Usuario[] getRegistro() {
        return registro;
    }
    public int numRegistros() {
        return numRegistros;
    }

    public Boolean agregar(Usuario u) {
        if (numRegistros < registro.length) {
            //@TODO Agregar el usuario al registro y organizarlo por id
            //Aca solo se esta agregando el usuario al final del arreglo, deberia organizarse
            registro[numRegistros] = u;
            numRegistros++;
            
            // Ordenar el arreglo por id
            for (int i = 0; i < numRegistros; i++) {
                for (int j = 0; j < numRegistros - 1; j++) {
                    if (registro[j].getId() > registro[j + 1].getId()) {
                        Usuario temp = registro[j + 1];
                        registro[j + 1] = registro[j];
                        registro[j] = temp;
                    }
                }
            }
            return true;
        } else {
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

    public void toFile(){
        // Path del archivo txt
        String filePath = "demo/src/main/java/com/example/Datos/InfoUsuarios/Empleados.txt";

        // Delete the existing file
        boolean fileDeleted = new File(filePath).delete();
        if (!fileDeleted) {
            System.err.println("Error deleting the file");
            return;
        }

        try {
            // crea un FileWriter para Escribir en el archivo
            boolean fileExists = Files.exists(Path.of(filePath));

            // Se crea un FileWriter para Escribir en el archivo
            FileWriter writer = new FileWriter(filePath, true);

            // Si el archivo existe y no esta vacio, añadir una nueva linea antes de escribir
            if (fileExists && Files.size(Path.of(filePath)) > 0) {
                writer.write("\n");
            }

            // Iteramos en el array de la informacion y lo escribimos en el archivo
            for (int i = 0; i < numRegistros; i++) {
                writer.write(registro[i].toString() + "\n");
            }

            // Cerramos el FileWriter
            writer.close();

            System.out.println("La información ha sido añadida al archivo.");
        } catch (IOException e) {
            System.err.println("Un error añadiendo la información al archivo: " + e.getMessage());
        }
    }

    public void Import(){
        // Path del archivo txt
        String filePath = "demo/src/main/java/com/example/Datos/InfoUsuarios/Empleados.txt";

        // Leemos el archivos y vamos agregando los usuarios al registro
        try {
            //Abrimos el archivo y creamos un BufferedReader para leerlo
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            java.io.BufferedReader br = new java.io.BufferedReader(fr);

            //Leemos las lineas y creamos los objetos Usuario
            String line;
            while((line = br.readLine()) != null){
                String[] info = line.split("\\ "); //Dividi
                String nombre = info[0];
                int id = Integer.parseInt(info[1]);

                int dia = Integer.parseInt(info[2]);
                int mes = Integer.parseInt(info[3]);
                int anio = Integer.parseInt(info[4]);
                Fecha fecha_nacimiento = new Fecha(dia, mes, anio); //Se crea un objeto Fecha con los datos leidos

                String ciudadNacimiento = info[5];
                long telefono = Long.parseLong(info[6]);
                String email = info[7];

                String calle = info[8];
                String noCalle = info[9];
                String barrio = info[10];
                String ciudad = info[11];
                String conjunto = info[12];
                String noConjunto = info[13];
                
                //Se guarda la direccion en un objeto Direccion
                Direccion dir = new Direccion(calle, noCalle, barrio, ciudad, conjunto, noConjunto);
                
                Usuario u = new Usuario(id, nombre, fecha_nacimiento, ciudadNacimiento, email, telefono, dir);

                agregar(u);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Un error leyendo el archivo: " + e.getMessage());
        }
        
    }
}
