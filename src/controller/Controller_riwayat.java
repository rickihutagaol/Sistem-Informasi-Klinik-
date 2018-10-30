/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.View_request;
import view.View_riwayatrequest;

/**
 *
 * @author abednego(11315020)
 */
public interface Controller_riwayat {
     
    public void Tampil(View_riwayatrequest req) throws SQLException;
}
