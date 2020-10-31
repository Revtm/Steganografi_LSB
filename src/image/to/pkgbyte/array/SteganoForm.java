/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.to.pkgbyte.array;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JFileChooser;

/**
 *
 * @author revtm
 */
public class SteganoForm extends javax.swing.JFrame {
    private BuatStegfile buat;
    /**
     * Creates new form SteganoForm
     */
    public SteganoForm() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        teksPesan = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        pilihFileRahasia = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        pilihFleCover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        alamatCover = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        alamatRahasia = new javax.swing.JLabel();
        sisipPesan = new javax.swing.JButton();
        statusSisip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        teksPesan.setColumns(20);
        teksPesan.setRows(5);
        jScrollPane1.setViewportView(teksPesan);

        jLabel1.setText("Tulis pesan rahasia atau pilih file .txt");

        pilihFileRahasia.setText("Pilih File");
        pilihFileRahasia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihFileRahasiaActionPerformed(evt);
            }
        });

        jLabel3.setText("Pilih Gambar Cover untuk Disisipkan:");

        pilihFleCover.setText("Pilih File");
        pilihFleCover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihFleCoverActionPerformed(evt);
            }
        });

        jLabel2.setText("Alamat File: ");

        alamatCover.setText("/Alamat/file/cover.bmp");

        jLabel5.setText("Alamat File:");

        alamatRahasia.setText("Alamat/file/rahasia.txt");

        sisipPesan.setText("Sisipkan Sekarang!");
        sisipPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sisipPesanActionPerformed(evt);
            }
        });

        statusSisip.setText("<Status Penyisipan>");
        statusSisip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        statusSisip.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(pilihFileRahasia))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pilihFleCover))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(alamatCover))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(alamatRahasia)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(sisipPesan))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(statusSisip)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pilihFileRahasia))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(alamatRahasia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pilihFleCover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(alamatCover))
                .addGap(18, 18, 18)
                .addComponent(sisipPesan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusSisip)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihFileRahasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihFileRahasiaActionPerformed
        // TODO add your handling code here:
        String pesan="";
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            this.alamatRahasia.setText(selectedFile.getAbsolutePath());
            
            FileReader reader;
            try {
                reader = new FileReader(selectedFile.getAbsolutePath());
                BufferedReader bufferedReader = new BufferedReader(reader);
 
                String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                pesan = pesan + line + "\n";
                System.out.println(line);
            }
            this.teksPesan.setText(pesan);
            reader.close();
            
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_pilihFileRahasiaActionPerformed

    private void sisipPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sisipPesanActionPerformed
        // TODO add your handling code here:
        String alamatFileCover=this.alamatCover.getText();
        String alamatFolder="";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Pilih folder destinasi file!");
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            alamatFolder = selectedFile.getAbsolutePath();
            this.alamatRahasia.setText(selectedFile.getAbsolutePath());
            if(alamatFileCover != null && alamatFolder != ""){
                try {
                    BufferedImage cover = ImageIO.read(new File(alamatFileCover));
                    this.buat = new BuatStegfile(cover);
                    
                    if(this.buat.sisipPesan(this.teksPesan.getText(), alamatFolder)){
                        this.statusSisip.setText("<Berhasil disimpan di: " + alamatFolder + "/Stegofile.bmp>");
                    }else{
                        this.statusSisip.setText("<Gagal>");

                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(SteganoForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_sisipPesanActionPerformed

    private void pilihFleCoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihFleCoverActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
       
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            this.alamatCover.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_pilihFleCoverActionPerformed

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
            java.util.logging.Logger.getLogger(SteganoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SteganoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SteganoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SteganoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SteganoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatCover;
    private javax.swing.JLabel alamatRahasia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton pilihFileRahasia;
    private javax.swing.JButton pilihFleCover;
    private javax.swing.JButton sisipPesan;
    private javax.swing.JLabel statusSisip;
    private javax.swing.JTextArea teksPesan;
    // End of variables declaration//GEN-END:variables
}
