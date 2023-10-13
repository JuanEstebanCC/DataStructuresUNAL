package com.example;
import java.util.Scanner;

public class Direccion {
    /* Atributos para guardar la direccion */
    private String calle;
    private String noCalle;
    private String barrio;
    private String ciudad;
    private String conjunto;
    private String noConjunto;

    /* Métodos de la clase */
    //Constructor
    public Direccion() {
        calle = "";
        noCalle = "";
        barrio = "";
        ciudad = "";
        conjunto = "";
        noConjunto = "";
    }

    public Direccion(String c, String n, String b, String ciu, String conj, String noConj) {
        calle = c;
        noCalle = n;
        barrio = b;
        ciudad = ciu;
        conjunto = conj;
        noConjunto = noConj;
    }

    //Métodos de acceso
    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return noCalle;
    }


    public String getBarrio() {
        return barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getConjunto() {
        return conjunto;
    }

    public String getNoConjunto() {
        return noConjunto;
    }

    //Métodos de lectura de datos por consola

    public void leerDireccion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la calle: ");
        calle = sc.nextLine();

        System.out.println("Ingrese el número de la calle: ");
        noCalle = sc.nextLine();
        

        System.out.println("Ingrese el barrio: ");
        barrio = sc.nextLine();

        System.out.println("Ingrese la ciudad: ");
        ciudad = sc.nextLine();

        System.out.println("Ingrese el conjunto: ");
        conjunto = sc.nextLine();

        System.out.println("Ingrese el número del conjunto: ");
        noConjunto = sc.nextLine();

        sc.close();
    }

    //Método para guardar como String

    public String toString() {
        // Separamos los dos numeros de la calle con un 
        return calle + " " +  noCalle +  " " + barrio + " " + ciudad + " " + conjunto + " " + noConjunto;
    }
}