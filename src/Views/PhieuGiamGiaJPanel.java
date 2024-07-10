package Views;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Models.PhieuGiamGia.phieugiamgiaModel;
import Services.PhieuGiamGia.phieugiamgiaDAO;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Models.PhieuGiamGia.dieukienModel;
import Models.PhieuGiamGia.loaiphieuModel;
import Models.PhieuGiamGia.mucgiamModel;
import Models.PhieuGiamGia.trangthaiModel;
import Services.PhieuGiamGia.dieukienDAO;
import Services.PhieuGiamGia.loaiphieuDAO;
import Services.PhieuGiamGia.mucgiamDAO;
import Services.PhieuGiamGia.trangthaiDAO;

public class PhieuGiamGiaJPanel extends javax.swing.JPanel {

    phieugiamgiaDAO svc = new phieugiamgiaDAO();
    trangthaiDAO svc_tt = new trangthaiDAO();
    loaiphieuDAO svc_lp = new loaiphieuDAO();
    dieukienDAO svc_dk = new dieukienDAO();
    mucgiamDAO svc_mg = new mucgiamDAO();

    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel cbo = new DefaultComboBoxModel();

    public PhieuGiamGiaJPanel() {
        initComponents();
        this.fill();
        this.fillComboBoxLoaiPhieu();
        this.fillComboBoxDieuKien();
        lbl_huy.setVisible(false);
        this.fillComboBoxTrangThai();
        this.fillComboBoxMucGiam();
        this.fillDieuKien();
        this.fillLoaiPhieu();
        this.fillMucGiam();
        this.fillTrangThai();
    }

    private void fillComboBoxMucGiam() {
        cbo = (DefaultComboBoxModel) cbo_mamucgiam.getModel();
        cbo.removeAllElements();
        List<mucgiamModel> lst = svc_mg.selectAll();
        for (mucgiamModel mgm : lst) {
            cbo.addElement(mgm.getTyLeGiam());
        }
    }

    private void fillComboBoxTrangThai() {
        cbo = (DefaultComboBoxModel) cbo_matrangthai.getModel();
        cbo.removeAllElements();
        List<trangthaiModel> lst = svc_tt.selectAll();
        for (trangthaiModel ttm : lst) {
            cbo.addElement(ttm.getTenTrangThai());
        }
    }

    private void fillComboBoxDieuKien() {
        cbo = (DefaultComboBoxModel) cbo_dieukien.getModel();
        cbo.removeAllElements();
        List<dieukienModel> lst = svc_dk.selectAll();
        for (dieukienModel dkm : lst) {
            cbo.addElement(dkm.getTenDieuKien());
        }
    }

    private void fillComboBoxLoaiPhieu() {
        cbo = (DefaultComboBoxModel) cbo_loaiphieu.getModel();
        cbo.removeAllElements();
        List<loaiphieuModel> lst = svc_lp.selectAll();
        for (loaiphieuModel lpm : lst) {
            cbo.addElement(lpm.getTenLoaiPhieu());
        }
    }

