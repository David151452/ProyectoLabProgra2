/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.VentanaClienteControlador;
import controlador.VentanaVeterinarioControlador;
import dao.VeterinarioDao;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.Veterinario;

/**
 *
 * @author david
 */
public class VentanaClienteCodigo extends JFrame {

    //Atributos de la ventana
    //Se ponen los atributos en publico para ser estos usados dentro de la VentanaClienteControlador
    public JButton ciudadBTN;
    public JButton inicioBTN;
    public JScrollPane jScrollPane1;
    public JPanel panel;
    public JButton precioBTN;
    public JTable tabla;
    public JButton verVeterinariosBTN;

    public VentanaClienteCodigo(Veterinario v, VeterinarioDao vd) {
        super("Ventana Cliente");
        this.panel = new JPanel();
        this.ciudadBTN = new JButton("Buscar por ciudad");
        this.inicioBTN = new JButton("Inicio");
        this.jScrollPane1 = new JScrollPane();
        this.precioBTN = new JButton("Buscar por precio");
        this.tabla = new JTable();
        this.verVeterinariosBTN = new JButton("Ver listado");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.agregarComponentes();
        VentanaClienteControlador vc = new VentanaClienteControlador(this, v, vd);
        this.ciudadBTN.addActionListener(vc);
        this.ciudadBTN.setActionCommand("ciudad");
        this.inicioBTN.addActionListener(vc);
        this.inicioBTN.setActionCommand("inicio");
        this.precioBTN.addActionListener(vc);
        this.precioBTN.setActionCommand("precio");
        this.verVeterinariosBTN.addActionListener(vc);
        this.verVeterinariosBTN.setActionCommand("ver");
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Nombre", "Ciudad", "Precio", "Correo", "Telefono", "Especialidad"
                }
        ));
    }

    public void agregarComponentes() {
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Nombre", "Ciudad", "Precio", "Correo", "Telefono", "Especialidad"
                }
        ));
        jScrollPane1.setViewportView(tabla);
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(precioBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(verVeterinariosBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inicioBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ciudadBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(verVeterinariosBTN)
                                                .addGap(5, 5, 5)
                                                .addComponent(precioBTN)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ciudadBTN)
                                                .addGap(8, 8, 8)
                                                .addComponent(inicioBTN))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
