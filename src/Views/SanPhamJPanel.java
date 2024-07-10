package Views;



import Models.SanPham.ChatLieu;
import Models.SanPham.NhaCungCap;
import Models.SanPham.SanPham;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Models.SanPham.ShareHelper1;
import Models.SanPham.TheLoai;
import Services.SanPham.ChatLieu_Service;
import Services.SanPham.NhaCungCap_Service;
import Services.SanPham.SanPham_service;
import Services.SanPham.TheLoai_Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class SanPhamJPanel extends javax.swing.JPanel {
    private final NhaCungCap_Service daoNcc = new NhaCungCap_Service();
    private final TheLoai_Service daoTheLoai = new TheLoai_Service();
    private final ChatLieu_Service daoChatLieu = new ChatLieu_Service();
    private final SanPham_service dao = new SanPham_service();
    DefaultTableModel mol = new DefaultTableModel();
    int index = 0;
    String strFind;
    /**
     * Creates new form SanPhamJPanel
     */
    public SanPhamJPanel() {
        initComponents();
        mol = (DefaultTableModel) tbl_Sp.getModel();
        cbo_chatlieu.addItem("");
        cbo_loai.addItem("");
        cbo_ncc.addItem("");
        //loadFind();
        fillComboBoxNcc();
        fillComboBoxLoai();
        fillComboBoxchatLieu();
        Load();
        fillChatlieu();
        fillNhaCC();
        filltheLoai();
        fillTop3();
    }
    
    void Load() {
        mol.setRowCount(0);
        ArrayList<SanPham> lst = dao.getAll();
        for (SanPham sp : lst) {
            mol.addRow(new Object[]{sp.getMaSp(),
                sp.getTenSp(),
                sp.getMoTa(),
                sp.getMaCC(),
                sp.getSolg(),
                sp.getDonGia(),
                sp.getAnh(),
                sp.getTrangthai2()});
        }
    }

    void fillTop3() {
        DefaultTableModel moltop3 = (DefaultTableModel) tbl_top3.getModel();
        moltop3.setRowCount(0);
        ArrayList<SanPham> lst = dao.getAlltop3();
        for (SanPham sp : lst) {
            moltop3.addRow(new Object[]{sp.getMaSp(),
                sp.getTenSp(),
                sp.getSolg(),});
        }
    }

    void fillChatlieu() {
        DefaultTableModel mol1 = (DefaultTableModel) tbl_chatLieu.getModel();
        mol1.setRowCount(0);
        ArrayList<ChatLieu> lstCl = daoChatLieu.getall();
        for (ChatLieu cl : lstCl) {
            mol1.addRow(new Object[]{
                cl.getIDChatLieu(),
                cl.getChatLieu()
            });
        }
    }

    void fillNhaCC() {
        DefaultTableModel mol2 = (DefaultTableModel) tbl_Ncc.getModel();
        mol2.setRowCount(0);
        ArrayList<NhaCungCap> lstNcc = daoNcc.getall();
        for (NhaCungCap ncc : lstNcc) {
            mol2.addRow(new Object[]{
                ncc.getIDNhaCC(),
                ncc.getTenNhaCC(),
                ncc.getEmail(),
                ncc.getSdt(),
                ncc.getDiaChi()
            });
        }
    }

    void filltheLoai() {
        DefaultTableModel mol3 = (DefaultTableModel) tbl_theLoai.getModel();
        mol3.setRowCount(0);
        ArrayList<TheLoai> lstTl = daoTheLoai.getall();
        for (TheLoai tl : lstTl) {
            mol3.addRow(new Object[]{
                tl.getId_TheLoai(),
                tl.getTenTheloai()
            });
        }
    }

    void fillComboBoxNcc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_ncc.getModel();
        model.removeAllElements();
        cbo_ncc.addItem("");
        List<NhaCungCap> list = daoNcc.getall();
        for (NhaCungCap ncc : list) {
            String ten = ncc.getTenNhaCC();
            if (model.getIndexOf(ten) < 0) {
                model.addElement(ten);
            }
        }
        cbo_ncc.setSelectedIndex(0);
    }

    void fillComboBoxLoai() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_loai.getModel();
        model.removeAllElements();
        cbo_loai.addItem("");
        List<TheLoai> list = daoTheLoai.getall();
        for (TheLoai tl : list) {
            String ten = tl.getTenTheloai();
            if (model.getIndexOf(ten) < 0) {
                model.addElement(ten);
            }
        }
        cbo_ncc.setSelectedIndex(0);
    }

    void fillComboBoxchatLieu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_chatlieu.getModel();
        model.removeAllElements();
        cbo_chatlieu.addItem("");
        List<ChatLieu> list = daoChatLieu.getall();
        for (ChatLieu cl : list) {
            String ten = cl.getChatLieu();
            if (model.getIndexOf(ten) < 0) {
                model.addElement(ten);
            }
        }
        cbo_ncc.setSelectedIndex(0);
    }

