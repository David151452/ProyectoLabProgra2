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
import vista.VentanaClienteCodigo;
import vista.VentanaInicio;
import vista.VentanaInicioCodigo;
import vista.VentanaVeterinarioCodigo;

/**
 *
 * @author lucia
 */
public class VentanaLoginControlador implements ActionListener {

    //Se instancia los atributos necesarios para conectar el modelo,dao,vista
    private VentanaInicioCodigo view;
    private Cliente c;
    private ClienteDao cd;
    private Veterinario v;
    private VeterinarioDao vd;
    private VentanaVeterinarioCodigo view1;

    public VentanaLoginControlador(VentanaInicioCodigo view, Cliente c, ClienteDao cd, VentanaVeterinarioCodigo view1, Veterinario v, VeterinarioDao vd) {
        this.view = view;
        this.c = c;
        this.cd = cd;
        this.view1 = view1;
        this.v = v;
        this.vd = vd;
    }

    /*public void iniciar() {
        view.setTitle("Vista");
        view.setLocationRelativeTo(null);
    }*/
    public void ingresar() {
        boolean aux = false;
        ArrayList<Cliente> clientes = cd.listarDatos(); //A la lista le entrego los datos obtenidos desde el metodo del DAO
        String aux1 = view.usuarioTX.getText();
        String aux2 = view.passwordTX.getText();
        String usuarioAdmin = "Admin";
        String passwordAdmin = "Admin";
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombreCliente().equalsIgnoreCase(aux1)) {
                if (clientes.get(i).getPasswordCliente().equals(aux2)) {
                    VentanaClienteCodigo v1 = new VentanaClienteCodigo(v, vd);
                    v1.setVisible(true);
                    view.usuarioTX.setText("");
                    view.passwordTX.setText("");
                    this.view.setVisible(false);
                    aux = true;
                }
            }
        }
        if (aux1.equals(usuarioAdmin)) {
            if (aux2.equals(passwordAdmin)) {
                VentanaVeterinarioCodigo v1 = new VentanaVeterinarioCodigo(v, vd);
                v1.setVisible(true);
                view.usuarioTX.setText("");
                view.passwordTX.setText("");
                this.view.setVisible(false);
                aux = true;
            }
        }
        if (aux == false) {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        }
    }

    public void crear() {
        //Al objeto tipo Trabajador se le instancia las variables que se obtienen desde los JTextfield
        c.setNombreCliente(view.usuarioTX.getText());
        c.setPasswordCliente(view.passwordTX.getText());
        //Los datos del objeto tipo Cliente se les entrega a un objeto tipo ClienteDao para ser almacenados en la base de datos
        if (cd.insertarDatos(c.getNombreCliente(), c.getPasswordCliente())) {
            JOptionPane.showMessageDialog(null, "Ingresado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Ups");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.usuarioTX.setText("");
        view.passwordTX.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mediante los comandos definidos en la Ventana se puede diferenciar entre cada uno de ellos
        para que realicen metodos distintos*/
        String comando = e.getActionCommand();
        if (comando == "ingresar") {
            ingresar();
        } else if (comando == "crear") {
            crear();
        }
    }

}
