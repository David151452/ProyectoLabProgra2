/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
public class VentanaVeterinarioCodigo extends JFrame {

    //Atributos de la ventana
    //Se ponen los atributos en publico para ser estos usados dentro de la VentanaVeterinarioControlador
    public JButton agregarBTN;
    public JLabel ciudadLB;
    public JTextField ciudadTX;
    public JLabel correoLB;
    public JTextField correoTX;
    public JButton eliminarBTN;
    public JLabel especialidadLB;
    public JTextField especialidadTX;
    public JButton inicioBTN;
    public JScrollPane scroll;
    public JButton modificarBTN;
    public JLabel nombreLB;
    public JTextField nombreTX;
    public JPanel panel;
    public JLabel precioLB;
    public JTextField precioTX;
    public JTable tabla;
    public JLabel telefonoLB;
    public JTextField telefonoTX;
    public JButton verBTN;

    public VentanaVeterinarioCodigo(Veterinario v, VeterinarioDao vd) {
        super("Ventana Veterinario");
        this.agregarBTN = new JButton("Agregar");
        this.ciudadLB = new JLabel("Ciudad:");
        this.ciudadTX = new JTextField();
        this.correoLB = new JLabel("Correo:");
        this.correoTX = new JTextField();
        this.eliminarBTN = new JButton("Eliminar");
        this.especialidadLB = new JLabel("Especialidad:");
        this.especialidadTX = new JTextField();
        this.inicioBTN = new JButton("Inicio");
        this.scroll = new JScrollPane();
        this.modificarBTN = new JButton("Modificar");
        this.nombreLB = new JLabel("Nombre:");
        this.nombreTX = new JTextField();
        this.panel = new JPanel();
        this.precioLB = new JLabel("Precio:");
        this.precioTX = new JTextField();
        this.tabla = new JTable();
        this.telefonoLB = new JLabel("Telefono:");
        this.telefonoTX = new JTextField();
        this.verBTN = new JButton("Ver");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.agregarComponentes();
        VentanaVeterinarioControlador vc = new VentanaVeterinarioControlador(this, v, vd);
        this.agregarBTN.addActionListener(vc);
        this.agregarBTN.setActionCommand("agregar");
        this.eliminarBTN.addActionListener(vc);
        this.eliminarBTN.setActionCommand("eliminar");
        this.modificarBTN.addActionListener(vc);
        this.modificarBTN.setActionCommand("modificar");
        this.verBTN.addActionListener(vc);
        this.verBTN.setActionCommand("ver");
        this.inicioBTN.addActionListener(vc);
        this.inicioBTN.setActionCommand("inicio");
    }

    public void agregarComponentes() {
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Nombre", "Ciudad", "Precio", "Correo", "Telefono", "Especialidad"
                }
        ));
        scroll.setViewportView(tabla);
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ciudadLB)
                                                                        .addComponent(precioLB)
                                                                        .addComponent(nombreLB))
                                                                .addGap(38, 38, 38)
                                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(ciudadTX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                                        .addComponent(nombreTX, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(precioTX)))
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(especialidadLB)
                                                                        .addComponent(telefonoLB)
                                                                        .addComponent(correoLB))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(telefonoTX)
                                                                        .addComponent(especialidadTX)
                                                                        .addComponent(correoTX))))
                                                .addGap(37, 37, 37))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(modificarBTN)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(agregarBTN)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(eliminarBTN))
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(inicioBTN)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(verBTN)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)))
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nombreLB)
                                                        .addComponent(nombreTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ciudadLB)
                                                        .addComponent(ciudadTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(precioLB)
                                                        .addComponent(precioTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(correoLB)
                                                        .addComponent(correoTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(telefonoLB)
                                                        .addComponent(telefonoTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(especialidadLB)
                                                        .addComponent(especialidadTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(modificarBTN)
                                                        .addComponent(agregarBTN)
                                                        .addComponent(eliminarBTN))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(verBTN)
                                                        .addComponent(inicioBTN))
                                                .addContainerGap(59, Short.MAX_VALUE))))
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
