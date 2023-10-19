package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import Stack.Stack;

public class Mensajeria {
    private Usuario usuarioLogueado;
    private Stack mensajesEnviados;

    public Mensajeria(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        mensajesEnviados = new Stack();
    }

    // Metodo para agregar un mensaje a la cola de mensajes enviados
    public void agregarMensaje() {
        Mensaje mensaje = new Mensaje("","",LocalDateTime.now(),0,0);
        mensaje.crearMensaje();
        mensajesEnviados.push(mensaje);
    }

    //Metodo para guardar los mensajes en la bandeja de entrada del usuario receptor
    public void enviarMensajes() {
        while(!mensajesEnviados.isEmpty()) {
            Mensaje mensaje = (Mensaje) mensajesEnviados.pop();
            int idUsuarioReceptor = mensaje.getIdUsuarioReceptor();
            String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/" + Integer.toString(idUsuarioReceptor) + "BA.txt";

            try {
            //Veamos si existe bandeja de entrada en la carpeta del usuario
            File file = new File(filePath);
            
            FileWriter fw = new FileWriter(file, true);
            fw.write(mensaje.toString()+ "\n");
            fw.close();
            } catch (IOException e) {
            System.err.println("No se ha podido mandar el mensaje: " + e.getMessage());
            }
        }
    }
}
