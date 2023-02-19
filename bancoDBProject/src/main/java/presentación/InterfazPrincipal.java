/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package presentación;

import interfaces.IClientesDAO;
import interfaces.ICuentaDAO;
import interfaces.IDomicilioDAO;
import interfaces.IRetiroDAO;
import interfaces.ITransferenciaDAO;

/**
 *
 * @author Samuel Vega & Victor Gonzales
 */
public class InterfazPrincipal extends javax.swing.JFrame {
    private final ClienteForm clienteForm;
    private final CuentaForm cuentaForm;
    private final DomicilioForm domicilioForm;
    private final RetiroForm retiroForm;
    private final TransferenciaForm transferenciaForm;
    
    public InterfazPrincipal(IClientesDAO clientesDAO, ICuentaDAO cuentaDAO, IDomicilioDAO domicilioDAO, IRetiroDAO retiroDAO, ITransferenciaDAO transferenciaDAO) {
        this.clienteForm = new ClienteForm(clientesDAO);
        this.cuentaForm = new CuentaForm(cuentaDAO);
        this.domicilioForm = new DomicilioForm(domicilioDAO);
        this.retiroForm = new RetiroForm(retiroDAO);
        this.transferenciaForm = new TransferenciaForm(transferenciaDAO);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        ListasMenu = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        MenuCuenta = new javax.swing.JMenuItem();
        MenuDomicilio = new javax.swing.JMenuItem();
        MenuRetiro = new javax.swing.JMenuItem();
        Transferencia = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        ListasMenu.setMnemonic('e');
        ListasMenu.setText("Listas");

        MenuClientes.setMnemonic('t');
        MenuClientes.setText("Clientes");
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        ListasMenu.add(MenuClientes);

        MenuCuenta.setMnemonic('y');
        MenuCuenta.setText("Cuentas");
        MenuCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCuentaActionPerformed(evt);
            }
        });
        ListasMenu.add(MenuCuenta);

        MenuDomicilio.setMnemonic('p');
        MenuDomicilio.setText("Domicilio");
        MenuDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDomicilioActionPerformed(evt);
            }
        });
        ListasMenu.add(MenuDomicilio);

        MenuRetiro.setMnemonic('d');
        MenuRetiro.setText("Retiro");
        MenuRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRetiroActionPerformed(evt);
            }
        });
        ListasMenu.add(MenuRetiro);

        Transferencia.setText("Transferencia");
        Transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferenciaActionPerformed(evt);
            }
        });
        ListasMenu.add(Transferencia);

        menuBar.add(ListasMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Usuario");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Iniciar Sesión");
        contentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Cerrar Sesión");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void contentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contentsMenuItemActionPerformed

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        clienteForm.setVisible(true);
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCuentaActionPerformed
        cuentaForm.setVisible(true);
    }//GEN-LAST:event_MenuCuentaActionPerformed

    private void MenuDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDomicilioActionPerformed
        domicilioForm.setVisible(true);
    }//GEN-LAST:event_MenuDomicilioActionPerformed

    private void MenuRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRetiroActionPerformed
        retiroForm.setVisible(true);
    }//GEN-LAST:event_MenuRetiroActionPerformed

    private void TransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferenciaActionPerformed
        transferenciaForm.setVisible(true);
    }//GEN-LAST:event_TransferenciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ListasMenu;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuCuenta;
    private javax.swing.JMenuItem MenuDomicilio;
    private javax.swing.JMenuItem MenuRetiro;
    private javax.swing.JMenuItem Transferencia;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
