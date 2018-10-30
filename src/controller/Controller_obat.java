/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_obat;

/**
 *
 * @author abednego(11315020)
 */
public interface Controller_obat {
    public void Simpan(View_obat obt) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_obat obt) throws SQLException;
    public void Hapus(View_obat obt) throws SQLException;
    public void Tampil(View_obat obt) throws SQLException;
    public void Baru(View_obat obt);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_obat obt) throws SQLException;
}
