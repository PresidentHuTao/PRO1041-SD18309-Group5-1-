/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.NhanVien;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author LVQ
 */
public class CaLam_NhanVienModel {

    private String MaNV, HoTen;
    private int CaLam;
    
//     private int[] CacCalam;     

    public int getCaLam() {
        return CaLam;
    }

    public void setCaLam(int CaLam) {
        this.CaLam = CaLam;
    }

    public CaLam_NhanVienModel(String MaNV, String HoTen, int CaLam) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.CaLam = CaLam;
    }
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public CaLam_NhanVienModel() {
    }

//    public ArrayList<Integer> LayCaLamCuThe() {
//        ArrayList<Integer> numbers = new ArrayList<>();
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(cacCaLam);
//
//        while (matcher.find()) {
//            String numberStr = matcher.group();
//            int number = Integer.parseInt(numberStr);
//            numbers.add(number);
////            System.out.println(number);
//        }
//        return numbers;
//    }
}
