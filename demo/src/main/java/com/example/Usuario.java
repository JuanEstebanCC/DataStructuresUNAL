package com.example;
import java.util.Scanner;

public class Usuario {
    /* Atributos para guardar los datos del usuario */
    private int id;
    private String nombre;
    private Fecha fecha_nacimiento;
    private String ciudad_nacimiento;
    private String email;
    private long telefono;
    private Direccion direccion;

    /* Métodos de la clase */
    //Constructor
    public Usuario() {
        id = 0;
        nombre = "";
        fecha_nacimiento = new Fecha();
        ciudad_nacimiento = "";
        email = "";
        telefono = 0;
        direccion = new Direccion();
    }

    public Usuario(int id, String n, Fecha f, String lugar_nacimiento, String e, long t, Direccion d) {
        this.id = id;
        this.nombre = n;
        this.fecha_nacimiento = f;
        this.ciudad_nacimiento = lugar_nacimiento;
        this.email = e;
        this.telefono = t;
        this.direccion = d;
    }

    //Métodos de acceso
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public String getCiudadNacimiento() {
        return ciudad_nacimiento;
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
    public void setId(int id) {
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
    //Método para ingresar datos por consola

    public void leerUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre: ");
        nombre = sc.nextLine(); 

        System.out.println("Ingrese la fecha de nacimiento -----------------");
        System.out.println("Ingrese el día: ");
        int dia = sc.nextInt();

        System.out.println("Ingrese el mes: ");
        int mes = sc.nextInt();

        System.out.println("Ingrese el año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        fecha_nacimiento = new Fecha(dia, mes, anio);

        System.out.println("Ingrese la ciudad de nacimiento: ");
        ciudad_nacimiento = sc.nextLine();

        System.out.println("Ingrese el email: ");
        email = sc.nextLine();

        System.out.println("Ingrese el telefono: ");
        telefono = sc.nextLong();
        sc.nextLine();

        System.out.println("Ingrese la direccion ----------------- ");
        direccion.leerDireccion();

        sc.close();
    }

    //Método para toString

    public String toString() {
        return nombre + " " + Integer.toString(id) + " " + fecha_nacimiento.toString() + " " + ciudad_nacimiento + " " + telefono + " " + direccion.toString();
    }
    
}