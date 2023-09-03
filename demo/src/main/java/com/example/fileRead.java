package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Objeto y clase de prueba

class Users {
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    public Users(String field1, String field2, String field3, String field4, String field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public String getField4() {
        return field4;
    }

    public String getField5() {
        return field5;
    }
}

public class fileRead {
    public static void main(String[] args) {
        // Nota: Cambiar el path absoluto conforme al tuyo, ya que no funciona de lo contrario
        String filePath = "C:\\Users\\santi\\Desktop\\Estructura de Datos\\Práctica 1\\DataStructuresUNAL\\demo\\src\\main\\java\\com\\example\\usersTXT.txt"; // Replace with the path to your text file
        List<Users> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Se lee cada linea
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|"); // Se divide por |
                if (parts.length >= 5) {
                    // Se asigna cada parte
                    String field1 = parts[0];
                    String field2 = parts[1];
                    String field3 = parts[2];
                    String field4 = parts[3];
                    String field5 = parts[4];

                    // Se añade cada campo
                    Users user = new Users(field1, field2, field3, field4, field5);
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ahora 'userList' tiene el objeto User con los 5 campos
        for (Users obj : userList) {
            System.out.println("Field 1: " + obj.getField1());
            System.out.println("Field 2: " + obj.getField2());
            System.out.println("Field 3: " + obj.getField3());
            System.out.println("Field 4: " + obj.getField4());
            System.out.println("Field 5: " + obj.getField5());
        }
    }
}
