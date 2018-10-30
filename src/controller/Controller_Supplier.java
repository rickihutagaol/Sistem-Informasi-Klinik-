/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_Supplier;
import view.View_Supplier;

/**
 *
 * @author stu
 */
public interface Controller_Supplier {
    
     public void Simpan(View_Supplier Supplier ) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_Supplier Supplier) throws SQLException;
    public void Hapus(View_Supplier Supplier) throws SQLException;
    public void Tampil(View_Supplier Supplier) throws SQLException;
    public void Baru(View_Supplier Supplier);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_Supplier Supplier) throws SQLException;
    
}
