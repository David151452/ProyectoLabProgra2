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
import vista.VentanaInicio;
import vista.VentanaInicioCodigo;
import vista.VentanaVeterinario;
import vista.VentanaVeterinarioCodigo;

/**
 *
 * @author lucia
 */
public class VentanaVeterinarioControlador implements ActionListener {
    //Se instancia los atributos necesarios para conectar el modelo,dao,vista

    private VentanaVeterinarioCodigo view;
    private Veterinario v;
    private VeterinarioDao vd;
    DefaultTableModel modelo;
    Cliente c = new Cliente();
    ClienteDao cd = new ClienteDao();

    public VentanaVeterinarioControlador(VentanaVeterinarioCodigo view, Veterinario v, VeterinarioDao vd) {
        this.view = view;
        this.v = v;
        this.vd = vd;
    }

    public void insertar() {
        //Al objeto tipo veterinario se le instancia las variables que se obtienen desde los JTextfield
        v.setNombre(view.nombreTX.getText());
        v.setCiudad(view.ciudadTX.getText());
        v.setPrecio(Integer.parseInt(view.precioTX.getText()));
        v.setCorreo(view.correoTX.getText());
        v.setTelefono(view.telefonoTX.getText());
        v.setEspecialidad(view.especialidadTX.getText());
        //Los datos del objeto tipo Veterinario se les entrega a un objeto tipo VeterinarioDao para ser almacenados en la base de datos
        if (vd.insertarDatos(v.getNombre(), v.getCiudad(), v.getPrecio(), v.getCorreo(), v.getTelefono(), v.getEspecialidad())) {
            JOptionPane.showMessageDialog(null, "Ingresado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ups");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.ciudadTX.setText("");
        view.precioTX.setText("");
        view.correoTX.setText("");
        view.telefonoTX.setText("");
        view.especialidadTX.setText("");
    }

    public void eliminar() {
        //Entrego un mensaje dependiendo del resultado de la transaccion
        if (vd.eliminarDatos(view.nombreTX.getText()) == true) {
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "El veterinario que desea eliminar no existe en la base de datos");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.ciudadTX.setText("");
        view.precioTX.setText("");
        view.correoTX.setText("");
        view.telefonoTX.setText("");
        view.especialidadTX.setText("");
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
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.ciudadTX.setText("");
        view.precioTX.setText("");
        view.correoTX.setText("");
        view.telefonoTX.setText("");
        view.especialidadTX.setText("");
    }

    public void modificar() {
        /*Mediante JOptionPane.showInputDialog obtenemos los datos ingresados para luego
        ser utilizados en el metodo de tipo PersonaDao*/
        String nombreVeterinarioActual = JOptionPane.showInputDialog("Ingrese el nombre del veterinario que desea modificar");
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
        String nuevaCiudad = JOptionPane.showInputDialog("Ingrese la nueva ciudad");
        int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
        String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo");
        String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo telefono");
        String nuevaEspecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad");
        if (vd.actualizarDatos(nuevoNombre, nuevaCiudad, nuevoPrecio, nuevoCorreo, nuevoTelefono, nuevaEspecialidad, nombreVeterinarioActual) == true) {
            JOptionPane.showMessageDialog(null, "Actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "Error en la actualización, el veterinario no existe");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.nombreTX.setText("");
        view.ciudadTX.setText("");
        view.precioTX.setText("");
        view.correoTX.setText("");
        view.telefonoTX.setText("");
        view.especialidadTX.setText("");
    }

    public void inicio() {
        this.view.setVisible(false);
        VentanaInicioCodigo ventanaInicio = new VentanaInicioCodigo(c, cd, view, v, vd);
        ventanaInicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mediante los comandos definidos en la Ventana se puede diferenciar entre cada uno de ellos
        para que realicen metodos distintos*/
        String comando = e.getActionCommand();
        if (comando == "agregar") {
            insertar();
        } else if (comando == "eliminar") {
            eliminar();
        } else if (comando == "modificar") {
            modificar();
        } else if (comando == "ver") {
            ver();
        } else if (comando == "inicio") {
            inicio();
        }
    }

}
