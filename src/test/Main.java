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
        VentanaVeterinarioCodigo view2 = new VentanaVeterinarioCodigo(v, vd);
        VentanaInicioCodigo view1 = new VentanaInicioCodigo(c, cd, view2, v, vd);
        view1.setVisible(true);
        VentanaLoginControlador ctrl = new VentanaLoginControlador(view1, c, cd, view2, v, vd);
    }
}
