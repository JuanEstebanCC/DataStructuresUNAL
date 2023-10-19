package com.example;

import Stack.Stack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Borradores {
    private Stack borrador;
    private Usuario usuario; // Cargamos el usuario


    public Borradores(Usuario usuario) {
        this.borrador = new Stack();
        this.usuario = usuario;
        // Cargamos los mensajes dependiendo del id del usuario
        String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/" + Integer.toString(usuario.getId()) + "B.txt";

        try {
            // Creamos el filereader
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // Leemos el archivo por linea y creamos el usuario
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                String asunto = info[0];
                String contenido = info[1];
                LocalDateTime fecha = LocalDateTime.parse(info[2]);
                String remitente = info[3];
                int destinatario = Integer.parseInt(info[4]);
                Mensaje m = new Mensaje(asunto, contenido, fecha, remitente, destinatario);

                // Almacenamos el mensaje en la Pila (Stack)
                this.borrador.push(m);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Un error leyendo el archivo: " + e.getMessage());
        }
    }

    public void guardarBorrador(Mensaje m) {
        // Guardamos el mensaje en la pila
        borrador.push(m);
    }

    public Mensaje mostrarBorrador() {
        // Ver borrador
        return (Mensaje) borrador.pop();
    }

    public void toFile(){
        String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/" + Integer.toString(this.usuario.getId()) + "B.txt";
        Stack inverso = new Stack(); //Stack para invertir el orden de los mensajes y guardarlos en orden del mas reciente
        while (!borrador.isEmpty()) {
            inverso.push(borrador.pop());
        }
        boolean fileDeleted = (new File(filePath)).delete();
        if (!fileDeleted) {
            System.err.println("Error deleting the file");
        } else {
            try {
                boolean fileExists = Files.exists(Path.of(filePath), new LinkOption[0]);
                FileWriter writer = new FileWriter(filePath, true);
                if (fileExists && Files.size(Path.of(filePath)) > 0) {
                    writer.write("\r\n");
                }

                // En la pila de mensajes, iteramos y escribimos en el archivo
                while (!inverso.isEmpty()) {
                    writer.write(inverso.pop().toString() + "\r\n");
                }

                writer.close();
            } catch (IOException e) {
                System.err.println("Un error añadiendo la información al archivo: " + e.getMessage());
            }

        }
    }
}

