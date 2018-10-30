/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;

import view.View_rekam;

/**
 *
 * @author stu
 */
public interface Controller_rekam {
 
       public void Simpan(View_rekam rekam ) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_rekam rekam) throws SQLException;
    public void Hapus(View_rekam rekam) throws SQLException;
    public void Tampil(View_rekam rekam) throws SQLException;
    public void Baru(View_rekam rekam);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_rekam rekam) throws SQLException;
    
}
