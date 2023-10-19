package com.example;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Mensaje {
    private String contenido;
    private String titulo;
    private LocalDateTime fecha;
    private String usuarioEmisor;
    private int idUsuarioReceptor;

    public Mensaje(String contenido, String titulo, LocalDateTime fecha, String usuarioEmisor, int idUsuarioReceptor) {
        this.contenido = contenido;
        this.titulo = titulo;
        this.fecha = fecha;
        this.usuarioEmisor = usuarioEmisor;
        this.idUsuarioReceptor = idUsuarioReceptor;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    public void setEmisario(String Emisario) {
        this.usuarioEmisor = Emisario;
    }

    public void setIdUsuarioReceptor(int idUsuarioReceptor) {
        this.idUsuarioReceptor = idUsuarioReceptor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public int getIdUsuarioReceptor() {
        return idUsuarioReceptor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Mensaje crearMensaje(String emisor) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el contenido del mensaje");
        contenido = sc.nextLine();
        fecha = LocalDateTime.now();
        System.out.println("Ingrese el titulo del mensaje");
        titulo = sc.nextLine();
        System.out.println("Ingrese el id del usuario receptor");
        idUsuarioReceptor = sc.nextInt();
        
        Mensaje m = new Mensaje(contenido, titulo, LocalDateTime.now(), emisor, idUsuarioReceptor);
        return m;
 
    }

    public void resumenMensaje() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Titulo: " + titulo);
        System.out.println("Emisor: " + usuarioEmisor);
    }

    public void mostrarMensaje() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Contenido: " + contenido);
        System.out.println("Fecha: " + fecha);
        System.out.println("Emisario: " + usuarioEmisor);
    }

    public void enviarMensaje() {
        //Accedemos a la ruta de la bandeja de entrada del receptor
        String path = "demo/src/main/java/com/example/Datos/MensajesUsuarios/" + Integer.toString(idUsuarioReceptor) + "BA.txt";

        //Abrimos el archivo
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, true);
            fw.write(this.toString() + "\r\n");
            fw.close();
        } catch (Exception e) {
            System.err.println("Un error enviando el mensaje" + e.getMessage());
        }
    }

    public String toString() {
        return contenido + "|" + titulo + "|" + fecha.toString() + "|" + usuarioEmisor + "|" + Integer.toString(idUsuarioReceptor);
    }

}
