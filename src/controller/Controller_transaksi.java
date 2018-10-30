/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.View_kasmasuk;
import view.View_transaksi;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public interface Controller_transaksi {
    //perintah CRUD
    public void Simpan(View_transaksi transaksi) throws SQLException;         //Jika kita menggunakan perintah sql
    public void Ubah(View_transaksi transaksi) throws SQLException;
    public void Hapus(View_transaksi transaksi) throws SQLException;
    public void Tampil(View_transaksi transaksi) throws SQLException;
    public void Baru(View_transaksi transaksi);                               // kita melakukan perintah dasar saja
    public void KlikTabel(View_transaksi transaksi) throws SQLException;
}
