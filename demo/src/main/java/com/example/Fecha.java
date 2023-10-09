package com.example;
import java.util.Scanner;

public class Fecha {
    /* Atributos para guardar la fecha */
    private int dia;
    private int mes;
    private int anio;

    /*Métodos de la clase */
    //Constructor
    public Fecha() {
        dia = 0;
        mes = 0;
        anio = 0;
    }

    public Fecha(int d, int m, int a) {
        dia = d;
        mes = m;
        anio = a;
    }

    //Métodos de acceso
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    //Métodos de modificación

    public void setDia(int d) {
        dia = d;
    }

    public void setMes(int m) {
        mes = m;
    }

    public void setAnio(int a) {
        anio = a;
    }

    // Metodo para ingresar fecha por teclado
    public void leerFecha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el día: ");
        dia = sc.nextInt();

        System.out.println("Ingrese el mes: ");
        mes = sc.nextInt();

        System.out.println("Ingrese el año: ");
        anio = sc.nextInt();

        sc.close();
    }
    
    //Método para toString
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
    

}