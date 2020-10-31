/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.to.pkgbyte.array;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author revtm
 */
public class EkstrakForm extends javax.swing.JFrame {
    private EkstrakStegfile ekstrak;
    /**
     * Creates new form EkstrakForm
     */
    public EkstrakForm() {
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

        jLabel1 = new javax.swing.JLabel();
        pilihStego = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        alamatStego = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teksEkstrak = new javax.swing.JTextArea();
        ekstrakSekarang = new javax.swing.JButton();
        simpanPesan = new javax.swing.JButton();
        statusSimpan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pilih Stegofile yang akan diekstrak:");

        pilihStego.setText("Pilih File");
        pilihStego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihStegoActionPerformed(evt);
            }
        });

        jLabel2.setText("Alamat Stegofile : ");

        alamatStego.setText("Alamat/Stegofile/file.bmp");

        teksEkstrak.setColumns(20);
        teksEkstrak.setRows(5);
        jScrollPane1.setViewportView(teksEkstrak);

        ekstrakSekarang.setText("Ekstrak Pesan Sekarang!");
        ekstrakSekarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekstrakSekarangActionPerformed(evt);
            }
        });

        simpanPesan.setText("Simpan");
        simpanPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanPesanActionPerformed(evt);
            }
        });

        statusSimpan.setText("<Status>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(pilihStego))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ekstrakSekarang)
                                    .addComponent(alamatStego))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(simpanPesan)
                        .addGap(204, 204, 204))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusSimpan)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pilihStego))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(alamatStego))
                .addGap(33, 33, 33)
                .addComponent(ekstrakSekarang)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(simpanPesan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusSimpan)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihStegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihStegoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
       
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            this.alamatStego.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_pilihStegoActionPerformed

    private void ekstrakSekarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekstrakSekarangActionPerformed
        try {
            // TODO add your handling code here:
            String teksAlamatStego = this.alamatStego.getText();
            BufferedImage stegoFile = ImageIO.read(new File(teksAlamatStego));
            this.ekstrak = new EkstrakStegfile(stegoFile);
            
            this.teksEkstrak.setText(this.ekstrak.ekstrakPesan());
        } catch (IOException ex) {
            Logger.getLogger(EkstrakForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ekstrakSekarangActionPerformed

    private void simpanPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanPesanActionPerformed
        // TODO add your handling code here:
        String alamatFolder="";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Pilih folder destinasi file .txt!");
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            alamatFolder = selectedFile.getAbsolutePath();
            
            try {
                FileWriter writer = new FileWriter(alamatFolder+"/PesanRahasia.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.write(this.teksEkstrak.getText());
                
                bufferedWriter.close();
                this.statusSimpan.setText("<Berhasil disimpan di: " + alamatFolder+"/PesanRahasia.txt>");
             } catch (IOException e) {
               this.statusSimpan.setText("<Gagal>"); 
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_simpanPesanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EkstrakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EkstrakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EkstrakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EkstrakForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EkstrakForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatStego;
    private javax.swing.JButton ekstrakSekarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pilihStego;
    private javax.swing.JButton simpanPesan;
    private javax.swing.JLabel statusSimpan;
    private javax.swing.JTextArea teksEkstrak;
    // End of variables declaration//GEN-END:variables
}