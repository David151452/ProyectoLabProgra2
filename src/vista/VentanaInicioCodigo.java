/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.VentanaLoginControlador;
import controlador.VentanaVeterinarioControlador;
import dao.ClienteDao;
import dao.VeterinarioDao;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.Cliente;
import modelo.Veterinario;

/**
 *
 * @author david
 */
public class VentanaInicioCodigo extends JFrame {

    //Atributos de la ventana
    //Se ponen los atributos en publico para ser estos usados dentro de la VentanaLoginControlador
    public JButton crearClienteBTN;
    public JButton ingresarBTN;
    public JLabel iniciarLB;
    public JPanel panel;
    public JLabel passwordLB;
    public JTextField passwordTX;
    public JLabel usuarioLB;
    public JTextField usuarioTX;

    public VentanaInicioCodigo(Cliente c, ClienteDao cd, VentanaVeterinarioCodigo view1, Veterinario v, VeterinarioDao vd) {
        super("Ventana Inicio");
        this.crearClienteBTN = new JButton("Crear Cliente");
        this.ingresarBTN = new JButton("Ingresar");
        this.iniciarLB = new JLabel("Iniciar Sesion");
        this.panel = new JPanel();
        this.passwordLB = new JLabel("Contraseña:");
        this.passwordTX = new JTextField();
        this.usuarioLB = new JLabel("Usuario:");
        this.usuarioTX = new JTextField();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.agregarComponentes();
        VentanaLoginControlador vc = new VentanaLoginControlador(this, c, cd, view1, v, vd);
        this.crearClienteBTN.addActionListener(vc);
        this.crearClienteBTN.setActionCommand("crear");
        this.ingresarBTN.addActionListener(vc);
        this.ingresarBTN.setActionCommand("ingresar");
        this.setLocationRelativeTo(this);
    }

    public void agregarComponentes() {
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordLB)
                                                        .addComponent(usuarioLB))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordTX)
                                                        .addComponent(usuarioTX)))
                                        .addComponent(iniciarLB)
                                        .addComponent(ingresarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(crearClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(iniciarLB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usuarioLB)
                                        .addComponent(usuarioTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ingresarBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(crearClienteBTN)
                                .addContainerGap(48, Short.MAX_VALUE))
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
