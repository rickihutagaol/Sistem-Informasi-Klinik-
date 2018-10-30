/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;

import view.View_keluhan;

/**
 *
 * @author stu
 */
public interface Controller_keluhan {
 
      public void Simpan(View_keluhan keluhan ) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_keluhan keluhan) throws SQLException;
    public void Hapus(View_keluhan keluhan) throws SQLException;
    public void Tampil(View_keluhan keluhan) throws SQLException;
    public void Baru(View_keluhan keluhan);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_keluhan keluhan) throws SQLException;
    
   
}
