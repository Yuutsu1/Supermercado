package com.company;

public class Administrador {
    private String usuario;
    private String clave;

    public Administrador(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave; //Comentario Prueba
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
}