//    void fillComboBoxAnh() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_anhsp.getModel();
//        model.removeAllElements();
//
//        List<AnhSp> list = daoAnh.getall();
//        for (AnhSp a : list) {
//            String ten = a.getTenAnh();
//            if (model.getIndexOf(ten) < 0) {
//                model.addElement(ten);
//            }
//        }
//        cbo_ncc.setSelectedIndex(0);
//    }
//    
    public SanPham getMode() {
        SanPham sp = new SanPham();
//        NhaCungCap ncc = new NhaCungCap();
        sp.setTenSp(txt_tenSp.getText());
        sp.setMaSp(txt_maSp.getText());
//        sp.setMaAnh(cbo_anhsp.getSelectedIndex());
        sp.setAnh(lbl_anh.getToolTipText());
//        sp.setAnhQr(lbl_QR.getToolTipText());
        //sp.setLoai(txt_loai.getText());
        sp.setIdNcc(cbo_ncc.getSelectedIndex());
        sp.setIdChatLieu(cbo_chatlieu.getSelectedIndex());
        sp.setIdLoai(cbo_loai.getSelectedIndex());
//        sp.setMaCC(cbo_ncc.getItemAt(ncc.getIDNhaCC()));
        sp.setSolg(Integer.parseInt(txt_solg.getText()));
        sp.setDonGia(Float.parseFloat(txt_dongia.getText()));
        sp.setMoTa(txt_mota.getText());
//        sp.setNgayNhap(txt_mnhaynhap.getText());
        // sp.setChatLieu(txt_cl.getText());
//        if (sp.isTrangThai() == true) {
//            rdo_conhang.setSelected(true);
//        } else {
//            rdo_hethang.setSelected(true);
//        }
        return sp;
    }

    public NhaCungCap getNhaCungCap() {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setTenNhaCC(txt_tenNcc.getText());
        ncc.setDiaChi(txt_diadiemNcc.getText());
        ncc.setEmail(txt_emailNcc.getText());
        ncc.setSdt(txt_sdtNcc.getText());
        return ncc;
    }

    public ChatLieu getChatLieu() {
        ChatLieu cl = new ChatLieu();
        cl.setChatLieu(txt_tenChatLieu.getText());
        return cl;
    }

    public TheLoai getLoai() {
        TheLoai tl = new TheLoai();
        tl.setTenTheloai(txt_tenTheLoai.getText());
        return tl;
    }

