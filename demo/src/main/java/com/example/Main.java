package com.example;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;

import DoubleList.DoubleList;

public class Main {
    public static void main(String[] args) {
        //Menu menu = new Menu();
        //menu.registroCredenciales.integridadMensajes();
        //menu.menuIngreso();
        DoubleList mensajes = new DoubleList();
        String filePath = "demo/src/main/java/com/example/Datos/MensajesUsuarios/2345902BA.txt";

        try {
            //Abrimos el archivo y creamos un BufferedReader para leerlo
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            java.io.BufferedReader br = new java.io.BufferedReader(fr);

            //Leemos las lineas y creamos los objetos Usuario
            String line;
            while((line = br.readLine()) != null){
                String[] info = line.split("\\|"); //Dividimos el string por espacios
                String asunto = info[0];
                String contenido = info[1];
                LocalDateTime fecha = LocalDateTime.parse(info[2]);
                String remitente = info[3];
                int destinatario = Integer.parseInt(info[4]);
                
                // Guardamos las credenciales en el registro
                Mensaje m = new Mensaje(asunto, contenido, fecha, remitente, destinatario);

                mensajes.addLast(m);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Un error leyendo la bandeja de entrada" + e.getMessage());
        }
        System.out.println(mensajes.First().getData().toString());
    }
}