/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_kaskeluar;

/**
 *
 * @author stu
 */
public interface Controller_Kaskeluar {
 
     public void Simpan(View_kaskeluar kaskeluar ) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_kaskeluar kaskeluar) throws SQLException;
    public void Hapus(View_kaskeluar kaskeluar) throws SQLException;
    public void Tampil(View_kaskeluar kaskeluar) throws SQLException;
    public void Baru(View_kaskeluar kaskeluar);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_kaskeluar kaskeluar) throws SQLException;
    
   
    
    
}