    private void fill() {
        model = (DefaultTableModel) tbl_phieugiamgia.getModel();
        model.setRowCount(0);
        try {
            List<phieugiamgiaModel> lst = svc.selectAll();
            for (phieugiamgiaModel pgm : lst) {
                Object[] row = {pgm.getMaPhieuGiamGia(), pgm.getMaDieuKien(), pgm.getMaLoaiPhieu(), pgm.getMaMucGiam(), pgm.getMaTrangThai(), pgm.getNgayHetHan()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lỗi fill :((", "", HEIGHT);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_phieugiamgia = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_maphieu = new javax.swing.JTextField();
        cbo_loaiphieu = new javax.swing.JComboBox<>();
        cbo_dieukien = new javax.swing.JComboBox<>();
        txt_ngayhethan = new javax.swing.JTextField();
        cbo_mamucgiam = new javax.swing.JComboBox<>();
        cbo_matrangthai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txt_tim = new javax.swing.JTextField();
        btn_tim = new javax.swing.JButton();
        lbl_huy = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_trangthai = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_matrangthai = new javax.swing.JLabel();
        txt_tentrangthai = new javax.swing.JTextField();
        btn_themtrangthai = new javax.swing.JButton();
        btn_suatrangthai = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_loaiphieu = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_maloai = new javax.swing.JLabel();
        txt_tenloai = new javax.swing.JTextField();
        btn_themloaiphieu = new javax.swing.JButton();
        btn_sualoaiphieu = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_mucgiam = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_mucgiam = new javax.swing.JLabel();
        txt_mamucgiam = new javax.swing.JTextField();
        btn_themmucgiam = new javax.swing.JButton();
        btn_suamuciam = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_dieukien = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_dieukien = new javax.swing.JTextField();
        btn_suadieukien = new javax.swing.JButton();
        btn_themdieukien = new javax.swing.JButton();

        jLabel1.setText("Thiết lập phiếu giảm giá");

        tbl_phieugiamgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu", "Mã Điều Kiện", "Mã Loại", "Mã Mức Giảm", "Mã Trạng Thái", "Ngày Hết Hạn"
            }
        ));
        tbl_phieugiamgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_phieugiamgiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_phieugiamgia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab1.addTab("Danh sách", jPanel3);

        jLabel3.setText("Mã Phiếu");

        jLabel4.setText("Điều Kiện");

        jLabel5.setText("Loại Phiếu");

        jLabel6.setText("Ngày Hết Hạn");

        jLabel8.setText("Mã Trạng Thái");

        jLabel9.setText("Mã Mức Giảm");

        cbo_loaiphieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_dieukien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_mamucgiam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_matrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText(">>");

        jButton6.setText("<<");

        jButton7.setText("|<");

        jButton8.setText(">|");

        btn_tim.setText("Tìm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        lbl_huy.setText("Hủy");
        lbl_huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_huyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_maphieu)
                            .addComponent(cbo_loaiphieu, 0, 262, Short.MAX_VALUE)
                            .addComponent(cbo_dieukien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ngayhethan)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_mamucgiam, 0, 262, Short.MAX_VALUE)
                            .addComponent(cbo_matrangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jButton7)))
                    .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_tim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_huy)))
                .addContainerGap(592, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_loaiphieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_dieukien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)
                        .addComponent(jButton7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton8)))
                .addGap(18, 18, 18)
                .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_matrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_tim)
                        .addComponent(lbl_huy)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbo_mamucgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tab1.addTab("Cập nhật", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tab1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Thông tin phiếu giảm giá");

        tbl_trangthai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Trạng Thái", "Tên Trạng Thái"
            }
        ));
        jScrollPane5.setViewportView(tbl_trangthai);

        jLabel12.setText("Mã trạng thái");

        jLabel13.setText("Tên trạng thái");

        btn_themtrangthai.setText("Thêm");

        btn_suatrangthai.setText("Sửa");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tentrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_matrangthai)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_themtrangthai)
                        .addGap(31, 31, 31)
                        .addComponent(btn_suatrangthai)))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lbl_matrangthai))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tentrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themtrangthai)
                            .addComponent(btn_suatrangthai)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab2.addTab("Trạng thái", jPanel8);

        tbl_loaiphieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Loại", "Tên Loại"
            }
        ));
        jScrollPane2.setViewportView(tbl_loaiphieu);

        jLabel10.setText("Mã loại");

        jLabel11.setText("Tên loại");

        btn_themloaiphieu.setText("Thêm");

        btn_sualoaiphieu.setText("Sửa");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_maloai))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_themloaiphieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sualoaiphieu)))
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lbl_maloai))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txt_tenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themloaiphieu)
                            .addComponent(btn_sualoaiphieu)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab2.addTab("Loại phiếu", jPanel5);

        tbl_mucgiam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Mức Giảm", "Tỷ Lệ Giảm"
            }
        ));
        jScrollPane3.setViewportView(tbl_mucgiam);

        jLabel17.setText("Mã mức giảm");

        jLabel18.setText("Tỷ lệ giảm");

        btn_themmucgiam.setText("Thêm");

        btn_suamuciam.setText("Sửa");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_mucgiam))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txt_mamucgiam, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_themmucgiam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_suamuciam)))
                .addContainerGap(520, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lbl_mucgiam))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_mamucgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_suamuciam)
                            .addComponent(btn_themmucgiam))))
                .addGap(297, 297, 297))
        );

        tab2.addTab("Mức giảm", jPanel6);

        tbl_dieukien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Điều Kiện", "Tên Điều Kiện"
            }
        ));
        jScrollPane4.setViewportView(tbl_dieukien);

        jLabel14.setText("Mã điều kiện");

        jLabel15.setText("Tên điều kiện");

        btn_suadieukien.setText("Sửa");

        btn_themdieukien.setText("Thêm");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txt_dieukien, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel16))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btn_themdieukien)
                        .addGap(18, 18, 18)
                        .addComponent(btn_suadieukien)))
                .addContainerGap(501, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_dieukien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_suadieukien)
                            .addComponent(btn_themdieukien)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab2.addTab("Điều kiện", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tab2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            insertphieuGiamGia();
        } catch (ParseException ex) {
            Logger.getLogger(PhieuGiamGiaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updatephieuGiamGia() throws ParseException {
        phieugiamgiaModel phg = new phieugiamgiaModel();

        phg.setMaPhieuGiamGia(txt_maphieu.getText());

        phg.setMucGiam(1);

        String string = txt_ngayhethan.getText();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(string);
        phg.setNgayHetHan(date);

        if (cbo_matrangthai.getSelectedIndex() == 0) {
            phg.setTrangThai(true);
        } else {
            phg.setTrangThai(false);
        }

        phg.setMaLoaiPhieu(cbo_loaiphieu.getSelectedIndex() + 1);

        phg.setMaTrangThai(cbo_matrangthai.getSelectedIndex() + 1);

        phg.setMaMucGiam(cbo_mamucgiam.getSelectedIndex() + 1);

        phg.setMaDieuKien(cbo_dieukien.getSelectedIndex() + 1);

        svc.update(phg);
        this.fill();
        JOptionPane.showMessageDialog(this, "Sửa thành công!", "", WIDTH);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            updatephieuGiamGia();
        } catch (ParseException ex) {
            Logger.getLogger(PhieuGiamGiaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deletephieuGiamGia();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_phieugiamgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_phieugiamgiaMouseClicked
        try {
            editphieuGiamGia();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lmao");
        }
    }//GEN-LAST:event_tbl_phieugiamgiaMouseClicked

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed

        lbl_huy.setVisible(true);
        String maphieu = txt_tim.getText();
        svc.selectById(maphieu);
        this.fillKetQuaTimKiem();
        tab1.setSelectedIndex(0);

    }//GEN-LAST:event_btn_timActionPerformed

    private void lbl_huyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_huyMouseClicked
        this.fill();
        lbl_huy.setVisible(false);
    }//GEN-LAST:event_lbl_huyMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txt_maphieu.setText("");
        txt_ngayhethan.setText("");
        //txt_mucgiam.setText("");
        txt_maphieu.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fillKetQuaTimKiem() {
        model = (DefaultTableModel) tbl_phieugiamgia.getModel();
        model.setRowCount(0);
        try {
            String maphieu = txt_tim.getText();
            phieugiamgiaModel pgm = (phieugiamgiaModel) svc.selectById(maphieu);

            Object[] row = {pgm.getMaPhieuGiamGia(), pgm.getMaDieuKien(), pgm.getMaLoaiPhieu(), pgm.getMaMucGiam(), pgm.getMaTrangThai(), pgm.getNgayHetHan()};
            model.addRow(row);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lỗi fill :((", "", HEIGHT);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_suadieukien;
    private javax.swing.JButton btn_sualoaiphieu;
    private javax.swing.JButton btn_suamuciam;
    private javax.swing.JButton btn_suatrangthai;
    private javax.swing.JButton btn_themdieukien;
    private javax.swing.JButton btn_themloaiphieu;
    private javax.swing.JButton btn_themmucgiam;
    private javax.swing.JButton btn_themtrangthai;
    private javax.swing.JButton btn_tim;
    private javax.swing.JComboBox<String> cbo_dieukien;
    private javax.swing.JComboBox<String> cbo_loaiphieu;
    private javax.swing.JComboBox<String> cbo_mamucgiam;
    private javax.swing.JComboBox<String> cbo_matrangthai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbl_huy;
    private javax.swing.JLabel lbl_maloai;
    private javax.swing.JLabel lbl_matrangthai;
    private javax.swing.JLabel lbl_mucgiam;
    private javax.swing.JTabbedPane tab1;
    private javax.swing.JTabbedPane tab2;
    private javax.swing.JTable tbl_dieukien;
    private javax.swing.JTable tbl_loaiphieu;
    private javax.swing.JTable tbl_mucgiam;
    private javax.swing.JTable tbl_phieugiamgia;
    private javax.swing.JTable tbl_trangthai;
    private javax.swing.JTextField txt_dieukien;
    private javax.swing.JTextField txt_mamucgiam;
    private javax.swing.JTextField txt_maphieu;
    private javax.swing.JTextField txt_ngayhethan;
    private javax.swing.JTextField txt_tenloai;
    private javax.swing.JTextField txt_tentrangthai;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables

    private void fillDieuKien() {
        model = (DefaultTableModel) tbl_dieukien.getModel();
        model.setRowCount(0);
        try {
            List<dieukienModel> lst = svc_dk.selectAll();
            for (dieukienModel pgm : lst) {
                Object[] row = {pgm.getMaDieuKien(), pgm.getTenDieuKien()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lỗi fill :((", "", HEIGHT);
        }
    }

    private void fillLoaiPhieu() {
        model = (DefaultTableModel) tbl_loaiphieu.getModel();
        model.setRowCount(0);
        try {
            List<loaiphieuModel> lst = svc_lp.selectAll();
            for (loaiphieuModel pgm : lst) {
                Object[] row = {pgm.getMaLoaiPhieu(), pgm.getTenLoaiPhieu()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lỗi fill :((", "", HEIGHT);
        }
    }

    private void fillMucGiam() {
        model = (DefaultTableModel) tbl_mucgiam.getModel();
        model.setRowCount(0);
        try {
            List<mucgiamModel> lst = svc_mg.selectAll();
            for (mucgiamModel pgm : lst) {
                Object[] row = {pgm.getMaMucGiam(), pgm.getTyLeGiam()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lỗi fill :((", "", HEIGHT);
        }
    }

    private void fillTrangThai() {
        model = (DefaultTableModel) tbl_trangthai.getModel();
        model.setRowCount(0);
        try {
            List<trangthaiModel> lst = svc_tt.selectAll();
            for (trangthaiModel pgm : lst) {
                Object[] row = {pgm.getMaTrangThai(), pgm.getTenTrangThai()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "lỗi fill :((", "", HEIGHT);
        }
    }

    private void setModelphieuGiamGia(phieugiamgiaModel phg) {

        txt_maphieu.setText(phg.getMaPhieuGiamGia());

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        txt_ngayhethan.setText(sdf.format(phg.getNgayHetHan()));

        //txt_mucgiam.setText(String.valueOf(phg.getMucGiam()));

        cbo_loaiphieu.setSelectedIndex((int) tbl_phieugiamgia.getValueAt(tbl_phieugiamgia.getSelectedRow(), 2) - 1);

        cbo_dieukien.setSelectedIndex((int) tbl_phieugiamgia.getValueAt(tbl_phieugiamgia.getSelectedRow(), 1) - 1);

        cbo_matrangthai.setSelectedIndex((int) tbl_phieugiamgia.getValueAt(tbl_phieugiamgia.getSelectedRow(), 4) - 1);

        cbo_mamucgiam.setSelectedIndex((int) tbl_phieugiamgia.getValueAt(tbl_phieugiamgia.getSelectedRow(), 3) - 1);

    }

    private void insertphieuGiamGia() throws ParseException {
        phieugiamgiaModel phg = new phieugiamgiaModel();

        phg.setMaPhieuGiamGia(txt_maphieu.getText());

        phg.setMucGiam(1);

        String string = txt_ngayhethan.getText();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(string);
        phg.setNgayHetHan(date);

        if (cbo_matrangthai.getSelectedIndex() == 0) {
            phg.setTrangThai(true);
        } else {
            phg.setTrangThai(false);
        }

        phg.setMaLoaiPhieu(cbo_loaiphieu.getSelectedIndex() + 1);

        phg.setMaTrangThai(cbo_matrangthai.getSelectedIndex() + 1);

        phg.setMaMucGiam(cbo_mamucgiam.getSelectedIndex() + 1);

        phg.setMaDieuKien(cbo_dieukien.getSelectedIndex() + 1);

        svc.insert(phg);
        this.fill();
        JOptionPane.showMessageDialog(this, "Thêm thành công!", "", WIDTH);

    }

    private void deletephieuGiamGia() {
        int result = JOptionPane.showConfirmDialog(this, "Xác nhận xóa?", "", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String maphieu = txt_maphieu.getText();
            try {
                svc.delete(maphieu);
                this.fill();
                this.clearphieuGiamGia();
                JOptionPane.showMessageDialog(this, "Xóa thành công", "", WIDTH);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    private void clearphieuGiamGia() {
        txt_maphieu.setText("");
        txt_ngayhethan.setText("");
        //txt_mucgiam.setText("");
    }

    private void editphieuGiamGia() {
        try {
            String maphieu = (String) tbl_phieugiamgia.getValueAt(tbl_phieugiamgia.getSelectedRow(), 0);
            phieugiamgiaModel phg = svc.selectById(maphieu);
            if (phg != null) {
                this.setModelphieuGiamGia(phg);
                tab1.setSelectedIndex(1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi ko xác định :((", "", HEIGHT);
        }
    }
}
