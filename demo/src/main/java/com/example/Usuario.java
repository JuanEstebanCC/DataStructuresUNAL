package com.example;
import java.io.*;
import java.util.Scanner;
import java.util.*;


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
        System.out.print("Ingrese el ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine(); 

        System.out.print("Ingrese la fecha de nacimiento -----------------");
        System.out.print("Ingrese el día: ");
        int dia = sc.nextInt();

        System.out.print("Ingrese el mes: ");
        int mes = sc.nextInt();

        System.out.print("Ingrese el año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        fecha_nacimiento = new Fecha(dia, mes, anio);

        System.out.print("Ingrese la ciudad de nacimiento: ");
        ciudad_nacimiento = sc.nextLine();

        System.out.print("Ingrese el email: ");
        email = sc.nextLine();

        System.out.print("Ingrese el telefono: ");
        telefono = sc.nextLong();
        sc.nextLine();

        System.out.print("Ingrese la direccion ----------------- ");
        direccion.leerDireccion();

        sc.close();
    }

    // Metodo para crear un nuevo usuario

    public void nuevoUsuario(){
        Scanner sc = new Scanner(System.in);
        String contrasena;
        System.out.print("Ingrese la contraseña para el nuevo usuario: ");
        contrasena = sc.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.println("A continuación ingrese los datos del nuevo usuario");
        System.out.println();
        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese el ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.println("----------------------------------------------------");
        System.out.println("Datos de la fecha de nacimiento");
        System.out.println();
        System.out.print("Ingrese el día: ");
        int dia = sc.nextInt();

        System.out.print("Ingrese el mes: ");
        int mes = sc.nextInt();

        System.out.print("Ingrese el año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        fecha_nacimiento = new Fecha(dia, mes, anio);

        System.out.println("----------------------------------------------------");
        System.out.print("Ingrese la ciudad de nacimiento: ");
        ciudad_nacimiento = sc.nextLine();

        System.out.println("----------------------------------------------------");
        System.out.print("Ingrese el email: ");
        email = sc.nextLine();

        System.out.println("----------------------------------------------------");
        System.out.print("Ingrese el telefono: ");
        telefono = sc.nextLong();
        sc.nextLine();

        System.out.println("----------------------------------------------------");
        System.out.print("Datos de la dirección");
        System.out.println();
        direccion.leerDireccion();


        // Crear objeto File
        File Empleados = new File("demo/src/main/java/com/example/Datos/InfoUsuarios/Empleados.txt");
        File Password = new File("demo/src/main/java/com/example/Datos/InfoUsuarios/Password.txt");

        try {
            // Abrir archivo en modo escritura
            BufferedWriter escritorEmpleados = new BufferedWriter(new FileWriter(Empleados,true));
            BufferedWriter escritorPassword = new BufferedWriter(new FileWriter(Password,true));

            // Escribir datos en el archivo Empleados
            escritorEmpleados.write("\r\n");
            escritorEmpleados.write(nombre + " " + id + " " + fecha_nacimiento.getDia() + " " + fecha_nacimiento.getMes() + " " + fecha_nacimiento.getAnio() + " " + ciudad_nacimiento + " " + telefono + " " + email + " " + direccion.getCalle() + " " + direccion.getNumero() + " " + direccion.getBarrio() + " " + direccion.getCiudad() + " "+ direccion.getConjunto() + " " + direccion.getNoConjunto());
            System.out.println("Datos guardados correctamente en Empleados.txt");

            // Escribir datos en el archivo Empleados
            escritorPassword.write("\r\n");
            escritorPassword.write(id+" "+contrasena+" "+"empleado");
            System.out.println("Datos guardados correctamente en Password.txt");

            // Cerrar archivo
            escritorEmpleados.close();
            escritorPassword.close();


            System.out.println("\n");
            System.out.println("Usuario creado con exito!");

        } catch (IOException e) {
            System.out.println("Error al guardar los datos en Empleados.txt");
            e.printStackTrace();
        }

    }

    // Metodo para cambiar la contraseña de un usario
    public void cambiarPassUsuario(int id) {
        try {
            File archivo = new File("demo/src/main/java/com/example/Datos/InfoUsuarios/Password.txt");
            Scanner scanner = new Scanner(archivo);
            Scanner sc = new Scanner(System.in);
            Scanner userInput = new Scanner(System.in);

            System.out.print("Ingrese su nueva contraseña: ");
            String newPass = sc.nextLine();

            StringBuilder nuevoContenido = new StringBuilder();

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(" ");

                if (campos.length >= 2) {
                    try {
                        int valorPrimero = Integer.parseInt(campos[0]);
                        if (valorPrimero == id) {
                            campos[1] = newPass;
                            linea = String.join(" ", campos);
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar líneas que no tengan un valor numérico en el primer campo
                    }
                }

                nuevoContenido.append(linea).append(System.lineSeparator());
            }

            scanner.close();

            FileWriter escritor = new FileWriter(archivo);
            escritor.write(nuevoContenido.toString());
            escritor.close();

            System.out.println("Los cambios se han realizado con éxito.");

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer/escribir el archivo.");
            e.printStackTrace();
        }


    }

    // Metodo para eliminar un usuario del archivo
    public void deleteUser(int id){
        String archivo1 = "demo/src/main/java/com/example/Datos/InfoUsuarios/Empleados.txt";
        String archivo2 = "demo/src/main/java/com/example/Datos/InfoUsuarios/Password.txt";


        // Nombre del archivo
        String idABuscar = Integer.toString(id);


        // Nombre de los archivos temporales
        String archivoTemporal1 = "archivo_temporal1.txt";
        String archivoTemporal2 = "archivo_temporal2.txt";



        try {
            // Procesar archivo1
            BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(archivoTemporal1));
            String linea1;

            while ((linea1 = br1.readLine()) != null) {
                // Dividir la línea en palabras utilizando un espacio en blanco como separador
                String[] palabras1 = linea1.split(" ");

                // Verificar si el segundo campo no coincide con el ID
                if (palabras1.length >= 2 && !palabras1[1].equals(idABuscar)) {
                    // Si no coinciden, escribir la línea en el archivo temporal 1
                    bw1.write(linea1);
                    bw1.newLine();
                }
            }

            br1.close();
            bw1.close();

            // Reemplazar archivo1 con el archivo temporal 1
            File archivoOriginal1 = new File(archivo1);
            if (!archivoOriginal1.delete()) {
                System.err.println("No se pudo eliminar el archivo Empleados txt.");
                return;
            }
            File temporal1 = new File(archivoTemporal1);
            if (!temporal1.renameTo(archivoOriginal1)) {
                System.err.println("No se pudo reemplazar el archivo Empleados.txt");
            } else {
                System.out.println("Líneas eliminadas con éxito en el archivo de Empleados.txt");
            }

            // Procesar archivo2
            BufferedReader br2 = new BufferedReader(new FileReader(archivo2));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(archivoTemporal2));
            String linea2;

            while ((linea2 = br2.readLine()) != null) {
                // Dividir la línea en palabras utilizando un espacio en blanco como separador
                String[] palabras2 = linea2.split(" ");

                // Verificar si el primer campo no coincide con el ID
                if (palabras2.length >= 1 && !palabras2[0].equals(idABuscar)) {
                    // Si no coinciden, escribir la línea en el archivo temporal 2
                    bw2.write(linea2);
                    bw2.newLine();
                }
            }

            br2.close();
            bw2.close();

            // Reemplazar archivo2 con el archivo temporal 2
            File archivoOriginal2 = new File(archivo2);
            if (!archivoOriginal2.delete()) {
                System.err.println("No se pudo eliminar el archivo Password.txt.");
                return;
            }
            File temporal2 = new File(archivoTemporal2);
            if (!temporal2.renameTo(archivoOriginal2)) {
                System.err.println("No se pudo reemplazar el archivo Password.txt");
            } else {
                System.out.println("Líneas eliminadas con éxito en el archivo Password.txt");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Método para toString

    public String toString() {
        return nombre + " " + Integer.toString(id) + " " + fecha_nacimiento.toString() + " " + ciudad_nacimiento + " " + telefono + " " + direccion.toString();
    }
    
}