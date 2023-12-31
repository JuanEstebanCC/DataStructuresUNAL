package com.example;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import DoubleList.DoubleList;
import DoubleList.DoubleNode;

public class BandejaEntrada {
    private DoubleList mensajes;
    private Usuario usuario; // Cargamos el usuario con el que queremos interactuar

    public BandejaEntrada(Usuario usuario) {
        this.usuario = usuario;
        this.mensajes = new DoubleList();
        
        // Cargamos los mensajes del usuario
        String filePath = "demo/src/main/java/com/example/Datos/Mensajes/" + Integer.toString(usuario.getId()) + "BA.txt";
        try {
            //Abrimos el archivo y creamos un BufferedReader para leerlo
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            java.io.BufferedReader br = new java.io.BufferedReader(fr);

            //Leemos las lineas y creamos los objetos Usuario
            String line;
            while((line = br.readLine()) != null){
                String[] info = line.split("\\ "); //Dividimos el string por espacios
                String asunto = info[0];
                String contenido = info[1];
                LocalDateTime fecha = LocalDateTime.parse(info[2]);
                int remitente = Integer.parseInt(info[3]);
                int destinatario = Integer.parseInt(info[4]);
                
                // Guardamos las credenciales en el registro
                Mensaje m = new Mensaje(asunto, contenido, fecha, remitente, destinatario);

                mensajes.addLast(m);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Un error leyendo el archivo: " + e.getMessage());
        }

    }

    // Metodo para mostrar los mensajes de la bandeja de entrada
    public void mostrarBandeja(){
        System.out.println("Mensajes de la bandeja de entrada:");
        DoubleNode current = mensajes.First();
        int i = 1;
        while (current != null) {
            System.out.println(Integer.toString(i) + "\n");
           ((Mensaje) current.getData()).resumenMensaje();
            current = current.getNext();
            i++;
        }
    }

    // Metodo leer un mensaje de la bandeja de entrada, por el titulo del mismo
    public void leerMensaje(String titulo){
        DoubleNode current = mensajes.First();
        while (current != null) {
            if (((Mensaje) current.getData()).getTitulo() == titulo) {
                ((Mensaje) current.getData()).mostrarMensaje();
                return;
            }
            current = current.getNext();
        }
    }

    // FALTAN LOS METODOS PARA PASAR UN MENSAJE DE LA BA A LEIDOS Y A BORRADORES
    // HAY QUE SOLUCIONAR COMO SE ENVIAN MENSAJES A OTROS USUARIOS

    public void toMsgLeido(){


    }

    public void toBorrador(){

    }

    // Metodo para guardar los mensajes de la bandeja de entrada en la base de datos
    public void toFile(){
        // Path del archivo txt
        String filePath = "demo/src/main/java/com/example/Datos/Mensajes/" + Integer.toString(usuario.getId()) + "BA.txt";

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

            // En la lista de mensajes, iteramos y escribimos en el archivo
            DoubleNode current = mensajes.First();
            while (current != null) {
                writer.write(current.getData().toString() + "\n");
                current = current.getNext();
            }

            // Cerramos el FileWriter
            writer.close();

            System.out.println("La información ha sido añadida al archivo.");
        } catch (IOException e) {
            System.err.println("Un error añadiendo la información al archivo: " + e.getMessage());
        }
    }

}
