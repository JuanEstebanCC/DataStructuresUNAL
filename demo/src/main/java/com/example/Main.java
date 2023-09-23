package com.example;

public class Main {
    public static void main(String[] args) {
        // Crear un registro de 10 usuarios
        Registro registro = new Registro(10);
        // Cargo los usuarios del archivo
        registro.Import("usersTXT.txt");

        for (int i = 0; i < registro.numRegistros(); i++) {
            System.out.println(registro.getRegistro()[i].toString());
        }

        // Crear un usuario
        Direccion direccion = new Direccion(123, "65-78", "C", "Poblado", "Medellin");
        Fecha fecha = new Fecha(12, 12, 1999);
        Usuario usuario = new Usuario(7809, "Juan Teheran", fecha,"kkmiel32@gmail.com", 123456789, direccion);

        // Agregar el usuario al registro
        registro.agregar(usuario);

        // Busquemos un usuario existente por id
        Usuario buscado = registro.buscarUsuario(134);
        System.out.println(buscado.toString());
        System.out.println("Posicion: " + registro.buscarPosicion(134));

        // Busquemos un usuario no existente por id
        Usuario buscado2 = registro.buscarUsuario(11);
        System.out.println(buscado2);

        // Guardar el registro en el archivo
        registro.toFile("newUsers.txt");

    }
}