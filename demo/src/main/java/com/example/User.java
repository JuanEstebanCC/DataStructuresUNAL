package com.example;


public class User {
    //Atributos de la clase
    private String Nombre;
    private int ID;

    //Constructores

    public User() {
        this.Nombre = null;
        this.ID = 0;
    }
    
    public User(String Nombre, int ID) {
        this.Nombre = Nombre;
        this.ID = ID;
    }

    //Getters de la clase

    public String getNombre() {
        return Nombre;
    }

    public int getID() {
        return ID;
    }

    //Setters de la clase

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    //Metodo para sumar los digitos de la ID

    public int SumaDigitos() {
        int suma = 0;
        int aux = this.ID;
        while (aux > 0) {
            suma += aux % 10;
            aux /= 10;
        }
        return suma;
    }

    //Metodo toString
    public String toString() {
        return "Nombre: " + this.Nombre + " | ID: " + this.ID + "|- KEY -" + this.SumaDigitos() + "\n";
    }
}