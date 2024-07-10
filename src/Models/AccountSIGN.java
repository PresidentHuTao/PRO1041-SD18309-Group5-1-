/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author os
 */
public class AccountSIGN {
    private String user;
    private String pass;
    private String tennv;
    private int MaCV;
    private String tenCV;

    public AccountSIGN() {
    }

    public AccountSIGN(String user, String pass, String tennv, int MaCV, String tenCV) {
        this.user = user;
        this.pass = pass;
        this.tennv = tennv;
        this.MaCV = MaCV;
        this.tenCV = tenCV;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getMaCV() {
        return MaCV;
    }

    public void setMaCV(int MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
    
    
    
}
