package com.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    private Usuario usuarioLogueado;
    private Registro registro;
    public RegistroCredenciales registroCredenciales;

    public Menu() {
        usuarioLogueado = null;
        registro = new Registro(10);
        registroCredenciales = new RegistroCredenciales(10);

        registroCredenciales.integridadMensajes();
        registro.Import();
        registroCredenciales.Import();
    }

    // Metodo para mostrar el menu de ingreso
    public void menuIngreso() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("----------------------");
            System.out.println("Bienvenido al sistema:");
            System.out.println("1. Ingresar");
            System.out.println("2. Salir");
            System.out.println("----------------------");
            System.out.print("Ingrese el número de opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    ingresar();
                    break;
                case 2:
                    System.out.println("Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida!");
                    break;
            }
        } while (opcion != 2);
    }

    // Metodo para ingresar al sistema
    public void ingresar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su id:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();
        Usuario u = registro.buscarUsuario(id);
        Credenciales c = registroCredenciales.buscarUsuario(id);
        if (u != null && c != null) {
            String tipoUser = c.getTipo();
            if (c.getContrasena().equals(contrasena)) {
                usuarioLogueado = u;
                if (tipoUser.equals("empleado")) {
                    // Mostramos el menu del Usuario
                    UserMenu();
                } else {
                    // Mostramos el menu del Administrador
                    AdmonMenu();
                }
            } else {
                System.out.println("Contraseña incorrecta");
                System.exit(0);
            }
        } else {
            System.out.println("Usuario no encontrado");
            System.exit(0);
        }
    }


    // Menu para administrador

    public void AdmonMenu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        //Cargamos la bandeja de entrada, los borradores y leidos
        BandejaEntrada bandejaEntrada = new BandejaEntrada(usuarioLogueado);
        do {
            System.out.print("\n\n\n");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Bienvenido/a " + "Administrador: " + usuarioLogueado.getNombre());
            System.out.println("-----------------------------------------------------------");
            System.out.println("¿Qué deseas realizar?:");
            System.out.println("1. Registrar un nuevo usuario");
            System.out.println("2. Cambiar una contraseña");
            System.out.println("3. Eliminar un usuario");
            System.out.println("4. Ver bandeja de entrada");
            System.out.println("5. Ver mensajes leídos");
            System.out.println("6. Ver borradores");
            System.out.println("7. Enviar un mensaje");
            System.out.println("8. Salir");
            System.out.println("-----------------------------------------------------------");
            System.out.print("Ingrese el número de opción: ");
            opcion = sc.nextInt();
            Usuario nu = new Usuario();
            switch (opcion) {
                case 1:
                    System.out.println();
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Registrar un nuevo usuario");
                    System.out.println("-----------------------------------------------------------");
                    nu.nuevoUsuario();
                    break;
                case 2:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Cambiar contraseña");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Ingrese el id del empleado al que desea cambiarle la contraseña");
                    int idChangePass = sc.nextInt();
                    nu.cambiarPassUsuario(idChangePass);
                    break;
                case 3:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Eliminar un usuario");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Ingrese el id del empleado que desea eliminar: ");
                    int id = sc.nextInt();
                    nu.deleteUser(id);
                    break;
                case 4:
                    System.out.println("Bandeja de entrada:");
                    bandejaEntrada.mostrarBandeja();


                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida!");
                    break;
            }
        } while (opcion != 4);
    }



    // Menu para usuario
    public void UserMenu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            //Se cargan los mensajes del usuario, en bandeja de entrada, borradores y leidos
            BandejaEntrada bandejaEntrada = new BandejaEntrada(usuarioLogueado);
            MensajesLeidos mensajesLeidos = new MensajesLeidos(usuarioLogueado);
            Borradores borradores = new Borradores(usuarioLogueado);

            System.out.print("\n\n\n");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Bienvenido/a " + "Empleado: " + usuarioLogueado.getNombre());
            System.out.println("-----------------------------------------------------------");
            System.out.println("¿Qué deseas realizar?:");
            System.out.println("1. Ver bandeja de entrada");
            System.out.println("2. Ver mensajes leídos");
            System.out.println("3. Ver borradores");
            System.out.println("4. Enviar un mensaje");
            System.out.println("5. Salir");
            System.out.println("-----------------------------------------------------------");
            System.out.print("Ingrese el número de opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Bandeja de entrada:");
                    break;
                case 2:
                    System.out.println("Mensajes leídos:");
                    break;
                case 3:
                    System.out.println("Borradores:");
                    break;
                case 4:
                    System.out.println("Enviar un mensaje");
                    Mensaje m = new Mensaje("","",LocalDateTime.now(),"",0);
                    m = m.crearMensaje(usuarioLogueado.getNombre());
                    System.out.println("Mensaje creado, elija una opción:");
                    System.out.println("1. Enviar");
                    System.out.println("2. Guardar en borradores");
                    System.out.println("3. Eliminar");
                    int respuesta = sc.nextInt();
                    switch (respuesta) {
                        case 1:
                            m.enviarMensaje();
                            break;
                        case 2:
                            System.out.println("Mensaje guardado en borradores");
                            //Se guarda en los borradores
                            borradores.guardarBorrador(m);
                            break;
                        case 3:
                            System.out.println("Mensaje eliminado");
                            break;
                        default:
                            System.out.println("Opción no válida!");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida!");
                    break;
            }
        } while (opcion != 5);
    }

}
