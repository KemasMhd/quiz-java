/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class formEntriMatakuliah extends javax.swing.JFrame {
    String driver = "com.mysql.cj.jdbc.Driver";
    String db = "jdbc:mysql://localhost/akademik22081012";
    String user = "root";
    String password = "";
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form formEntriMatakuliah
     */
    public formEntriMatakuliah() {
        initComponents();
    }
    
    void entriData(String kode_matkul, String nama_matkul, int sks){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "INSERT INTO matakuliah(kode_matakuliah, nama_matakuliah, sks) VALUES"+"('"+kode_matkul+"','"+nama_matkul+"','"+sks+"')";
            stmt.executeUpdate(query);
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    int getJumlahData(ResultSet x){
        int n = 0;
        try{
            x.last();
            n = x.getRow();
            x.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        return n;
    }
    
    void tampilData(){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String query = "SELECT * FROM matakuliah";
            ResultSet rs = stmt.executeQuery(query);
            
            int jumbaris = getJumlahData(rs);
            String[]titleKolom = {"Kode Matakuliah", "Nama Matakuliah", "SKS"};
            String[][]datamatakuliah = new String [jumbaris][3];
            int index = 0;
            
            rs = stmt.executeQuery(query);
            while(rs.next()){
                datamatakuliah[index][0] = rs.getString("kode_matakuliah");
                datamatakuliah[index][1] = rs.getString("nama_matakuliah");
                datamatakuliah[index][2] = rs.getString("sks");
                index++;
            }
            model.setDataVector(datamatakuliah, titleKolom);
            tabelMatakuliah22081012.setModel(model);
            rs.close();
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    void cariData(String kode_matkul){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM matakuliah where kode_matakuliah='"+kode_matkul+"'";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                txtKodeMatakuliah22081012.setText(rs.getString("kode_matakuliah"));
                txtNamaMatakuliah22081012.setText(rs.getString("nama_matakuliah"));
                txtSKS22081012.setText(rs.getString("sks"));
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    void ubahData(String kode_matkul, String nama_matkul, int sks){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "UPDATE matakuliah set nama_matakuliah='"+nama_matkul+"',sks='"+sks+"'WHERE kode_matakuliah='"+kode_matkul+"'";
            stmt.executeUpdate(query);
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    void hapusData(String kode_matkul){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "DELETE FROM matakuliah WHERE kode_matakuliah='"+kode_matkul+"'";
            stmt.executeUpdate(query);
            
//            rs.close();
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKodeMatakuliah22081012 = new javax.swing.JTextField();
        txtNamaMatakuliah22081012 = new javax.swing.JTextField();
        txtSKS22081012 = new javax.swing.JTextField();
        tombolSimpan22081012 = new javax.swing.JButton();
        tombolUbah22081012 = new javax.swing.JButton();
        tombolCari22081012 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMatakuliah22081012 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("FORM ENTRI DATA MATAKULIAH");

        jLabel2.setText("Kode Matakuliah");

        jLabel3.setText("Nama Matakuliah");

        jLabel4.setText("SKS");

        tombolSimpan22081012.setText("SIMPAN");
        tombolSimpan22081012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpan22081012ActionPerformed(evt);
            }
        });

        tombolUbah22081012.setText("UBAH");
        tombolUbah22081012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbah22081012ActionPerformed(evt);
            }
        });

        tombolCari22081012.setText("CARI");
        tombolCari22081012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCari22081012ActionPerformed(evt);
            }
        });

        jButton4.setText("HAPUS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("TAMPIL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tabelMatakuliah22081012.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Matakuliah", "Nama Matakuliah", "SKS"
            }
        ));
        jScrollPane1.setViewportView(tabelMatakuliah22081012);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(tombolSimpan22081012)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNamaMatakuliah22081012)
                        .addGap(173, 173, 173))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKodeMatakuliah22081012, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSKS22081012, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tombolUbah22081012)
                                .addGap(18, 18, 18)
                                .addComponent(tombolCari22081012)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)))
                        .addGap(0, 40, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeMatakuliah22081012, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaMatakuliah22081012, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtSKS22081012, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombolSimpan22081012)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tombolCari22081012)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(tombolUbah22081012)))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpan22081012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpan22081012ActionPerformed
        // TODO add your handling code here:
        try{
            String kode_matkul = txtKodeMatakuliah22081012.getText();
            String nama_matkul = txtNamaMatakuliah22081012.getText();
            int sks = Integer.parseInt(txtSKS22081012.getText());
            entriData(kode_matkul, nama_matkul, sks);
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolSimpan22081012ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            tampilData();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tombolCari22081012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCari22081012ActionPerformed
        // TODO add your handling code here:
        try{
            if(!txtKodeMatakuliah22081012.getText().isEmpty()){
                String nim=txtKodeMatakuliah22081012.getText();
                cariData(nim);
            } else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "silahkan masukkan Kode Matakuliah yang ingin dicari!");
            }
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolCari22081012ActionPerformed

    private void tombolUbah22081012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbah22081012ActionPerformed
        // TODO add your handling code here:
        try{
            String kode_matkul = txtKodeMatakuliah22081012.getText();
            String nama_matkul = txtNamaMatakuliah22081012.getText();
            int sks = Integer.parseInt(txtSKS22081012.getText());
            
            ubahData(kode_matkul, nama_matkul, sks);
            tampilData();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolUbah22081012ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            if(!txtKodeMatakuliah22081012.getText().isEmpty()){
            String kode_matkul =txtKodeMatakuliah22081012.getText();
            hapusData(kode_matkul);
            } else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "silahkan masukkan kode matakuliah yang ingin dihapus!");
            }
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(formEntriMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formEntriMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formEntriMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formEntriMatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formEntriMatakuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMatakuliah22081012;
    private javax.swing.JButton tombolCari22081012;
    private javax.swing.JButton tombolSimpan22081012;
    private javax.swing.JButton tombolUbah22081012;
    private javax.swing.JTextField txtKodeMatakuliah22081012;
    private javax.swing.JTextField txtNamaMatakuliah22081012;
    private javax.swing.JTextField txtSKS22081012;
    // End of variables declaration//GEN-END:variables
}
