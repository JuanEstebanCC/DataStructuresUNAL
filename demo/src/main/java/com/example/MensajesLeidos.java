package com.example;

import Queue.Queue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class MensajesLeidos {
    private Queue mensajesLeidos;
    private Usuario usuario;

    public MensajesLeidos(Usuario usuario){
        this.usuario = usuario;
        this.mensajesLeidos = new Queue();
        // Cargamos los mensajes dependiendo del id del usuario
        String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/" + Integer.toString(usuario.getId()) + "ML.txt";

        try {
            // Creamos el filereader
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // Leemos el archivo por linea y creamos el usuario
            String line;
            while((line = br.readLine()) != null) {
                String[] info = line.split("\\|");
                String asunto = info[0];
                String contenido = info[1];
                LocalDateTime fecha = LocalDateTime.parse(info[2]);
                String remitente = info[3];
                int destinatario = Integer.parseInt(info[4]);
                Mensaje m = new Mensaje(asunto, contenido, fecha, remitente, destinatario);

                // Almacenamos el mensaje en la Cola (Queue)
                this.mensajesLeidos.enqueue(m);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Un error leyendo el archivo: " + e.getMessage());
        }

    }

    public void guardarMensaje(Mensaje m){
        // Guardamos el mensaje en la cola
        mensajesLeidos.enqueue(m);
    }

    public void mostrarMensajesLeidos(){
        // Consultar mensajes leidos
    
        switch (mensajesLeidos.getSize()) {
            case 0:
                System.out.println("No hay mensajes leidos");
                break;
            default:
                System.out.println("Mensaje leido mas antiguo");
                System.out.println("-----------------------------------------------------------");
                Mensaje m = (Mensaje) mensajesLeidos.first();
                m.mostrarMensaje();
                break;
        }
    }

    public void toFile(){
        String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/" + Integer.toString(this.usuario.getId()) + "ML.txt";
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

                // En la cola de mensajes, iteramos y escribimos en el archivo
                while (!mensajesLeidos.isEmpty()) {
                    writer.write(mensajesLeidos.dequeue().toString() + "\r\n");
                }


                writer.close();
                System.out.println("La información ha sido añadida al archivo.");
            } catch (IOException e) {
                System.err.println("Un error añadiendo la información al archivo: " + e.getMessage());
            }

        }
    }
}
