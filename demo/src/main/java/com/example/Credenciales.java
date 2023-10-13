package com.example;

public class Credenciales {
    private String usuario;
    private String contrasena;
    private String tipo;

    public Credenciales(String usuario, String contrasena, String tipo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