//    public  AnhSp getMOdel(){
//        AnhSp a = new AnhSp();
//        a.setID_anh(cbo_anhsp.getSelectedIndex());
//        a.setTenAnh(lbl_anhSp.getToolTipText());
//        a.setTenAnhQr(lbl_anhQr.getToolTipText());
//        return a;
//    }
    void setModel(int index) {
        SanPham sp = dao.getAll().get(index);
//        txt_tenSpCC.setText(sp.getTenSp());
        txt_tenTheLoai.setText(sp.getLoai());
        txt_tenChatLieu.setText(sp.getChatLieu());
        txt_maSp.setText(sp.getMaSp());
        txt_dongia.setText(String.valueOf(sp.getDonGia()));
        txt_tenSp.setText(sp.getTenSp());
//        cbo_ncc.setSelectedIndex(sp.getIdNcc());
//        cbo_chatlieu.setSelectedIndex(sp.getIdChatLieu());
//        cbo_loai.setSelectedIndex(sp.getIdLoai());
//        cbo_anhsp.setSelectedItem(sp.getAnh());
        cbo_ncc.setSelectedItem(sp.getMaCC());
        //txt_loai.setText(sp.getLoai());
//        txt_mnhaynhap.setText(String.valueOf(sp.getNgayNhap()));
        txt_mota.setText(sp.getMoTa());
        //txt_cl.setText(sp.getChatLieu());
        cbo_chatlieu.setSelectedItem(sp.getChatLieu());
        cbo_loai.setSelectedItem(sp.getLoai());
        //txt_nhaCC.setText(sp.getMaCC());
        txt_solg.setText(String.valueOf(sp.getSolg()));
        lbl_anh.setToolTipText(sp.getAnh());
        if (sp.getAnh() != null) {
            lbl_anh.setIcon(ShareHelper1.readLogo(sp.getAnh(), 100, 100));
        }
//        lbl_QR.setToolTipText(sp.getAnhQr());
//        if (sp.getAnhQr() != null) {
//            lbl_QR.setIcon(ShareHelper1.readLogo(sp.getAnhQr(), 100, 100));
//        }
//        lbl_anhSp.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//            lbl_anhSp.setIcon(ShareHelper1.readLogo(sp.getAnh()));
//        }
//        lbl_anhQr.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//            lbl_anhQr.setIcon(ShareHelper1.readLogo(sp.getAnh()));
//        }
        if (sp.getTrangthai2().equalsIgnoreCase("Còn hàng")) {
            rdo_conhang.setSelected(true);
        } else {
            rdo_hethang.setSelected(true);
        }
    }

    void setModelTop3(int index) {
        SanPham sp = dao.getAlltop3().get(index);
//        txt_tenSpCC.setText(sp.getTenSp());
        txt_tenTheLoai.setText(sp.getLoai());
        txt_tenChatLieu.setText(sp.getChatLieu());
        txt_maSp.setText(sp.getMaSp());
        txt_dongia.setText(String.valueOf(sp.getDonGia()));
        txt_tenSp.setText(sp.getTenSp());
//        cbo_ncc.setSelectedIndex(sp.getIdNcc());
//        cbo_chatlieu.setSelectedIndex(sp.getIdChatLieu());
//        cbo_loai.setSelectedIndex(sp.getIdLoai());
//        cbo_anhsp.setSelectedItem(sp.getAnh());
        cbo_ncc.setSelectedItem(sp.getMaCC());
        //txt_loai.setText(sp.getLoai());
//        txt_mnhaynhap.setText(String.valueOf(sp.getNgayNhap()));
        txt_mota.setText(sp.getMoTa());
        //txt_cl.setText(sp.getChatLieu());
        cbo_chatlieu.setSelectedItem(sp.getChatLieu());
        cbo_loai.setSelectedItem(sp.getLoai());
        //txt_nhaCC.setText(sp.getMaCC());
        txt_solg.setText(String.valueOf(sp.getSolg()));
        lbl_anh.setToolTipText(sp.getAnh());
        if (sp.getAnh() != null) {
            lbl_anh.setIcon(ShareHelper1.readLogo(sp.getAnh(), 100, 100));
        }
//        lbl_QR.setToolTipText(sp.getAnhQr());
//        if (sp.getAnhQr() != null) {
//            lbl_QR.setIcon(ShareHelper1.readLogo(sp.getAnhQr(), 100, 100));
//        }
//        lbl_anhSp.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//            lbl_anhSp.setIcon(ShareHelper1.readLogo(sp.getAnh()));
//        }
//        lbl_anhQr.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//            lbl_anhQr.setIcon(ShareHelper1.readLogo(sp.getAnh()));
//        }
        if (sp.getTrangthai2().equalsIgnoreCase("Còn hàng")) {
            rdo_conhang.setSelected(true);
        } else {
            rdo_hethang.setSelected(true);
        }
    }
    
    void setModelNcc(int index) {
        NhaCungCap ncc = daoNcc.getall().get(index);
        txt_diadiemNcc.setText(ncc.getDiaChi());
        txt_tenNcc.setText(ncc.getTenNhaCC());
        txt_emailNcc.setText(ncc.getEmail());
        txt_sdtNcc.setText(ncc.getSdt());
        txt_idNcc.setText(String.valueOf(ncc.getIDNhaCC()));
    }

    void setModelCl(int index) {
        ChatLieu cl = daoChatLieu.getall().get(index);
        txt_tenChatLieu.setText(cl.getChatLieu());
        txt_idCl.setText(String.valueOf(cl.getIDChatLieu()));
    }

    void setMOdelTl(int index) {
        TheLoai tl = daoTheLoai.getall().get(index);
        txt_tenTheLoai.setText(tl.getTenTheloai());
        txt_idTl.setText(String.valueOf(tl.getId_TheLoai()));
    }
