/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_riwayat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.Db_Koneksi;
import view.View_riwayatrequest;
import view.View_riwayatrequest;

/**
 *
 * @author abednego(11315020)
 */
public class model_riwayatrequest implements Controller_riwayat {
     
    @Override
    public void Tampil(View_riwayatrequest req) throws SQLException {
        req.tblmodel.getDataVector().removeAllElements();
      req.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from request_berobat order by id_request asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              ob[5] = res.getString(6);
              req.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    
}
