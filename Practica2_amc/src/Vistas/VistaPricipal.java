/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author carlo
 */
public class VistaPricipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPricipal
     */
    public VistaPricipal() {
        initComponents();
        setSize(850, 520);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargarFichero = new javax.swing.JMenuItem();
        jMenuItemCrearFichero = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemComprobar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivos");

        cargarFichero.setText("Cargar Fichero");
        jMenu1.add(cargarFichero);

        jMenuItemCrearFichero.setText("Crear Fichero");
        jMenuItemCrearFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearFicheroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCrearFichero);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Aplicación");

        jMenuItemComprobar.setText("Comprobar Palabra");
        jMenuItemComprobar.setActionCommand("ComprobarPalabra");
        jMenuItemComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemComprobarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemComprobar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCrearFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearFicheroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCrearFicheroActionPerformed

    private void jMenuItemComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemComprobarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemComprobarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem cargarFichero;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItemComprobar;
    public javax.swing.JMenuItem jMenuItemCrearFichero;
    // End of variables declaration//GEN-END:variables
}
