package com.example;
import java.util.Scanner;

public class Direccion {
    /* Atributos para guardar la direccion */
    private int calle;
    private String noCalle;
    private String nomenclatura;
    private String barrio;
    private String ciudad;

    /* Métodos de la clase */
    //Constructor
    public Direccion() {
        calle = 0;
        noCalle = "";
        nomenclatura = "";
        barrio = "";
        ciudad = "";
    }

    public Direccion(int c, String n, String nom, String b, String ciu) {
        calle = c;
        noCalle = n;
        nomenclatura = nom;
        barrio = b;
        ciudad = ciu;
    }

    //Métodos de acceso
    public int getCalle() {
        return calle;
    }

    public String getNumero() {
        return noCalle;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    //Métodos de lectura de datos por consola

    public void leerDireccion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la calle: ");
        calle = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el número de la calle: ");
        noCalle = sc.nextLine();
        
        System.out.println("Ingrese la nomenclatura: ");
        nomenclatura = sc.nextLine();

        System.out.println("Ingrese el barrio: ");
        barrio = sc.nextLine();

        System.out.println("Ingrese la ciudad: ");
        ciudad = sc.nextLine();

        sc.close();
    }

    //Método para guardar como String

    public String toString() {
        // Separamos los dos numeros de la calle con un 
        return calle + " " +  noCalle +  " " + nomenclatura + " " + barrio + " " + ciudad;
    }
}