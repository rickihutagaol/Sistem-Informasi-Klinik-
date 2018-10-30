/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_pasien;

/**
 *
 * @author abednego(11315020)
 */

 public interface Controller_pasien {
    public void Simpan(View_pasien psn) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_pasien psn) throws SQLException;
    public void Hapus(View_pasien psn) throws SQLException;
    public void Tampil(View_pasien psn) throws SQLException;
    public void Baru(View_pasien psn);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_pasien psn) throws SQLException;
}

