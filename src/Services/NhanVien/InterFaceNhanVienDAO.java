/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services.NhanVien;

import java.util.ArrayList;

/**
 *
 * @author LVQ
 */
public interface InterFaceNhanVienDAO<E,K> {
    public boolean Insert(E e);
     public boolean Update(E e);
     public boolean Delete(E e);
     public ArrayList<E> selectAll();
     public boolean selectByID(K k);
}
