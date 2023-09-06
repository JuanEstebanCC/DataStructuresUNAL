package com.example;

public class Direccion {
    /* Atributos para guardar la direccion */
    private String calle;
    private int noCalle;
    private String nomenclatura;
    private String barrio;
    private String ciudad;

    /* Métodos de la clase */
    //Constructor
    public Direccion(String c, int n, String nom, String b, String ciu) {
        calle = c;
        noCalle = n;
        nomenclatura = nom;
        barrio = b;
        ciudad = ciu;
    }

    //Métodos de acceso
    public String getCalle() {
        return calle;
    }

    public int getNumero() {
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

    public String toString() {
        // Separamos los dos numeros de la calle con un -
        String noCalleString = Integer.toString(noCalle);
        noCalleString = noCalleString.substring(0, 2) + "-" + noCalleString.substring(2);
        return calle + " " +  noCalleString +  " " + nomenclatura + " " + barrio + " " + ciudad;
    }
}