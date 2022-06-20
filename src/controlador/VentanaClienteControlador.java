/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import vista.VentanaCliente;
import vista.VentanaInicioCodigo;

/**
 *
 * @author lucia
 */
public class VentanaClienteControlador implements ActionListener {

    //Se instancia los atributos necesarios para conectar el modelo,dao,vista
    private VentanaInicioCodigo view;
    private Cliente p;
    private ClienteDao pd;
    DefaultTableModel modelo;

    public VentanaClienteControlador(VentanaInicioCodigo view, Cliente p, ClienteDao pd) {
        this.view = view;
        this.p = p;
        this.pd = pd;
    }

    public void insertar() {
        //Al objeto tipo producto se le instancia las variables que se obtienen desde los JTextfield
        p.setNombreCliente(view.usuarioTX.getText());
        p.setPasswordCliente(view.PasswordTX.getText());
        //Los datos del objeto tipo Producto se les entrega a un objeto tipo ProductoDao para ser almacenados en la base de datos
        if (pd.insertarDatos(p.getNombreCliente(), p.getPasswordCliente())) {
            System.out.println("ingresado con exito");
        } else {
            System.out.println("UPS!");
        }
        //Dejar los campos vacidos despues de realizar la accion 
        view.usuarioTX.setText("");
        view.PasswordTX.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Mediante los comandos definidos en la Ventana se puede diferenciar entre cada uno de ellos
        para que realicen metodos distintos*/
        String comando = e.getActionCommand();
        if (comando == "crear") {
            insertar();

        }

    }

}
