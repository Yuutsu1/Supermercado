package com.company;

import java.util.Scanner;

public class Ventana {

    public void iniciarSesion(){
        Scanner scanner = new Scanner(System.in);

        Administrador admin = new Administrador("admin", "12345");
        String usuario;
        String clave;
        int numPanel;
        PanelProducto panelProducto = new PanelProducto();
        PanelPedido panelPedido = new PanelPedido();
        PanelProveedor panelProveedor = new PanelProveedor();

        System.out.println("\t\t----BIENVENIDO----");
        System.out.print("Por favor ingrese su usuario: ");
        usuario = scanner.nextLine();
        System.out.print("Por favor ingrese su clave: ");
        clave = scanner.nextLine();

        if (usuario.equals(admin.getUsuario()) && clave.equals(admin.getClave())){
            System.out.println("Ingreso con éxito\n");
        } else {
            System.out.println("Usuario o clave incorrecta");
            System.exit(-1);
        }

        System.out.println("\t¿Qué desea hacer?");
        System.out.println("1. Registrar Producto\n" +
                "2. Registrar Proveedor\n" +
                "3. Realizar Pedido\n");

        System.out.print(">>> ");
        numPanel = Integer.parseInt(scanner.nextLine());

        switch (numPanel) {
            case 1 -> panelProducto.mostrarFormulario();
            case 2 -> panelProveedor.mostrarFormulario();
            case 3 -> panelPedido.mostrarFormulario();
        }
    }
}