//
//    private void init() {
//        this.setLocationRelativeTo(null);
//        setIconImage(ShareHelper1.APP_ICON);
////        new Timer(10, new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                Date now = new Date();
////                SimpleDateFormat formater = new SimpleDateFormat("hh::mm:ss a");
////                String text = formater.format(now);
////                lbl_time.setText(text);
////            }
////        }).start();
//    }

    void selectImage() {
        if (fileAnh.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileAnh.getSelectedFile();
            if (ShareHelper1.saveLogo(file)) {
                // Hiển thị hình lên form 

                lbl_anh.setIcon(ShareHelper1.readLogo(file.getName(), 100, 100));
                lbl_anh.setToolTipText(file.getName());

            }
        }
    }

//    void selectImageQR() {
//        if (fileAnh.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = fileAnh.getSelectedFile();
//            if (ShareHelper1.saveLogo(file)) {
//                // Hiển thị hình lên form 
//
//                lbl_QR.setIcon(ShareHelper1.readLogo(file.getName(), 100, 100));
//                lbl_QR.setToolTipText(file.getName());
//
//            }
//        }
//    }

//    void insertAnh(){
//        AnhSp mol = getMOdel();
//        try {
//            daoAnh.add(mol);
//            this.Load();
//            //this.clear();
//            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
//        }
//    }
    void insert() {
        SanPham model = getMode();
        try {
            dao.add(model);
            this.Load();
            this.fillTop3();
            this.clear();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }

    void delete() {
        String macd = txt_maSp.getText();
        try {
            dao.del(macd);
            this.Load();
            this.fillTop3();
            this.clear();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
        }

    }

    void update() {
        SanPham model = getMode();
        try {
            dao.update(model);
            this.Load();
            this.fillTop3();
            this.clear();
            JOptionPane.showMessageDialog(this, "Update thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "update thất bại! ");
        }
    }

    void insertNcc() {
        NhaCungCap modCap = getNhaCungCap();
        try {
            daoNcc.add(modCap);
            this.fillNhaCC();
            this.fillComboBoxNcc();
            this.clearNcc();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }

    void deleteNcc() {
        String idNcc = txt_idNcc.getText();
        try {
            daoNcc.del(idNcc);
            this.fillNhaCC();
            this.fillComboBoxNcc();
            this.clearNcc();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
        }

    }

    void updateNcc() {
        NhaCungCap modCap = getNhaCungCap();
        try {
            daoNcc.update(modCap);
            this.fillNhaCC();
            this.fillComboBoxNcc();
            this.clearNcc();
            JOptionPane.showMessageDialog(this, "Update thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "update thất bại! ");
        }
    }

    void insertTl() {
        TheLoai mol3 = getLoai();
        try {
            daoTheLoai.add(mol3);
            this.filltheLoai();
            this.fillComboBoxLoai();
            this.clearTl();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }

    void deleteTl() {
        String idNcc = txt_idTl.getText();
        try {
            daoTheLoai.del(idNcc);
            this.filltheLoai();
            this.fillComboBoxLoai();
            this.clearTl();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
        }

    }

    void updateTl() {
        TheLoai mol3 = getLoai();
        try {
            daoTheLoai.update(mol3);
            this.filltheLoai();
            this.fillComboBoxLoai();
            this.clearTl();
            JOptionPane.showMessageDialog(this, "Update thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "update thất bại! ");
        }
    }

    void insertCl() {
        ChatLieu mol4 = getChatLieu();
        try {
            daoChatLieu.add(mol4);
            this.fillChatlieu();
            this.fillComboBoxchatLieu();
            this.clearCl();
            JOptionPane.showMessageDialog(this, "Thêm Thành Cônng");
            ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chuyên đề này đã có!");
        }
    }

    void deleteCl() {
        String idNcc = txt_idCl.getText();
        try {
            daoChatLieu.del(idNcc);
            this.fillChatlieu();
            this.fillComboBoxchatLieu();
            this.clearCl();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! ");
        }

    }

    void updateNccCl() {
        ChatLieu mol4 = getChatLieu();
        try {
            daoChatLieu.update(mol4);
            this.fillChatlieu();
            this.fillComboBoxchatLieu();
            this.clearCl();
            JOptionPane.showMessageDialog(this, "Update thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "update thất bại! ");
        }
    }

    void clearNcc() {
        txt_idNcc.setText("");
        txt_emailNcc.setText("");
        txt_sdtNcc.setText("");
        txt_tenNcc.setText("");
        txt_diadiemNcc.setText("");
    }

    void clearCl() {
        txt_idCl.setText("");
        txt_tenChatLieu.setText("");
    }

    void clearTl() {
        txt_idTl.setText("");
        txt_tenTheLoai.setText("");
    }

    void clear() {
        txt_dongia.setText("");
        txt_maSp.setText("");
        txt_mota.setText("");
        txt_solg.setText("");
        txt_tenSp.setText("");
        lbl_anh.setIcon(null);
//        lbl_QR.setIcon(null);
        cbo_chatlieu.setSelectedIndex(0);
        cbo_loai.setSelectedIndex(0);
        cbo_ncc.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileAnh = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        pnl_Sp = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_maSp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tenSp = new javax.swing.JTextField();
        rdo_conhang = new javax.swing.JRadioButton();
        rdo_hethang = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        txt_solg = new javax.swing.JTextField();
        txt_dongia = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbo_loai = new javax.swing.JComboBox<>();
        cbo_ncc = new javax.swing.JComboBox<>();
        cbo_chatlieu = new javax.swing.JComboBox<>();
        lbl_anh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_adSp = new javax.swing.JButton();
        btn_delSp = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Sp = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_find = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_top3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_lichsu = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        pnl_Ncc = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_tenNcc = new javax.swing.JTextField();
        txt_idNcc = new javax.swing.JTextField();
        txt_emailNcc = new javax.swing.JTextField();
        txt_sdtNcc = new javax.swing.JTextField();
        txt_diadiemNcc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Ncc = new javax.swing.JTable();
        btn_addNCC = new javax.swing.JButton();
        btn_delNcc = new javax.swing.JButton();
        btn_updateNcc = new javax.swing.JButton();
        btn_clearNcc = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        btn_addTL = new javax.swing.JButton();
        btn_delTl = new javax.swing.JButton();
        btn_updeteTL = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txt_tenTheLoai = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_idTl = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_theLoai = new javax.swing.JTable();
        btn_clearTl = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btb_addCl = new javax.swing.JButton();
        btn_xoaCl = new javax.swing.JButton();
        btn_updateCl = new javax.swing.JButton();
        btn_clearCl = new javax.swing.JButton();
        txt_tenChatLieu = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_idCl = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_chatLieu = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sản Phẩm"));

        jLabel11.setText("Trạng thái");

        buttonGroup1.add(rdo_conhang);
        rdo_conhang.setText("Còn Hàng");
        rdo_conhang.setEnabled(false);

        buttonGroup1.add(rdo_hethang);
        rdo_hethang.setText("Hết hàng");
        rdo_hethang.setEnabled(false);

        jLabel12.setText("Mô tả");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane2.setViewportView(txt_mota);

        jLabel21.setText("Chất Liệu");

        cbo_loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_ncc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbo_chatlieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl_anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666659_image.png"))); // NOI18N
        lbl_anh.setText("Nhấp chọn ảnh");
        lbl_anh.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ảnh"));
        lbl_anh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_anh.setDisabledIcon(null);
        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_anhMousePressed(evt);
            }
        });

        jLabel1.setText("Mã Sản Phẩm");

        jLabel2.setText("Tên Sản Phẩm");

        jLabel3.setText("Loại");

        jLabel4.setText("Nhà cung cấp ");

        jLabel5.setText("Số lượng");

        jLabel6.setText("Đơn giá");

        btn_adSp.setText("Add");
        btn_adSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adSpActionPerformed(evt);
            }
        });

        btn_delSp.setText("Delete");
        btn_delSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delSpActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdo_conhang)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdo_hethang))
                                    .addComponent(txt_solg, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel21))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbo_chatlieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_tenSp)
                                                .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbo_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_anh))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_adSp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delSp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_tenSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbo_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txt_solg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_hethang)
                    .addComponent(rdo_conhang)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_adSp)
                        .addComponent(btn_delSp)
                        .addComponent(btn_update)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách Sản phẩm"));

        tbl_Sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sp", "Tên Sp", "Mô Tả", "Nhà cung cấp", "Số lượng", "Đơn giá", "Ảnh", "Trạng thái"
            }
        ));
        tbl_Sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SpMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_Sp);

        jLabel10.setText("Tìm kiếm");

        txt_find.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_findKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thống kê"));

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 204));

        tbl_top3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ));
        tbl_top3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_top3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_top3);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Top 3 nhập về nhiều nhất", jPanel9);

        tbl_lichsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SĐT khách hàng", "Mã Sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ));
        jScrollPane5.setViewportView(tbl_lichsu);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử mua", jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Quản lý Sản Phẩm");

        javax.swing.GroupLayout pnl_SpLayout = new javax.swing.GroupLayout(pnl_Sp);
        pnl_Sp.setLayout(pnl_SpLayout);
        pnl_SpLayout.setHorizontalGroup(
            pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_SpLayout.createSequentialGroup()
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_SpLayout.setVerticalGroup(
            pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_SpLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_SpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_SpLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabs.addTab("Sản phẩm", pnl_Sp);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nhà cung cấp"));

        jLabel8.setText("Tên Nhà Cung cấp");

        jLabel9.setText("Email");

        jLabel14.setText("Sdt");

        jLabel15.setText("Địa Điêm");

        jLabel20.setText("ID");

        txt_idNcc.setEditable(false);

        tbl_Ncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên Nhà Cung Cấp", "Email", "Sdt", "Địa Điểm"
            }
        ));
        tbl_Ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NccMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_Ncc);

        btn_addNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666724_upload.png"))); // NOI18N
        btn_addNCC.setText("ADD");
        btn_addNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addNCCActionPerformed(evt);
            }
        });

        btn_delNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666595_x.png"))); // NOI18N
        btn_delNcc.setText("Delete");
        btn_delNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delNccActionPerformed(evt);
            }
        });

        btn_updateNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666681_edit.png"))); // NOI18N
        btn_updateNcc.setText("Update");
        btn_updateNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateNccActionPerformed(evt);
            }
        });

        btn_clearNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/8666635_ccw_refresh.png"))); // NOI18N
        btn_clearNcc.setText("Clear");
        btn_clearNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearNccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tenNcc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_idNcc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_emailNcc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sdtNcc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_diadiemNcc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btn_addNCC)
                .addGap(18, 18, 18)
                .addComponent(btn_delNcc)
                .addGap(18, 18, 18)
                .addComponent(btn_updateNcc)
                .addGap(18, 18, 18)
                .addComponent(btn_clearNcc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txt_idNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_emailNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sdtNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_diadiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addNCC)
                    .addComponent(btn_delNcc)
                    .addComponent(btn_updateNcc)
                    .addComponent(btn_clearNcc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thể loại"));

        jLabel24.setText("Thể loại");

        btn_addTL.setText("Add");
        btn_addTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTLActionPerformed(evt);
            }
        });

        btn_delTl.setText("Delete");
        btn_delTl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delTlActionPerformed(evt);
            }
        });

        btn_updeteTL.setText("Update");
        btn_updeteTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updeteTLActionPerformed(evt);
            }
        });

        jLabel26.setText("Tên Thể Loại");

        jLabel27.setText("ID");

        txt_idTl.setEditable(false);

        tbl_theLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Tên loại'"
            }
        ));
        tbl_theLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_theLoaiMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_theLoai);

        btn_clearTl.setText("Clear");
        btn_clearTl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearTlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_addTL, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delTl, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_updeteTL, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clearTl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel24))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txt_idTl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_idTl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addTL)
                    .addComponent(btn_delTl)
                    .addComponent(btn_updeteTL)
                    .addComponent(btn_clearTl))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chất liệu"));

        jLabel28.setText("Chất Liệu");

        jLabel29.setText("Tên Chất liệu");

        btb_addCl.setText("Add");
        btb_addCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btb_addClActionPerformed(evt);
            }
        });

        btn_xoaCl.setText("Delete");
        btn_xoaCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaClActionPerformed(evt);
            }
        });

        btn_updateCl.setText("Update");
        btn_updateCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateClActionPerformed(evt);
            }
        });

        btn_clearCl.setText("Clear");
        btn_clearCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearClActionPerformed(evt);
            }
        });

        jLabel30.setText("ID");

        txt_idCl.setEditable(false);

        tbl_chatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Tên Chất liệu"
            }
        ));
        tbl_chatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chatLieuMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbl_chatLieu);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btb_addCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_xoaCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_updateCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clearCl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tenChatLieu)
                                    .addComponent(txt_idCl, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel28)
                                .addGap(6, 6, 6)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txt_idCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txt_tenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btb_addCl)
                    .addComponent(btn_xoaCl)
                    .addComponent(btn_updateCl)
                    .addComponent(btn_clearCl))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_NccLayout = new javax.swing.GroupLayout(pnl_Ncc);
        pnl_Ncc.setLayout(pnl_NccLayout);
        pnl_NccLayout.setHorizontalGroup(
            pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(307, 307, 307))
            .addGroup(pnl_NccLayout.createSequentialGroup()
                .addGroup(pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_NccLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_NccLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_NccLayout.setVerticalGroup(
            pnl_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Thông tin chi tiết", pnl_Ncc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
        this.selectImage();
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void lbl_anhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMousePressed
        //        if (evt.getClickCount() == 2) {
            //            tabs.setSelectedIndex(3);
            //        }
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_anhMousePressed

    private void btn_adSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adSpActionPerformed
        insert();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_adSpActionPerformed

    private void btn_delSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delSpActionPerformed
        delete();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delSpActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        update();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tbl_SpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SpMouseClicked
        index = tbl_Sp.getSelectedRow();
        setModel(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_SpMouseClicked

    private void txt_findKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findKeyReleased
        DefaultTableModel dtm = (DefaultTableModel) tbl_Sp.getModel();
        TableRowSorter<DefaultTableModel> abc = new TableRowSorter<>(dtm);
        tbl_Sp.setRowSorter(abc);
        abc.setRowFilter(RowFilter.regexFilter(txt_find.getText(), 0, 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findKeyReleased

    private void tbl_top3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_top3MouseClicked
        index = tbl_top3.getSelectedRow();
        setModelTop3(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_top3MouseClicked

    private void tbl_NccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NccMouseClicked
        index = tbl_Ncc.getSelectedRow();
        setModelNcc(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_NccMouseClicked

    private void btn_addNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addNCCActionPerformed
        insertNcc();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addNCCActionPerformed

    private void btn_delNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delNccActionPerformed
        deleteNcc();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delNccActionPerformed

    private void btn_updateNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateNccActionPerformed
        updateNcc();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateNccActionPerformed

    private void btn_clearNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearNccActionPerformed
        clearNcc();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearNccActionPerformed

    private void btn_addTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTLActionPerformed
        insertTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addTLActionPerformed

    private void btn_delTlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delTlActionPerformed
        deleteTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_delTlActionPerformed

    private void btn_updeteTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updeteTLActionPerformed
        updateTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updeteTLActionPerformed

    private void tbl_theLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_theLoaiMouseClicked
        index = tbl_theLoai.getSelectedRow();
        setMOdelTl(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_theLoaiMouseClicked

    private void btn_clearTlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearTlActionPerformed
        clearTl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearTlActionPerformed

    private void btb_addClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btb_addClActionPerformed
        insertCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btb_addClActionPerformed

    private void btn_xoaClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaClActionPerformed
        deleteCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaClActionPerformed

    private void btn_updateClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateClActionPerformed
        updateNccCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateClActionPerformed

    private void btn_clearClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearClActionPerformed
        clearCl();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearClActionPerformed

    private void tbl_chatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chatLieuMouseClicked
        index = tbl_chatLieu.getSelectedRow();
        setModelCl(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_chatLieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btb_addCl;
    private javax.swing.JButton btn_adSp;
    private javax.swing.JButton btn_addNCC;
    private javax.swing.JButton btn_addTL;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clearCl;
    private javax.swing.JButton btn_clearNcc;
    private javax.swing.JButton btn_clearTl;
    private javax.swing.JButton btn_delNcc;
    private javax.swing.JButton btn_delSp;
    private javax.swing.JButton btn_delTl;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_updateCl;
    private javax.swing.JButton btn_updateNcc;
    private javax.swing.JButton btn_updeteTL;
    private javax.swing.JButton btn_xoaCl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_chatlieu;
    private javax.swing.JComboBox<String> cbo_loai;
    private javax.swing.JComboBox<String> cbo_ncc;
    private javax.swing.JFileChooser fileAnh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JPanel pnl_Ncc;
    private javax.swing.JPanel pnl_Sp;
    private javax.swing.JRadioButton rdo_conhang;
    private javax.swing.JRadioButton rdo_hethang;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_Ncc;
    private javax.swing.JTable tbl_Sp;
    private javax.swing.JTable tbl_chatLieu;
    private javax.swing.JTable tbl_lichsu;
    private javax.swing.JTable tbl_theLoai;
    private javax.swing.JTable tbl_top3;
    private javax.swing.JTextField txt_diadiemNcc;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_emailNcc;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_idCl;
    private javax.swing.JTextField txt_idNcc;
    private javax.swing.JTextField txt_idTl;
    private javax.swing.JTextField txt_maSp;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_sdtNcc;
    private javax.swing.JTextField txt_solg;
    private javax.swing.JTextField txt_tenChatLieu;
    private javax.swing.JTextField txt_tenNcc;
    private javax.swing.JTextField txt_tenSp;
    private javax.swing.JTextField txt_tenTheLoai;
    // End of variables declaration//GEN-END:variables
}
