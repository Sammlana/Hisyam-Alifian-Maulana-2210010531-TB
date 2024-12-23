
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import db.DatabaseConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class TransaksiFrame extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiFrame
     */
    public TransaksiFrame() {
        initComponents();
        loadComboBuku();
        loadComboPelanggan();
        setupEventHandlers();
    }

private void loadComboBuku() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id_buku, judul_buku FROM buku";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            cmbBuku.removeAllItems();
            while (rs.next()) {
                int id = rs.getInt("id_buku");
                String judul = rs.getString("judul_buku");
                cmbBuku.addItem(id + " - " + judul); // Format: "ID - Nama Buku"
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data buku: " + e.getMessage());
        }
    }

    private void loadComboPelanggan() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id_pelanggan, nama_pelanggan FROM pelanggan";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            cmbPelanggan.removeAllItems();
            while (rs.next()) {
                int id = rs.getInt("id_pelanggan");
                String nama = rs.getString("nama_pelanggan");
                cmbPelanggan.addItem(id + " - " + nama); // Format: "ID - Nama Pelanggan"
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data pelanggan: " + e.getMessage());
        }
    }

    private double getHargaBuku(int idBuku) {
        double harga = 0;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT harga FROM buku WHERE id_buku = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idBuku);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                harga = rs.getDouble("harga");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return harga;
    }
    
    private void setupEventHandlers() {
        jumlahBukuField.addActionListener(evt -> calculateTotal());
    }

    private void calculateTotal() {
        try {
            String selectedBuku = cmbBuku.getSelectedItem().toString();
            int idBuku = Integer.parseInt(selectedBuku.split(" - ")[0]); // Ambil ID dari combo box
            int jumlah = Integer.parseInt(jumlahBukuField.getText());
            double harga = getHargaBuku(idBuku);
            double totalHarga = jumlah * harga;
            jumlahBukuField1.setText(String.valueOf(totalHarga));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error menghitung total harga: " + e.getMessage());
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

        jLabel4 = new javax.swing.JLabel();
        jumlahBukuField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        cmbBuku = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbPelanggan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jumlahBukuField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setText("Data Pelanggan");

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Jumlah Buku");

        jButton4.setText("Cetak Laporan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cmbBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Buku");

        cmbPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Pelanggan");

        jLabel5.setText("Total Harga");

        jButton5.setText("Kembali Ke Menu Utama");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbBuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbPelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlahBukuField1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)
                                        .addGap(0, 124, Short.MAX_VALUE))
                                    .addComponent(jumlahBukuField))))))
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jumlahBukuField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jumlahBukuField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(290, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String selectedBuku = cmbBuku.getSelectedItem().toString();
        String selectedPelanggan = cmbPelanggan.getSelectedItem().toString();
        int idBuku = Integer.parseInt(selectedBuku.split(" - ")[0]);
        int idPelanggan = Integer.parseInt(selectedPelanggan.split(" - ")[0]);
        int jumlah = Integer.parseInt(jumlahBukuField.getText());
        double totalHarga = Double.parseDouble(jumlahBukuField1.getText());

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO transaksi_penjualan (id_buku, id_pelanggan, jumlah, total_harga, tanggal_transaksi) VALUES (?, ?, ?, ?, CURDATE())";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idBuku);
            ps.setInt(2, idPelanggan);
            ps.setInt(3, jumlah);
            ps.setDouble(4, totalHarga);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Membuka JFileChooser untuk memilih lokasi penyimpanan
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih lokasi untuk menyimpan laporan PDF");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setSelectedFile(new File("Laporan_Transaksi.pdf")); // Default file name

    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection != JFileChooser.APPROVE_OPTION) {
        JOptionPane.showMessageDialog(this, "Pembuatan laporan dibatalkan.");
        return; // Jika user batal memilih file
    }

    File fileToSave = fileChooser.getSelectedFile();
    String filePath = fileToSave.getAbsolutePath();

    // Menambahkan ekstensi .pdf jika belum ada
    if (!filePath.endsWith(".pdf")) {
        filePath += ".pdf";
    }

    try {
        // Membuat dokumen PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Menambahkan judul laporan
        document.add(new Paragraph("Laporan Transaksi Penjualan"));
        document.add(new Paragraph("====================================="));

        // Membuat tabel untuk laporan
        PdfPTable table = new PdfPTable(5); // 5 kolom: ID, Buku, Pelanggan, Jumlah, Total Harga
        table.setWidthPercentage(100); // Lebar tabel penuh
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Header tabel
        String[] header = {"ID Transaksi", "Buku", "Pelanggan", "Jumlah", "Total Harga"};
        for (String h : header) {
            PdfPCell headerCell = new PdfPCell(new Phrase(h));
            table.addCell(headerCell);
        }

        // Ambil data dari database
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT t.id_transaksi, b.judul_buku, p.nama_pelanggan, t.jumlah, t.total_harga " +
                           "FROM transaksi_penjualan t " +
                           "JOIN buku b ON t.id_buku = b.id_buku " +
                           "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                table.addCell(rs.getString("id_transaksi"));
                table.addCell(rs.getString("judul_buku"));
                table.addCell(rs.getString("nama_pelanggan"));
                table.addCell(String.valueOf(rs.getInt("jumlah")));
                table.addCell(String.format("%.2f", rs.getDouble("total_harga")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error mengambil data dari database: " + e.getMessage());
            return;
        }

        // Tambahkan tabel ke dokumen PDF
        document.add(table);

        // Tutup dokumen
        document.add(new Paragraph("Laporan selesai."));
        document.close();

        JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan di: " + filePath);

    } catch (DocumentException | java.io.IOException e) {
        JOptionPane.showMessageDialog(this, "Error membuat laporan: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        UtamaFrame utamaFrame = new UtamaFrame();
        utamaFrame.setVisible(true);
        dispose(); // Tutup frame transaksi
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuku;
    private javax.swing.JComboBox<String> cmbPelanggan;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jumlahBukuField;
    private javax.swing.JTextField jumlahBukuField1;
    // End of variables declaration//GEN-END:variables
}
