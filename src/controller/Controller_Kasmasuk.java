/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.View_kasmasuk;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public interface Controller_Kasmasuk {
    //perintah CRUD
    public void Simpan(View_kasmasuk kasmasuk) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_kasmasuk kasmasuk) throws SQLException;
    public void Hapus(View_kasmasuk kasmasuk) throws SQLException;
    public void Tampil(View_kasmasuk kasmasuk) throws SQLException;
    public void Baru(View_kasmasuk kasmasuk);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_kasmasuk kasmasuk) throws SQLException;
}
