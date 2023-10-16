package com.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegistroCredenciales {
    private Credenciales[] registro;
    private int numCredenciales;

    public RegistroCredenciales(int tam) {
        registro = new Credenciales[tam];
        numCredenciales = 0;
    }

    //Métodos de acceso
    public Credenciales[] getRegistro() {
        return registro;
    }
    public int numRegistros() {
        return numCredenciales;
    }

    public Boolean agregar(Credenciales u) {
        if (numCredenciales < registro.length) {
            registro[numCredenciales] = u;
            numCredenciales++;
            
            // Ordenar el arreglo por id
            for (int i = 0; i < numCredenciales; i++) {
                for (int j = 0; j < numCredenciales - 1; j++) {
                    if (registro[j].getid() > registro[j + 1].getid()) {
                        Credenciales temp = registro[j + 1];
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
    

    public Credenciales eliminar(long id) {
        int i = 0;
        //Buscando la posicion del usuario a eliminar
        while (i < numCredenciales && registro[i].getid() != id) {
            i++;
        }
        if (i == numCredenciales) {
            System.out.println("No se encontró el usuario");
            return null;
        } else {
            Credenciales eliminado = registro[i];
            //Eliminando el usuario y reorganizando el arreglo
            for (int j = i; j < numCredenciales - 1; j++) {
                registro[j] = registro[j + 1];
            }
            //Actualizando el numero de registros
            numCredenciales--;
            registro[numCredenciales - 1] = null;
            return eliminado;
        }


    }

    public int buscarPosicion(long id) {
        if (numCredenciales > 0) {
            int i = 0;
            while (i < numCredenciales && registro[i].getid() != id) {
                i++;
            }
            if (i == numCredenciales) {
                return -1;
            } else {
                return i;
            }
        } else {
            return -1;
        }
    }

    public Credenciales buscarUsuario(int id) {
        if (numCredenciales > 0) {
            int i = 0;
            while (i < numCredenciales && registro[i].getid() != id) {
                i++;
            }
            if (i == numCredenciales) {
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
        String filePath = "demo/src/main/java/com/example/Datos/InfoUsuarios/Password.txt";

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
            for (int i = 0; i < numCredenciales; i++) {
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
        String filePath = "demo/src/main/java/com/example/Datos/InfoUsuarios/Password.txt";

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
                int id = Integer.parseInt(info[0]);
                String contrasena = info[1];
                String tipo = info[2];
                
                // Guardamos las credenciales en el registro
                Credenciales u = new Credenciales(id, contrasena, tipo);

                agregar(u);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Un error leyendo el archivo: " + e.getMessage());
        }
        
    }

    public void integridadMensajes(){
        //Vamos a verificar que cada usuario tenga su bandeja de entrada, borradores y leidos
        String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/";
        for (int i = 0; i < numCredenciales; i++) {
            String filePathUsuario = filePath + Integer.toString(registro[i].getid());
            File bandejaEntrada = new File(filePathUsuario + "BA.txt");
            File borradores = new File(filePathUsuario + "B.txt");
            File leidos = new File(filePathUsuario + "ML.txt");
            try {
                if (!bandejaEntrada.exists()) {
                    bandejaEntrada.createNewFile();
                }
            } catch (IOException e) {
                System.err.println("El usuario no tiene bandeja de entrada" + e.getMessage());
            }

            try {
                if (!borradores.exists()) {
                    borradores.createNewFile();
                }
            } catch (IOException e) {
                System.err.println("El usuario no tiene borradores" + e.getMessage());
            }

            try {
                if (!leidos.exists()) {
                    leidos.createNewFile();
                }
            } catch (IOException e) {
                System.err.println("El usuario no tiene leidos" + e.getMessage());
            }
        }
    }
}

