/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.VentanaLoginControlador;
import dao.ClienteDao;
import dao.VeterinarioDao;
import modelo.Cliente;
import modelo.Veterinario;
import vista.VentanaClienteCodigo;
import vista.VentanaInicio;
import vista.VentanaInicioCodigo;
import vista.VentanaVeterinario;
import vista.VentanaVeterinarioCodigo;

/**
 *
 * @author david
 */
public class Main {

    public static void main(String[] args) {

        Cliente c = new Cliente();
        ClienteDao cd = new ClienteDao();
        Veterinario v = new Veterinario();
        VeterinarioDao vd = new VeterinarioDao();
        VentanaVeterinarioCodigo view1 = new VentanaVeterinarioCodigo(v, vd);
        VentanaClienteCodigo view2 = new VentanaClienteCodigo(v, vd);
        VentanaInicioCodigo view3 = new VentanaInicioCodigo(c, cd, view1, v, vd);
        view3.setVisible(true);
        VentanaLoginControlador ctrl = new VentanaLoginControlador(view3, c, cd, view1, v, vd);
    }
}
