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
public class formEntriMahasiswa extends javax.swing.JFrame {
    String driver = "com.mysql.cj.jdbc.Driver";
    String db = "jdbc:mysql://localhost/akademik22081012";
    String user = "root";
    String password = "";
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form formEntriMahasiswa
     */
    public formEntriMahasiswa() {
        initComponents();
    }

    void entriData(String nim, String nama, String jurusan){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "INSERT INTO mahasiswa(nim, nama, jurusan) VALUES"+"('"+nim+"','"+nama+"','"+jurusan+"')";
            stmt.executeUpdate(query);
            con.close();
            
//            String query = "INSERT INTO mahasiswa(nim, nama, jurusan, ) VALUES "+"(?, ?, ?)";
//            try(PreparedStatement pstmt = con.prepareStatement(query)){
//                pstmt.setString(1, nim);
//                pstmt.setString(2, nama);
//                pstmt.setString(3, jurusan);
//                pstmt.executeUpdate();
//            }
//            con.close();
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
            
            String query = "SELECT * FROM mahasiswa";
            ResultSet rs = stmt.executeQuery(query);
            
            int jumbaris = getJumlahData(rs);
            String[]titleKolom = {"NIM", "NAMA", "JURUSAN"};
            String[][]datamahasiswa = new String [jumbaris][3];
            int index = 0;
            
            rs = stmt.executeQuery(query);
            while(rs.next()){
                datamahasiswa[index][0] = rs.getString("nim");
                datamahasiswa[index][1] = rs.getString("nama");
                datamahasiswa[index][2] = rs.getString("jurusan");
                index++;
            }
            model.setDataVector(datamahasiswa, titleKolom);
            tabelMahasiswa22081012.setModel(model);
            rs.close();
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    
    void cariData(String nim){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM mahasiswa where nim='"+nim+"'";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                txtNIM22081012.setText(rs.getString("nim"));
                txtNama22081012.setText(rs.getString("nama"));
                txtJurusan22081012.setText(rs.getString("jurusan"));
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    void ubahData(String nim, String nama, String jurusan){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "UPDATE mahasiswa set nama='"+nama+"',jurusan='"+jurusan+"'WHERE nim='"+nim+"'";
            stmt.executeUpdate(query);
            con.close();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    void hapusData(String nim){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement();
            String query = "DELETE FROM mahasiswa WHERE nim='"+nim+"'";
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
        txtNIM22081012 = new javax.swing.JTextField();
        txtNama22081012 = new javax.swing.JTextField();
        txtJurusan22081012 = new javax.swing.JTextField();
        tombolSimpan = new javax.swing.JButton();
        tombolCari = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolTampil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMahasiswa22081012 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("FORM ENTRI DATA MAHASISWA");

        jLabel2.setText("NIM");

        jLabel3.setText("NAMA");

        jLabel4.setText("JURUSAN");

        tombolSimpan.setText("SIMPAN");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolCari.setText("CARI");
        tombolCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCariActionPerformed(evt);
            }
        });

        tombolUbah.setText("UBAH");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolHapus.setText("HAPUS");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolTampil.setText("TAMPIL");
        tombolTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTampilActionPerformed(evt);
            }
        });

        tabelMahasiswa22081012.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIM", "NAMA", "JURUSAN"
            }
        ));
        jScrollPane1.setViewportView(tabelMahasiswa22081012);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNIM22081012, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolTampil))
                            .addComponent(txtNama22081012)
                            .addComponent(txtJurusan22081012)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNIM22081012, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama22081012, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJurusan22081012, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolCari)
                    .addComponent(tombolUbah)
                    .addComponent(tombolHapus)
                    .addComponent(tombolTampil))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        try{
            String nim = txtNIM22081012.getText();
            String nama = txtNama22081012.getText();
            String jurusan = txtJurusan22081012.getText();
            entriData(nim, nama, jurusan);
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTampilActionPerformed
        // TODO add your handling code here:
        try{
            tampilData();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolTampilActionPerformed

    private void tombolCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariActionPerformed
        // TODO add your handling code here:
        try{
            if(!txtNIM22081012.getText().isEmpty()){
                String nim=txtNIM22081012.getText();
                cariData(nim);
            } else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "silahkan masukkan nim mahasiswa yang ingin dicari!");
            }
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolCariActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        try{
            String nim = txtNIM22081012.getText();
            String nama = txtNama22081012.getText();
            String jurusan = txtJurusan22081012.getText();
            
            ubahData(nim, nama, jurusan);
            tampilData();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        try{
            if(!txtNIM22081012.getText().isEmpty()){
            String nim =txtNIM22081012.getText();
            hapusData(nim);
            } else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "silahkan masukkan nim mahasiswa yang ingin dihapus!");
            }
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_tombolHapusActionPerformed

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
            java.util.logging.Logger.getLogger(formEntriMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formEntriMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formEntriMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formEntriMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formEntriMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMahasiswa22081012;
    private javax.swing.JButton tombolCari;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolTampil;
    private javax.swing.JButton tombolUbah;
    private javax.swing.JTextField txtJurusan22081012;
    private javax.swing.JTextField txtNIM22081012;
    private javax.swing.JTextField txtNama22081012;
    // End of variables declaration//GEN-END:variables
}
