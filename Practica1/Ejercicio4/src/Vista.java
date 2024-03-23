/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jluisparrazor
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form vista
     */
    public Vista(Cliente cliente, Objetivo objetivo) {
        initComponents();
        this.cliente = cliente;
        revoluciones = 0;
        velocidad = 0;
        distanciaReciente = 0;
        distanciaTotal = 0;
        distanciaAuxiliar = 0;
        salpicadero = objetivo;
        estadoMotor = EstadoMotor.APAGADO;
        int delay = 100;

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Aquí llamas al método ejecutar del cliente
                cliente.ejecutar(revoluciones, estadoMotor);
                // Y luego actualizas los valores en la vista
                actualizarValores();
            }
        };

        new Timer(delay, taskPerformer).start();
    }

    public Vista() {
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
        
        Texto = new javax.swing.JLabel();
        BotonFrenar = new javax.swing.JToggleButton();
        BotonEncender = new javax.swing.JToggleButton();
        BotonAcelerar = new javax.swing.JToggleButton();
        BotonFrenar.setEnabled(false);
        BotonEncender.setEnabled(true);
        BotonAcelerar.setEnabled(false);
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RPMlabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ConTotlabel = new javax.swing.JLabel();
        ConReclabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        KMlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 255, 255));

        Texto.setHorizontalAlignment(SwingConstants.CENTER);
        Texto.setBackground(new java.awt.Color(25, 255, 255));
        Texto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        Texto.setForeground(new java.awt.Color(255, 0, 0));
        Texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Texto.setText("APAGADO");
        Texto.setBackground(Color.white);
        Texto.setForeground(Color.RED);

        BotonFrenar.setForeground(new java.awt.Color(0, 0, 0));
        BotonFrenar.setText("Frenar");
        BotonFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFrenarActionPerformed(evt);
            }
        });

        BotonEncender.setForeground(new java.awt.Color(0, 255, 0));
        BotonEncender.setText("Encender");
        BotonEncender.setForeground(Color.GREEN);
        BotonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEncenderActionPerformed(evt);
            }
        });

        BotonAcelerar.setForeground(new java.awt.Color(0, 0, 0));
        BotonAcelerar.setText("Acelerar");
        BotonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAcelerarActionPerformed(evt);
            }
        });

        jLabel1.setText("Mandos");

        jLabel2.setText("Cuentarrevoluciones");

        jLabel3.setText("RPM");

        RPMlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RPMlabel.setText(Double.toString(revoluciones));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(RPMlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RPMlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel4.setText("CuentaKilómetros");

        jLabel6.setText("Contador reciente");

        jLabel7.setText("Contador total");

        ConTotlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConTotlabel.setText(Double.toString(distanciaReciente));

        ConReclabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConReclabel.setText(Double.toString(distanciaTotal));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(344, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(318, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConReclabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(ConTotlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(ConReclabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(ConTotlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel5.setText("Salpicadero");

        jLabel8.setText("Velocímetro");

        jLabel9.setText("Km/h");

        KMlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KMlabel.setText(Double.toString(velocidad));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(KMlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(KMlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(BotonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(BotonAcelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonFrenar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAcelerar)
                    .addComponent(BotonFrenar)
                    .addComponent(BotonEncender))
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        Texto.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEncenderActionPerformed
        if (estadoMotor == EstadoMotor.APAGADO) {
            BotonEncender.setText("Apagar");
            BotonEncender.setForeground(Color.RED);
            Texto.setText("ENCENDIDO");
            BotonFrenar.setEnabled(true);
            BotonAcelerar.setEnabled(true);
            Texto.setForeground(Color.green);
            estadoMotor = EstadoMotor.ENCENDIDO;
        } 
        else if (estadoMotor == EstadoMotor.ENCENDIDO) {
            BotonEncender.setText("Encender");
            BotonEncender.setForeground(Color.GREEN);
            Texto.setText("APAGADO");
            BotonFrenar.setEnabled(false);
            BotonAcelerar.setEnabled(false);
            Texto.setForeground(Color.red);
            estadoMotor = EstadoMotor.APAGADO;
        }
    }//GEN-LAST:event_BotonEncenderActionPerformed

    private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAcelerarActionPerformed
        if (estadoMotor == EstadoMotor.ENCENDIDO) {
            BotonAcelerar.setText("Soltar acelerador");
            BotonAcelerar.setForeground(Color.RED);
            BotonFrenar.setEnabled(false);
            BotonEncender.setEnabled(false);
            Texto.setForeground(Color.orange);
            Texto.setText("ACELERANDO");
            estadoMotor = EstadoMotor.ACELERANDO;
        } 
        else if (estadoMotor == EstadoMotor.ACELERANDO) {
            BotonAcelerar.setText("Acelerar");
            BotonAcelerar.setForeground(Color.BLACK);
            BotonFrenar.setEnabled(true);
            BotonEncender.setEnabled(true);
            Texto.setForeground(Color.green);
            Texto.setText("ENCENDIDO");
            estadoMotor = EstadoMotor.ENCENDIDO;
        }
        
    }//GEN-LAST:event_BotonAcelerarActionPerformed

    private void BotonFrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFrenarActionPerformed
        if (estadoMotor == EstadoMotor.ENCENDIDO){
            BotonFrenar.setText("Soltar freno");
            BotonFrenar.setForeground(Color.RED);
            BotonAcelerar.setEnabled(false);
            BotonEncender.setEnabled(false);
            Texto.setForeground(Color.orange);
            Texto.setText("FRENANDO");
            estadoMotor = EstadoMotor.FRENANDO;
        } 
        else if (estadoMotor == EstadoMotor.FRENANDO) {
            BotonFrenar.setText("Frenar");
            BotonFrenar.setForeground(Color.BLACK);
            BotonAcelerar.setEnabled(true);
            BotonEncender.setEnabled(true);
            Texto.setForeground(Color.green);
            Texto.setText("ENCENDIDO");
            estadoMotor = EstadoMotor.ENCENDIDO;
        }
    }//GEN-LAST:event_BotonFrenarActionPerformed

    private void actualizarValores(){
        revoluciones = salpicadero.getRevoluciones();
        RPMlabel.setText(df.format(revoluciones));

        velocidad = salpicadero.getVelocidad();
        KMlabel.setText(df.format(velocidad));

        distanciaTotal = salpicadero.getDistancia();
        if (revoluciones == 0){
            distanciaAuxiliar = distanciaTotal;
        }

        distanciaReciente = distanciaTotal - distanciaAuxiliar;
        ConReclabel.setText(df.format(distanciaReciente));
        ConTotlabel.setText(df.format(distanciaTotal));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonAcelerar;
    private javax.swing.JToggleButton BotonEncender;
    private javax.swing.JToggleButton BotonFrenar;
    private javax.swing.JLabel ConReclabel;
    private javax.swing.JLabel ConTotlabel;
    private javax.swing.JLabel KMlabel;
    private javax.swing.JLabel RPMlabel;
    private javax.swing.JLabel Texto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private Cliente cliente;
    private Objetivo salpicadero;
    private double revoluciones, velocidad, distanciaReciente, distanciaTotal, distanciaAuxiliar;
    private EstadoMotor estadoMotor;
    private DecimalFormat df = new DecimalFormat("#.##");
    // End of variables declaration//GEN-END:variables
}