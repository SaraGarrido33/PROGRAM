/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

/**
 *
 * @author DM3-1-16
 */
public class CreateTeam extends javax.swing.JFrame {

    /**
     * Creates new form CreateTeam
     */
    public CreateTeam() {
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

        TextName = new javax.swing.JLabel();
        NameTeam = new javax.swing.JTextField();
        Textnumplayers = new javax.swing.JLabel();
        TextDniCoach = new javax.swing.JLabel();
        NumOfPlayers = new javax.swing.JTextField();
        DniCoach = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextName.setText("Name of the team:");

        NameTeam.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        Textnumplayers.setText("Number of players:");

        TextDniCoach.setText("DNI of the coach:");

        NumOfPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumOfPlayersActionPerformed(evt);
            }
        });

        DniCoach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DniCoachActionPerformed(evt);
            }
        });

        create.setText("Create");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Create a team");

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete)
                .addGap(18, 18, 18)
                .addComponent(create)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Textnumplayers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(NumOfPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(TextDniCoach)
                .addGap(18, 18, 18)
                .addComponent(DniCoach, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextName)
                        .addGap(18, 18, 18)
                        .addComponent(NameTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NameTeam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textnumplayers)
                    .addComponent(NumOfPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextDniCoach)
                    .addComponent(DniCoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(Exit)
                    .addComponent(delete))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DniCoachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DniCoachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DniCoachActionPerformed

    private void NumOfPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumOfPlayersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumOfPlayersActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        //Borrar todo el texto
        NameTeam.setText("");
        NumOfPlayers.setText("");
        DniCoach.setText("");
    }//GEN-LAST:event_deleteActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);//cerrar aplicacion
    }//GEN-LAST:event_ExitActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField DniCoach;
    private javax.swing.JButton Exit;
    public javax.swing.JTextField NameTeam;
    public javax.swing.JTextField NumOfPlayers;
    private javax.swing.JLabel TextDniCoach;
    private javax.swing.JLabel TextName;
    private javax.swing.JLabel Textnumplayers;
    public javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
