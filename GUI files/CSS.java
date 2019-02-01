
package minifierandpreprocessor;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
public class CSS extends javax.swing.JFrame {

    public CSS() {
        initComponents();
        continueBtn.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filePath = new javax.swing.JTextField();
        selectFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        continueBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSS Minifier and Preprocessor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        filePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathActionPerformed(evt);
            }
        });

        selectFile.setText("Attach");
        selectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel1.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel1.setText("Select a file to be read");

        continueBtn.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        continueBtn.setText("Continue");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectFile)
                                .addGap(18, 18, 18)
                                .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFile)
                    .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(continueBtn)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathActionPerformed
       
    }//GEN-LAST:event_filePathActionPerformed

    private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        int returnValue= chooser.showOpenDialog(this);
        if(returnValue==JFileChooser.APPROVE_OPTION){
            continueBtn.setEnabled(true);
            File f = chooser.getSelectedFile();
            String filename=f.getAbsolutePath();
            filePath.setText(filename);
        }
        else{
            filePath.setText("No file choosen");
        }
    }//GEN-LAST:event_selectFileActionPerformed

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
       dispose();
        if(CSS1.selectedRadioBtn==2){
            String str1=filePath.getText();
            preProcessorfinal p1 = new preProcessorfinal();
           try {
               p1.nesting(str1);
           } catch (Exception ex) {
               Logger.getLogger(CSS.class.getName()).log(Level.SEVERE, null, ex);
           }
           // combined.placeHold();
            new SCSS().setVisible(true);
       }
       else{
            String str1=filePath.getText();
           try {
               combined.minimizer(str1);
           } catch (Exception ex) {
               Logger.getLogger(CSS.class.getName()).log(Level.SEVERE, null, ex);
           }
	    //combined.placeHold();
            new MinifiedCSS().setVisible(true);
       }
    }//GEN-LAST:event_continueBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CSS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continueBtn;
    private javax.swing.JTextField filePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton selectFile;
    // End of variables declaration//GEN-END:variables
}
