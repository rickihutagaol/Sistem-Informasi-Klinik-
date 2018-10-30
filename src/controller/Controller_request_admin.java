/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_obat;
import view.View_request_admin;

/**
 *
 * @author abednego(11315020)
 */
public interface Controller_request_admin {
    public void Tampil(View_request_admin reqmin) throws SQLException;
    public void KlikTabel(View_request_admin reqmin) throws SQLException;
    public void Ubah(View_request_admin reqmin) throws SQLException;
}
