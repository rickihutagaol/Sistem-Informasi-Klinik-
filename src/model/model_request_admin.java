/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_request_admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_keluhan;
import view.View_request_admin;

/**
 *
 * @author abednego(11315020)
 */
public class model_request_admin implements Controller_request_admin {
    @Override
    public void Tampil(View_request_admin reqmin) throws SQLException {
        reqmin.tblmodel.getDataVector().removeAllElements();
        reqmin.tblmodel.fireTableDataChanged();
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
              reqmin.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void KlikTabel(View_request_admin reqmin) throws SQLException {
        try {
             int pilih = reqmin.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             reqmin.txtidmahasiswa.setText(reqmin.tblmodel.getValueAt(pilih, 1).toString());      
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public void Ubah(View_request_admin reqmin) throws SQLException {
        try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update request_berobat set status_request = ? where id_mahasiswa= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, "Diterima");
            prepare.setString(2, reqmin.txtidmahasiswa.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(reqmin);
        }
    }
}
