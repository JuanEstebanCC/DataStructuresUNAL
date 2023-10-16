package com.example;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Mensaje {
    private String contenido;
    private String titulo;
    private LocalDateTime fecha;
    private int idUsuarioEmisor;
    private int idUsuarioReceptor;

    public Mensaje(String contenido, String titulo, LocalDateTime fecha, int idUsuarioEmisor, int idUsuarioReceptor) {
        this.contenido = contenido;
        this.titulo = titulo;
        this.fecha = fecha;
        this.idUsuarioEmisor = idUsuarioEmisor;
        this.idUsuarioReceptor = idUsuarioReceptor;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    public void setEmisario(int Emisario) {
        this.idUsuarioEmisor = Emisario;
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

    public int getIdUsuarioEmisor() {
        return idUsuarioEmisor;
    }

    public int getIdUsuarioReceptor() {
        return idUsuarioReceptor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Mensaje crearMensaje() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el contenido del mensaje");
        contenido = sc.nextLine();
        fecha = LocalDateTime.now();
        System.out.println("Ingrese el titulo del mensaje");
        titulo = sc.nextLine();
        System.out.println("Ingrese el id del usuario emisor");
        idUsuarioEmisor = sc.nextInt();
        System.out.println("Ingrese el id del usuario receptor");
        idUsuarioReceptor = sc.nextInt();
        
        Mensaje m = new Mensaje(contenido, titulo, LocalDateTime.now(), idUsuarioEmisor, idUsuarioReceptor);
        return m;
 
    }

    public void resumenMensaje() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Titulo: " + titulo);
        System.out.println("Emisor: " + idUsuarioEmisor);
    }

    public void mostrarMensaje() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Contenido: " + contenido);
        System.out.println("Fecha: " + fecha);
        System.out.println("Emisario: " + idUsuarioEmisor);
    }

    public String toString() {
        return contenido + " " + titulo + " " + fecha.toString() + " " + Integer.toString(idUsuarioEmisor) + " " + Integer.toString(idUsuarioReceptor);
    }

}
