package vista;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.io.IOException;

public class Inicio extends javax.swing.JFrame {

    // Declaración de constantes para las rutas de recursos
    private static final String FONDO_INICIO_IMG_PATH = "/imagenes/FondoInicio.png";

    // Declaración de variable static
    private static BufferedImage imgOriginal;

    public Inicio() {
        initComponents();

        // Configurar la imagen de lblFondo usando la constante
        lblFondo.setIcon(new ImageIcon(getClass().getResource(FONDO_INICIO_IMG_PATH)));

        // Configurar redimensionamiento de imagen
        lblFondo.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                System.out.println("lblFondo redimensionado");  // Verificación
                ajustarImagen();
            }
        });
        // Ajustar imagen al inicio
        ajustarImagen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomEmpresa = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomEmpresa.setFont(new java.awt.Font("Baskerville Old Face", 1, 48)); // NOI18N
        lblNomEmpresa.setForeground(new java.awt.Color(255, 255, 0));
        lblNomEmpresa.setText("\"FERRO CENTER\"");
        getContentPane().add(lblNomEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        lblEmpresa.setFont(new java.awt.Font("Baskerville Old Face", 1, 48)); // NOI18N
        lblEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpresa.setText("FERRETERIA");
        getContentPane().add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        btnMenu.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        try {
            Menu menu = new Menu();
            menu.setLocationRelativeTo(null);
            this.setVisible(false);
            menu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        // Cargar imagen original
        try {
            imgOriginal = ImageIO.read(Inicio.class.getResource(FONDO_INICIO_IMG_PATH));
        } catch (IOException ex) {
            // Manejar la excepción
            System.out.println("Error leyendo imagen: " + ex);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inicio inicio = new Inicio();
                inicio.setResizable(false);   // Evita que el usuario pueda redimensionar la ventana
                inicio.setLocationRelativeTo(null);  // Esto centra el formulario en la pantalla
                inicio.setVisible(true);
            }
        });
    }

    public void ajustarImagen() {

        int ancho = lblFondo.getWidth();
        int alto = lblFondo.getHeight();

        Image imgRedimensionada = imgOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imgRedimensionada);

        lblFondo.setIcon(icono);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNomEmpresa;
    // End of variables declaration//GEN-END:variables
}
