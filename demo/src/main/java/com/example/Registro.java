package com.example;


public class Registro {
    private Usuario[] registro;
    private int numRegistros;



    //Constructor, inicializamos numRegistros a 0, puesto que aún no hay registros
    public Registro(int n) {
        registro = new Usuario[n];
        numRegistros = 0;
    }

    public Boolean agregar(Usuario u) {
        //Verificando que el usuario no exista
        for (int i = 0; i < numRegistros; i++) {
            if (registro[i].getId() == u.getId()) {
                System.out.println("El usuario ya existe");
                return false;
            }
        }

        if (numRegistros < registro.length){
            //@TODO Agregar el usuario al registro y organizarlo por id
            //Aca solo se esta agregando el usuario al final del arreglo, deberia organizarse
            registro[numRegistros] = u;
            numRegistros++;
            return true;
        } else {
            System.out.println("No se pueden agregar más registros");
            return false;
        }
    }

    public Usuario eliminar(long id){
        int i = 0;
        //Buscando la posicion del usuario a eliminar
        while(i < numRegistros && registro[i].getId() != id){
            i++;
        }
        if(i == numRegistros){
            System.out.println("No se encontró el usuario");
            return null;
        }else{
            Usuario eliminado = registro[i];
            //Eliminando el usuario y reorganizando el arreglo
            for(int j = i; j < numRegistros - 1; j++){
                registro[j] = registro[j+1];
            }
            //Actualizando el numero de registros
            numRegistros--;
            registro[numRegistros-1] = null;
            return eliminado;
        }

    }


}
