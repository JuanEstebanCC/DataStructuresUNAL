package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Import {

    public Import( String fileName) {

        fileName = "usersTXT.txt";

        // Cambiar el filePath con el tuyo
        String filePath = "C:\\Users\\santi\\Desktop\\Estructura de Datos\\Práctica 1\\DataStructuresUNAL\\demo\\src\\main\\java\\com\\example\\" + fileName;


        List<Usuario> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length >= 6) {
                    // ID
                    String idField = parts[0];
                    String idValue = extractValue(idField, "ID");

                    // Nombre
                    String nameField = parts[1];
                    String nameValue = extractValue(nameField, "Nombre");

                    // Fecha Nacimiento
                    String dateField = parts[2];
                    String dateValue = extractValue(dateField, "Fecha de nacimiento");
                    String[] dateComponents = dateValue.split("/");
                    int day = Integer.parseInt(dateComponents[0]);
                    int month = Integer.parseInt(dateComponents[1]);
                    int year = Integer.parseInt(dateComponents[2]);
                    Fecha fechas = new Fecha(day, month, year);

                    // Email
                    String emailField = parts[3];
                    String emailValue = extractValue(emailField, "Email");

                    // Telefono
                    String phoneField = parts[4];
                    String phoneValue = extractValue(phoneField, "Telefono");
                    long telefonoValue = Long.parseLong(phoneValue);

                    // Direccion
                    String addressField = parts[5];
                    String[] addressParts = addressField.split(" ");
                    String calle = addressParts[1];
                    String noCalle = addressParts[2].replace("-", "");
                    int noCalleValue = Integer.parseInt(noCalle);
                    String nomenclatura = addressParts[3];
                    String barrio = addressParts[4];
                    String ciudad = addressParts[5];
                    Direccion directions = new Direccion(calle, noCalleValue, nomenclatura, barrio, ciudad);

                    // Se añade cada campo
                    Usuario user = new Usuario(Long.parseLong(idValue), nameValue, fechas, emailValue, telefonoValue, directions);
                    userList.add(user);

                    // Print Usuario
                    System.out.println(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractValue(String field, String fieldName) {
        String[] fieldParts = field.split(": ");
        if (fieldParts.length == 2 && fieldName.equals(fieldParts[0].trim())) {
            return fieldParts[1].trim();
        }
        return "";
    }
}