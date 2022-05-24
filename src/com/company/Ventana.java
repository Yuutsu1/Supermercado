package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Ventana {
    ArrayList<Panel> paneles;
    Scanner scanner;

    public Ventana() {
        this.paneles = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initVentana();
    }


    public void iniciarSesion(){
        Administrador admin = new Administrador("admin", "12345");
        String usuario;
        String clave;

        System.out.println("\t\t----BIENVENIDO----");
        System.out.print("Por favor ingrese su usuario: ");
        usuario = scanner.nextLine();
        System.out.print("Por favor ingrese su clave: ");
        clave = scanner.nextLine();

        final boolean usuarioCorrecto = usuario.equals(admin.getUsuario());
        final boolean claveCorrecta = clave.equals(admin.getClave());

        checkAdmin(usuarioCorrecto, claveCorrecta);

        showMenu();
    }

    private void checkAdmin(boolean usuarioCorrecto, boolean claveCorrecta) {
        if (usuarioCorrecto && claveCorrecta){
            System.out.println("Ingreso con éxito\n");
        } else {
            System.out.println("Usuario o clave incorrecta");
            System.exit(-1);
        }
    }

    private void initVentana(){
        paneles.add(new PanelProducto()); //PANEL 1
        paneles.add(new PanelProveedor()); //PANEL 2
        paneles.add(new PanelPedido()); //PANEL 3
    }

    private void showMenu() {
        System.out.println("\t¿Qué desea hacer?");
        //De acuerdo al orden de los paneles ingresados en el constructor
        System.out.println("1. Registrar Producto\n" +
                "2. Registrar Proveedor\n" +
                "3. Realizar Pedido\n");

        System.out.print(">>> ");

        chooseMenu();
    }

    private void chooseMenu() {
        int index = inputNumber() - 1;
        if (index < paneles.size())
            paneles.get(index).mostrarFormulario();
        else
            System.out.println("ERROR. No existe ese menú");
    }

    private int inputNumber(){
        return Integer.parseInt(scanner.nextLine());
    }
}
