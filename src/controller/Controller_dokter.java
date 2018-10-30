/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_dokter;

/**
 *
 * @author abednego(11315020)
 */
public interface Controller_dokter {
    public void Simpan(View_dokter dokter) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_dokter dokter) throws SQLException;
    public void Hapus(View_dokter dokter) throws SQLException;
    public void Tampil(View_dokter dokter) throws SQLException;
    public void Baru(View_dokter dokter);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_dokter dokter) throws SQLException;
}
