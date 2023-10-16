package com.example;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // LocalDateTime fecha = LocalDateTime.now();
        // System.out.println(fecha);

        // String fechaString = fecha.toString();

        //Veamos como parsear la fecha
        //LocalDateTime fechaParseada = LocalDateTime.parse(fechaString);
        // System.out.println(fechaParseada);

        Menu menu = new Menu();
        menu.menuIngreso();
    }
}