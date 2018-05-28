package perc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Quiz extends javax.swing.JFrame {
    
    Client client ;
            
    ArrayList<Ques> question=new ArrayList();
    int length,i=0,ansr,pm,nm,score=0;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    Thread t ;
    
    public Quiz(){
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        jLabel6.setText("45 : 0");
        jLabel3.setText("0");
        jLabel4.setText("+0");
        jLabel5.setText("-0");
        
        t = new Thread(new Runnable() {
            
            @Override
            public void run() {
            
                try {
                    
                    for(int i=30; i>=0; i--)
                    {
                        t.sleep(1000);
                        jLabel6.setText((i/60)+" : "+(i%60));
                    }
                    if( i == 0 ) {
                        skip.disable();
                        submit.disable();
                    
                        t.sleep(1000);
                        JOptionPane.showMessageDialog(null,"Quiz Ended");
                        new FinalScore().setVisible(true);
                        disposer();
                        dispose();
              
                    }
              
                    
                } catch (InterruptedException ex) {
                        ex.printStackTrace();
                }
            
            
            }
        });
        
        t.start() ;
        
        
    }
    
   
    public Quiz(Client client){
        
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.client = client ;
        
        jLabel6.setText("90:00");
        jLabel3.setText("0");
        jLabel4.setText("+0");
        jLabel5.setText("-0");
        
        
        t = new Thread(new Runnable() {
            
            @Override
            public void run() {
            
                try {
                    
                    for(int i=5400; i>=0; i--)
                    {
                        t.sleep(1000);
                        jLabel6.setText((i/60)+" : "+(i%60));
                    }
                    
                    if( i == 0 ) {
                    
                        skip.disable();
                        submit.disable();
                        t.sleep(1000);
                        JOptionPane.showMessageDialog(null,"Quiz Ended");
                        new FinalScore(client, score, client.teamName, 0).setVisible(true);
                        disposer();
                        dispose();
              
                    }
                    
                } catch (InterruptedException ex) {
                        ex.printStackTrace();
                }
            
            
            }
        });
        
        t.start() ;
                
        question = client.getQuestions();
        populate(question.get(0));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        qarea = new javax.swing.JTextPane();
        opt1 = new javax.swing.JRadioButton();
        opt2 = new javax.swing.JRadioButton();
        opt3 = new javax.swing.JRadioButton();
        opt4 = new javax.swing.JRadioButton();
        submit = new javax.swing.JButton();
        skip = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        queid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qarea.setEditable(false);
        qarea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(qarea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 186, 1346, 290));

        opt1.setForeground(new java.awt.Color(255, 255, 255));
        opt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1ActionPerformed(evt);
            }
        });
        getContentPane().add(opt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        opt2.setForeground(new java.awt.Color(255, 255, 255));
        opt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2ActionPerformed(evt);
            }
        });
        getContentPane().add(opt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        opt3.setForeground(new java.awt.Color(255, 255, 255));
        opt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3ActionPerformed(evt);
            }
        });
        getContentPane().add(opt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        opt4.setForeground(new java.awt.Color(255, 255, 255));
        opt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4ActionPerformed(evt);
            }
        });
        getContentPane().add(opt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        submit.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        submit.setText("SUBMIT ANSWER");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 710, -1, 37));

        skip.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        skip.setText("SKIP QUESTION");
        skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipActionPerformed(evt);
            }
        });
        getContentPane().add(skip, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 710, 140, 35));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Question Number : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Score");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 15, 145, 85));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1249, 15, 82, 85));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setText("Positive Score");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1138, 113, 82, 63));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Negative Score");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1255, 113, 84, 63));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TIME LEFT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 154, 81));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1238, 113, 11, 63));

        queid.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        queid.setForeground(new java.awt.Color(255, 255, 255));
        queid.setText("jLabel8");
        getContentPane().add(queid, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 163, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perc/Dark-HD-Wallpapers-1080p.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        int flag=0;
        
        if((opt1.isSelected() && ansr==1) || (opt2.isSelected() && ansr==2) || (opt3.isSelected() && ansr==3) || (opt4.isSelected() && ansr==4)) {
            score=score+pm;
        }
        else if(!opt1.isSelected() && !opt2.isSelected() && !opt3.isSelected() && !opt4.isSelected()) {
            
            JOptionPane.showMessageDialog(null,"Please select an option");
            flag=1;
        
        }
        else {
            score=score-nm;
        }
        
        i++;
        
        jLabel3.setText(score+"");
        
        if(i==question.size()) {
            
            // int option = JOptionPane.showConfirmDialog(null,"Please select an option", "" , JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE , null);
            t.stop();
            JOptionPane.showMessageDialog(null,"Start CodeMaster");
            new CodeMasters(client,  client.teamName, score, getSeconds(jLabel6.getText())).setVisible(true);
            this.dispose();

        
        }
        else if(flag==1) {
        
            // question has been skipped so do nothing
            
        }
        else {
        
            populate(question.get(i));
        
        }
        
    }//GEN-LAST:event_submitActionPerformed

    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
        i++;
        
        if( i>=question.size() ) {
            
            //int option = JOptionPane.showConfirmDialog(null,"Quiz Ended", "" , JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE , null);
            //JOptionPane.showMessageDialog(null,"Quiz Ended");
            t.stop();
            JOptionPane.showMessageDialog(null,"Start CodeMaster");
            new CodeMasters(client,  client.teamName, score, getSeconds(jLabel6.getText())).setVisible(true);
            this.dispose();
        
        }
        else {
            
            populate(question.get(i));
            
//            skip.doClick();
        }
        
    }//GEN-LAST:event_skipActionPerformed

    private void opt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1ActionPerformed
        opt2.setSelected(false);
        opt3.setSelected(false);
        opt4.setSelected(false);
    }//GEN-LAST:event_opt1ActionPerformed

    private void opt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2ActionPerformed
        opt1.setSelected(false);
        opt3.setSelected(false);
        opt4.setSelected(false);
    }//GEN-LAST:event_opt2ActionPerformed

    private void opt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3ActionPerformed
        opt2.setSelected(false);
        opt1.setSelected(false);
        opt4.setSelected(false);
    }//GEN-LAST:event_opt3ActionPerformed

    private void opt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4ActionPerformed
        opt2.setSelected(false);
        opt3.setSelected(false);
        opt1.setSelected(false);
    }//GEN-LAST:event_opt4ActionPerformed

     public void populate(Ques q) {
         
        ansr=q.getans();
        pm=q.getposm();
        nm=q.getnegm();
        
        opt1.setSelected(false);
        opt2.setSelected(false);
        opt3.setSelected(false);
        opt4.setSelected(false);
        queid.setText((i+1)+"");
        qarea.setText(q.getprob());
        opt1.setText(q.getop1());
        opt2.setText(q.getop2());
        opt3.setText(q.getop3());
        opt4.setText(q.getop4()); 
        
        jLabel4.setText("+" + pm);
        jLabel5.setText("-" + nm);
    
    }
     
      void disposer()
    {
        this.dispose();
    }
    
    int getSeconds(String timeLeft)
    {
        int min, sec;
        String arr[]=new String[2];
        arr=timeLeft.split("\\:");
        arr[0]=arr[0].trim();
        arr[1]=arr[1].trim();
        min=Integer.parseInt(arr[0]);
        min*=60;
        sec=Integer.parseInt(arr[1])+min;
        return sec;
    }
    
    
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
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton opt1;
    private javax.swing.JRadioButton opt2;
    private javax.swing.JRadioButton opt3;
    private javax.swing.JRadioButton opt4;
    private javax.swing.JTextPane qarea;
    private javax.swing.JLabel queid;
    private javax.swing.JButton skip;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

    private String toString(int qid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
