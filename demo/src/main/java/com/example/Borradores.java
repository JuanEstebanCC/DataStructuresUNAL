package com.example;

import Queue.Queue;
import Stack.Stack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Borradores {
    private Stack borrador;
    private Usuario usuario;


    public Borradores(Usuario usuario) {
        this.borrador = new Stack();
        this.usuario = usuario;
        String filePath = "demo/src/main/java/com/example/Datos/Mensajes/" + Integer.toString(usuario.getId()) + "B.txt";

        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\\ ");
                String asunto = info[0];
                String contenido = info[1];
                LocalDateTime fecha = LocalDateTime.parse(info[2]);
                int remitente = Integer.parseInt(info[3]);
                int destinatario = Integer.parseInt(info[4]);
                Mensaje m = new Mensaje(asunto, contenido, fecha, remitente, destinatario);
                this.borrador.push(m);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Un error leyendo el archivo: " + e.getMessage());
        }
    }

    public void mostrarBorradores(int e) {
        // Ver borrador

        System.out.println(borrador.top());
        if (e == 1) {
            // Se descarta el borrador
            borrador.pop();
        } else {
            // Se envia el mensaje

        }
    }

    public void toFile(){
        String filePath = "demo/src/main/java/com/example/Datos/Mensajes/" + Integer.toString(this.usuario.getId()) + "B.txt";
        boolean fileDeleted = (new File(filePath)).delete();
        if (!fileDeleted) {
            System.err.println("Error deleting the file");
        } else {
            try {
                boolean fileExists = Files.exists(Path.of(filePath), new LinkOption[0]);
                FileWriter writer = new FileWriter(filePath, true);
                if (fileExists && Files.size(Path.of(filePath)) > 0) {
                    writer.write("\n");
                }

                // En la lista de mensajes, iteramos y escribimos en el archivo
                while (!borrador.isEmpty()) {
                    writer.write(borrador.pop().toString() + "\n");
                }


                writer.close();
                System.out.println("La información ha sido añadida al archivo.");
            } catch (IOException e) {
                System.err.println("Un error añadiendo la información al archivo: " + e.getMessage());
            }

        }
    }
}

