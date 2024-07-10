/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Models.KhachHang.KhachHang;
import Models.KhachHang.LichSuGiaoDich;
import Models.KhachHang.TichDiemKH;
import Services.KhachHang.KhachHangDAO;
import Services.KhachHang.LichSuGiaoDichDAO;
import Services.KhachHang.TichDiemDAO;
import Utilities.DBcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VU ANH TAI
 */
public class KhachHangJPanel extends javax.swing.JPanel {

    /**
     * Creates new form KhachHangJPanel
     */
    public KhachHangJPanel() {
        initComponents();
        fillTable();
        fillTableLichSu();
        filltabletichdiem();
    }

    ///////////Giao dien khach Hang
    DefaultTableModel model = new DefaultTableModel();
    KhachHangDAO dao = new KhachHangDAO();
    KhachHang kh = new KhachHang();

    public void fillTable() {
        model = (DefaultTableModel) tbBangKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> lst = dao.getAllKhachHang();
        for (KhachHang kh : lst) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isHangKhach() ? "Lâu năm" : "Mới"});
        }

    }

    public KhachHang getModel() {
        KhachHang kh = new KhachHang();

        kh.setTenKhachHang(txtTenKhachHang.getText());

        if (rdoNam.isSelected()) {
            kh.setGioiTinh(true);
        } else {
            kh.setGioiTinh(false);
        }
        kh.setSdt(txtSoDt.getText());
        kh.setEmail(txtEmail.getText());
        kh.setDiaChi(txtDiaChi.getText());
        if (rdolauNam.isSelected()) {
            kh.setHangKhach(true);
        } else {
            kh.setHangKhach(false);
        }

        return kh;
    }

    public KhachHang getModelUpdate() {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(Integer.parseInt(txtMaKhachHang.getText()));
        kh.setTenKhachHang(txtTenKhachHang.getText());

        if (rdoNam.isSelected()) {
            kh.setGioiTinh(true);
        } else {
            kh.setGioiTinh(false);
        }
        kh.setSdt(txtSoDt.getText());
        kh.setEmail(txtEmail.getText());
        kh.setDiaChi(txtDiaChi.getText());
        if (rdolauNam.isSelected()) {
            kh.setHangKhach(true);
        } else {
            kh.setHangKhach(false);
        }

        return kh;
    }

    
    public void setModel(KhachHang kh) {
        System.out.println(kh);
        txtMaKhachHang.setText(kh.getMaKhachHang() + "");
        txtTenKhachHang.setText(kh.getTenKhachHang());
        if (kh.isGioiTinh() == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtSoDt.setText(kh.getSdt() + "");
        txtEmail.setText(kh.getEmail());
        txtDiaChi.setText(kh.getDiaChi());
        if (kh.isHangKhach() == true) {
            rdolauNam.setSelected(true);
        } else {
            rdoMoi.setSelected(true);
        }
    }

    public void reset() {
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        buttonGroup1.clearSelection();
        txtSoDt.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        buttonGroup2.clearSelection();
    }

    public boolean checkform() {
        if (txtMaKhachHang.getText().isEmpty() || txtTenKhachHang.getText().isEmpty() || txtSoDt.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ thông tin");
            return false;
        }
        try {
            int so = Integer.parseInt(txtSoDt.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "số điện thoại phải là số");
            return false;
        }
        if (txtSoDt.getText().length() < 10 || txtSoDt.getText().length() > 11) {
            JOptionPane.showMessageDialog(this, "SDT thì 10 hoặc 11 số ");
            return false;
        }
        return true;
    }

    public void fillTableKhachHangNam() {
        model = (DefaultTableModel) tbBangKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> lst = dao.getAllKhachHangNam();
        for (KhachHang kh : lst) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isHangKhach() ? "Lâu năm" : "Mới"});
        }

    }

    public void fillTableKhachHangNu() {
        model = (DefaultTableModel) tbBangKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> lst = dao.getAllKhachHangNu();
        for (KhachHang kh : lst) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isHangKhach() ? "Lâu năm" : "Mới"});
        }

    }

    public void fillTableKhachHangLauNam() {
        model = (DefaultTableModel) tbBangKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> lst = dao.getAllHangKhachLaunam();
        for (KhachHang kh : lst) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isHangKhach() ? "Lâu năm" : "Mới"});
        }

    }

    public void fillTableKhachHangMoi() {
        model = (DefaultTableModel) tbBangKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> lst = dao.getAllHangKhachMoi();
        for (KhachHang kh : lst) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isHangKhach() ? "Lâu năm" : "Mới"});
        }

    }

    ///////////lich su giao dich
    LichSuGiaoDichDAO lsdao = new LichSuGiaoDichDAO();

    public void fillTableLichSu() {

        model = (DefaultTableModel) tbBangLichSu.getModel();
        model.setRowCount(0);
        ArrayList<LichSuGiaoDich> lst = lsdao.getAllLichSuGiaoDich();
        for (LichSuGiaoDich ls : lst) {
            model.addRow(new Object[]{ls.getTenKH(), ls.getTenSp(), ls.getSdt(), ls.getSoLuong(),
                ls.getTongTien(), ls.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    /////////tich diem
    TichDiemDAO tddao = new TichDiemDAO();

    public void filltabletichdiem() {
        model = (DefaultTableModel) tbTichDiem.getModel();
        model.setRowCount(0);
        ArrayList<TichDiemKH> lst = tddao.getAllTichDiem();
        for (TichDiemKH td : lst) {
            model.addRow(new Object[]{td.getTenKH(), td.getTongDiem(), td.getDiemDaDung(), td.getDiemConLai(),
                td.isHangKhach() ? "Lâu năm" : "Mới"});
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDt = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSUa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rdolauNam = new javax.swing.JRadioButton();
        rdoMoi = new javax.swing.JRadioButton();
        tabs = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBangKhachHang = new javax.swing.JTable();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiemKH = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBangLichSu = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txtTimKiemLichSu = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTichDiem = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết lập thông tin khách hàng"));

        jLabel2.setText("Mã Khách hàng");

        jLabel3.setText("Tên Khách hàng");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Số điện thoại");

        jLabel7.setText("Email");

        txtMaKhachHang.setEditable(false);

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSUa.setText("Sửa");
        btnSUa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSUaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jLabel8.setText("Hạng Khách");

        buttonGroup2.add(rdolauNam);
        rdolauNam.setText("Lâu năm");
        rdolauNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdolauNamActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoMoi);
        rdoMoi.setText("Mới");
        rdoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rdolauNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addComponent(txtTenKhachHang))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(txtSoDt)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSUa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnSUa)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdolauNam)
                            .addComponent(rdoMoi)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnMoi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tabs.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        tbBangKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Giới tính", "sdt", "Email", "địa chỉ", "Hạng Khách"
            }
        ));
        tbBangKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBangKhachHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbBangKhachHangMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbBangKhachHang);

        btnDau.setText("|<");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLui.setText("<<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnTien.setText(">>");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        btnCuoi.setText(">|");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        jLabel1.setText("Giới Tính ");

        jLabel9.setText("Hạng Khách");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Lâu năm", "Mới" }));
        cboTrangThai.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cboTrangThaiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));
        cboGioiTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGioiTinhItemStateChanged(evt);
            }
        });
        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        txtTimKiemKH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemKHCaretUpdate(evt);
            }
        });
        txtTimKiemKH.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTimKiemKHPropertyChange(evt);
            }
        });
        txtTimKiemKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(txtTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnDau)
                .addGap(18, 18, 18)
                .addComponent(btnLui)
                .addGap(18, 18, 18)
                .addComponent(btnTien)
                .addGap(26, 26, 26)
                .addComponent(btnCuoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDau)
                    .addComponent(btnLui)
                    .addComponent(btnTien)
                    .addComponent(btnCuoi))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        tabs.addTab("Thông tin cá nhân", jPanel5);

        tbBangLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên khách hàng", "Tên sản phẩm", "SDT", "Số lượng", "Tổng tiền", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tbBangLichSu);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        txtTimKiemLichSu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemLichSuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(txtTimKiemLichSu)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(txtTimKiemLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tabs.addTab("Lịch sử giao dịch", jPanel8);

        tbTichDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên khách hàng", "Tổng điểm tích lũy", "Điểm đã dùng", "Điểm còn lại", "hạng khách"
            }
        ));
        jScrollPane4.setViewportView(tbTichDiem);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        tabs.addTab("Tích điểm", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (checkform()) {
            dao.insert(getModel());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTable();
            reset();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSUaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSUaActionPerformed
        if (checkform()) {
            dao.update(getModelUpdate());
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillTable();
            reset();
        }
    }//GEN-LAST:event_btnSUaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        reset();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void rdolauNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdolauNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdolauNamActionPerformed

    private void rdoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoMoiActionPerformed

    ////bảng lịch sử giao dịch

    ArrayList<LichSuGiaoDich> arr = new ArrayList<>();

    public void fillArrayListLichSu() {

        model = (DefaultTableModel) tbBangLichSu.getModel();
        model.setRowCount(0);

        for (LichSuGiaoDich ls : arr) {
            model.addRow(new Object[]{ls.getTenKH(), ls.getTenSp(), ls.getSdt(), ls.getSoLuong(),
                ls.getTongTien(), ls.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    public void Lichsu() {

        tabs.setSelectedIndex(1);

        arr.clear();
        try {
            Connection cn = DBcontext.getConnection();
            String sql = "select TenKhachHang,TenSanPham,SDT,KHACHHANG_LICHSUMUAHANG.soLuong,tongTien,ThanhToan\n"
                    + "from KhachHang join KHACHHANG_LICHSUMUAHANG on KhachHang.MaTraCuuLichSu = KHACHHANG_LICHSUMUAHANG.MaTraCuuLichSu\n"
                    + "				join SanPham on KHACHHANG_LICHSUMUAHANG.MaSanPham = SanPham.MaSanPham\n"
                    + "where IDKhachHang = '" + txtMaKhachHang.getText() + "'";

            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                LichSuGiaoDich ls = new LichSuGiaoDich(rs.getString("TenKhachHang"), rs.getString("TenSanPham"),
                        rs.getString("SDT"), rs.getFloat("soLuong"), rs.getFloat("tongTien"), rs.getBoolean("ThanhToan"));
                arr.add(ls);
            }
            cn.close();
            fillArrayListLichSu();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //// bảng tích điểm
    ArrayList<TichDiemKH> brr = new ArrayList<>();

    public void fillArrayListTichDiem() {

        model = (DefaultTableModel) tbTichDiem.getModel();
        model.setRowCount(0);

        for (TichDiemKH td : brr) {
            model.addRow(new Object[]{td.getTenKH(), td.getTongDiem(), td.getDiemDaDung(), td.getDiemConLai(),
                td.isHangKhach() ? "Lâu năm" : "Mới"});
        }
    }

    public void TichDiem() {

        brr.clear();
        try {
            Connection cn = DBcontext.getConnection();
            String sql = "select TenKhachHang,TongDiemTichLuy,DiemDaDung,DiemConLai,hangKhach\n"
                    + "from  KhachHang join KHACHHANG_TICHDIEM on KhachHang.MaTichDiemKH = KHACHHANG_TICHDIEM.MaTichDiemKH\n"
                    + "where IDKhachHang ='"+txtMaKhachHang.getText()+"'";

            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                TichDiemKH td = new TichDiemKH(rs.getString("TenKhachHang"), rs.getInt("TongDiemTichLuy"),
                        rs.getInt("DiemDaDung"), rs.getInt("DiemConLai"), rs.getBoolean("hangKhach"));
                brr.add(td);
            }
            cn.close();
            fillArrayListTichDiem();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void tbBangKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBangKhachHangMouseClicked
        int row = tbBangKhachHang.getSelectedRow();
        try {
            setModel(dao.getAllKhachHang().get(row));
            Lichsu();
            TichDiem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbBangKhachHangMouseClicked

    private void tbBangKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBangKhachHangMousePressed

    }//GEN-LAST:event_tbBangKhachHangMousePressed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        setModel(dao.getAllKhachHang().get(0));
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        int row = dao.find(Integer.parseInt(txtMaKhachHang.getText()));
        if (row == 0) {
            setModel(dao.getAllKhachHang().get(dao.getAllKhachHang().size() - 1));
        } else {
            setModel(dao.getAllKhachHang().get(row - 1));
        }
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        int row = dao.find(Integer.parseInt(txtMaKhachHang.getText()));
        if (row == dao.getAllKhachHang().size() - 1) {
            setModel(dao.getAllKhachHang().get(0));
        } else {
            setModel(dao.getAllKhachHang().get(row + 1));
        }
    }//GEN-LAST:event_btnTienActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        setModel(dao.getAllKhachHang().get(dao.getAllKhachHang().size() - 1));
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void cboTrangThaiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cboTrangThaiAncestorAdded

    }//GEN-LAST:event_cboTrangThaiAncestorAdded

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        String trangThai = (String) cboTrangThai.getSelectedItem();
        if (trangThai.equalsIgnoreCase("Lâu năm")) {
            fillTableKhachHangLauNam();

        } else if (trangThai.equalsIgnoreCase("Mới")) {
            fillTableKhachHangMoi();

        } else {
            fillTable();

        }
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void cboGioiTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGioiTinhItemStateChanged

    }//GEN-LAST:event_cboGioiTinhItemStateChanged

    private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhActionPerformed
        String gioiTinh = (String) cboGioiTinh.getSelectedItem();
        if (gioiTinh.equalsIgnoreCase("Nam")) {
            fillTableKhachHangNam();

        } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
            fillTableKhachHangNu();

        } else {
            fillTable();

        }
    }//GEN-LAST:event_cboGioiTinhActionPerformed

    private void txtTimKiemKHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemKHCaretUpdate
        //fillTableTimKiem();
    }//GEN-LAST:event_txtTimKiemKHCaretUpdate

    private void txtTimKiemKHPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTimKiemKHPropertyChange

        System.out.println(txtTimKiemKH.getText());
        //cho tôi code ví dụ về JTextField DocumentListener
    }//GEN-LAST:event_txtTimKiemKHPropertyChange

     ArrayList<KhachHang> lst = new ArrayList<>();

    public void fillTableArrayList() {
        model = (DefaultTableModel) tbBangKhachHang.getModel();
        model.setRowCount(0);

        for (KhachHang kh : lst) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.isGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(), kh.getEmail(), kh.getDiaChi(), kh.isHangKhach() ? "Lâu năm" : "Mới"});
        }

    }
    private void txtTimKiemKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKHKeyReleased

        lst.clear();
        try {
            Connection cn = DBcontext.getConnection();
            String sql = "select IDKhachHang,TenKhachHang,GioiTinh,SDT,Email,diaChi,hangKhach\n"
            + "from KhachHang\n"
            + "where SDT like '%" + txtTimKiemKH.getText() + "%'";

            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
                    rs.getBoolean("GioiTinh"), rs.getString("SDT"),
                    rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
                lst.add(kh);
            }
            cn.close();
            fillTableArrayList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemKHKeyReleased

    private void txtTimKiemLichSuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemLichSuKeyReleased
        arr.clear();
        try {
            Connection cn = DBcontext.getConnection();
            String sql = "select TenKhachHang,TenSanPham,SDT,KHACHHANG_LICHSUMUAHANG.soLuong,tongTien,ThanhToan\n"
            + "from KhachHang join KHACHHANG_LICHSUMUAHANG on KhachHang.MaTraCuuLichSu = KHACHHANG_LICHSUMUAHANG.MaTraCuuLichSu\n"
            + "				join SanPham on KHACHHANG_LICHSUMUAHANG.MaSanPham = SanPham.MaSanPham\n"
            + "where SDT like '%" + txtTimKiemLichSu.getText() + "%'";

            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                LichSuGiaoDich ls = new LichSuGiaoDich(rs.getString("TenKhachHang"), rs.getString("TenSanPham"),
                    rs.getString("SDT"), rs.getFloat("soLuong"), rs.getFloat("tongTien"), rs.getBoolean("ThanhToan"));
                arr.add(ls);
            }
            cn.close();
            fillArrayListLichSu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemLichSuKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSUa;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTien;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboTrangThai;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rdoMoi;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdolauNam;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbBangKhachHang;
    private javax.swing.JTable tbBangLichSu;
    private javax.swing.JTable tbTichDiem;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDt;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiemKH;
    private javax.swing.JTextField txtTimKiemLichSu;
    // End of variables declaration//GEN-END:variables
}
