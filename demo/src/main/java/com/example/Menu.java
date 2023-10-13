package com.example;
import java.util.Scanner;
public class Menu {
    private Usuario usuarioLogueado;
    private Registro registro;
    private RegistroCredenciales registroCredenciales;

    public Menu() {
        usuarioLogueado = null;
        registro = new Registro(10);
        registroCredenciales = new RegistroCredenciales(10);

        registro.Import();
        registroCredenciales.Import();
    }

    // Metodo para mostrar el menu de ingreso
    public void menuIngreso() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Bienvenido al sistema de registro de usuarios");
            System.out.println("1. Ingresar");
            System.out.println("2. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    ingresar();
                    break;
                case 2:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 2);
        sc.close();
    }

    // Metodo para ingresar al sistema
    public void ingresar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese su contraseña");
        String contrasena = sc.nextLine();
        Usuario u = registro.buscarUsuario(id);
        Credenciales c = registroCredenciales.buscarUsuario(id);
        if (u != null && c != null) {
            if (c.getContrasena().equals(contrasena)) {
                usuarioLogueado = u;
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
        sc.close();
    }

    // Metodo para mostrar el menu de opciones
    public void menuOpciones() {
        //Aca se debe verificar el tipo de usuario que se tiene logueado (Administrador o empleado)
        //Y luego en base al que se detecte, mostrar el menu correspondiente
    }

    // Menu para administrador

    public void AdmonMenu() {

    }

    // Menu para usuario
    public void UserMenu() {

    }

}
