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
        Direccion direccion = new Direccion(1145, "75-48", "A", "Robledo", "Popayán");
        Fecha fecha = new Fecha(21, 12, 2000);
        Usuario usuario = new Usuario(2309, "Juan Esteban", fecha,"secretomio@gmail.com", 837492049, direccion);

        // Agregar el usuario al registro
        registro.agregar(usuario);

        // Busquemos un usuario existente por id
        Usuario buscado = registro.buscarUsuario(4444);
        System.out.println(buscado.toString());
        System.out.println("Posicion: " + registro.buscarPosicion(4444));

        // Busquemos un usuario no existente por id
        Usuario buscado2 = registro.buscarUsuario(11);
        System.out.println(buscado2);

        // Guardar el registro en el archivo
        registro.toFile("usersTXT.txt");

    }
}