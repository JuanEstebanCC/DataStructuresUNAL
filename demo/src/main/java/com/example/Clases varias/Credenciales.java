package com.example;
import java.util.Scanner;

public class Credenciales {
    private int id;
    private String contrasena;
    private String tipo;

    public Credenciales(int id, String contrasena, String tipo) {
        this.id = id;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    // Getters
    public int getid() {
        return id;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setUsuario(int id) {
        this.id = id;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Métodos de lectura de datos por consola
    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del usuario");
        id = sc.nextInt();
        setUsuario(id);
        sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario");
        contrasena = sc.nextLine();
        setContrasena(contrasena);
        System.out.println("Ingrese el tipo de usuario");
        tipo = sc.nextLine();
        setTipo(tipo);
        sc.close();
    }
}
