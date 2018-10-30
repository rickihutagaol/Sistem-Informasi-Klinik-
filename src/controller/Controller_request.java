/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_obat;
import view.View_request;

/**
 *
 * @author abednego(11315020)
 */
public interface Controller_request {
    public void Request(View_request req) throws SQLException;  //Jika kita menggunakan perintah sql
    public void Print(View_request req) throws SQLException;
    //public void Hapus(View_request req) throws SQLException; 
   public void Baru(View_request req);                               // kita melakukan perintah dasar saja
   // public void KlikTabel(View_request req) throws SQLException; */
}
