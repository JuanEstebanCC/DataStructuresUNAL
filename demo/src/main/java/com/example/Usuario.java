package com.example;

public class Usuario {
    /* Atributos para guardar los datos del usuario */
    private long id;
    private String nombre;
    private Fecha fecha_nacimiento;
    private String email;
    private long telefono;
    private Direccion direccion;

    /* Métodos de la clase */
    //Constructor
    public Usuario(long id, String n, Fecha f, String e, long t, Direccion d) {
        this.id = id;
        this.nombre = n;
        this.fecha_nacimiento = f;
        this.email = e;
        this.telefono = t;
        this.direccion = d;
    }

    //Métodos de acceso
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNacimiento() {
        return fecha_nacimiento;
    }
    
    public String getEmail() {
        return email;
    }

    public long getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    //Métodos de modificación
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setFechaNacimiento(Fecha f) {
        this.fecha_nacimiento = f;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setTelefono(long t) {
        this.telefono = t;
    }

    public void setDireccion(Direccion d) {
        this.direccion = d;
    }

    //Método para toString

    public String toString() {

        return "ID: " + id + "|Nombre: " + nombre + "|Fecha de nacimiento: " + fecha_nacimiento + "|Email: " + email + "|Telefono: " + telefono + "|Direccion: " + direccion;
    }
    
}