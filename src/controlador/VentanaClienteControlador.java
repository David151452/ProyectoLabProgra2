/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDao;
import dao.VeterinarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Veterinario;
import vista.VentanaCliente;
import vista.VentanaClienteCodigo;
import vista.VentanaInicioCodigo;
import vista.VentanaVeterinarioCodigo;

/**
 *
 * @author lucia
 */
public class VentanaClienteControlador implements ActionListener {

    //Se instancia los atributos necesarios para conectar el modelo,dao,vista
    private VentanaClienteCodigo view;
    private Veterinario v;
    private VeterinarioDao vd;
    DefaultTableModel modelo;
    Cliente c = new Cliente();
    ClienteDao cd = new ClienteDao();
    VentanaVeterinarioCodigo view2 = new VentanaVeterinarioCodigo(v, vd);

    public VentanaClienteControlador(VentanaClienteCodigo view, Veterinario v, VeterinarioDao vd) {
        this.view = view;
        this.v = v;
        this.vd = vd;
    }

    public void ordenarPorPrecio() {
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio por el cual desea buscar"));
        ArrayList<Veterinario> veterinarios = vd.buscarPorPrecio(precio);
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Precio");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Especialidad");
        view.tabla.setModel(modelo);
        Object[] object = new Object[7];
        for (int i = 0; i < veterinarios.size(); i++) {
            object[0] = veterinarios.get(i).getId();
            object[1] = veterinarios.get(i).getNombre();
            object[2] = veterinarios.get(i).getCiudad();
            object[3] = veterinarios.get(i).getPrecio();
            object[4] = veterinarios.get(i).getCorreo();
            object[5] = veterinarios.get(i).getTelefono();
            object[6] = veterinarios.get(i).getEspecialidad();
            modelo.addRow(object);
        }
        view.tabla.setModel(modelo);
    }

    public void buscarPorCiudad() {
        /*Mediante JOptionPane.showInputDialog obtenemos los datos ingresados para luego
        ser utilizados en el metodo de tipo VeterinarioDao*/
        String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad por la cual desea buscar");
        ArrayList<Veterinario> veterinarios = vd.buscarPorCiudad(ciudad);
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Precio");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Especialidad");
        view.tabla.setModel(modelo);
        Object[] object = new Object[7];
        for (int i = 0; i < veterinarios.size(); i++) {
            object[0] = veterinarios.get(i).getId();
            object[1] = veterinarios.get(i).getNombre();
            object[2] = veterinarios.get(i).getCiudad();
            object[3] = veterinarios.get(i).getPrecio();
            object[4] = veterinarios.get(i).getCorreo();
            object[5] = veterinarios.get(i).getTelefono();
            object[6] = veterinarios.get(i).getEspecialidad();
            modelo.addRow(object);
        }
        view.tabla.setModel(modelo);
    }

    public void ver() {
        ArrayList<Veterinario> veterinarios = vd.listarDatos(); //A la lista le entrego los datos obtenidos desde el metodo del DAO
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Precio");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Especialidad");
        view.tabla.setModel(modelo);
        Object[] object = new Object[7];
        for (int i = 0; i < veterinarios.size(); i++) {
            object[0] = veterinarios.get(i).getId();
            object[1] = veterinarios.get(i).getNombre();
            object[2] = veterinarios.get(i).getCiudad();
            object[3] = veterinarios.get(i).getPrecio();
            object[4] = veterinarios.get(i).getCorreo();
            object[5] = veterinarios.get(i).getTelefono();
            object[6] = veterinarios.get(i).getEspecialidad();
            modelo.addRow(object);
        }
        view.tabla.setModel(modelo);
    }

    public void inicio() {
        this.view.setVisible(false);
        VentanaInicioCodigo ventanaInicio = new VentanaInicioCodigo(c, cd, view2, v, vd);
        ventanaInicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mediante los comandos definidos en la Ventana se puede diferenciar entre cada uno de ellos
        para que realicen metodos distintos*/
        String comando = e.getActionCommand();
        if (comando == "ciudad") {
            buscarPorCiudad();
        } else if (comando == "inicio") {
            inicio();
        } else if (comando == "precio") {
            ordenarPorPrecio();
        } else if (comando == "ver") {
            ver();
        }
    }
}
