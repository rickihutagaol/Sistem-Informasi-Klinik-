/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_Kaskeluar;
import controller.Controller_keluhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_keluhan;
import view.View_keluhan;

/**
 *
 * @author stu
 */
public class model_keluhan implements Controller_keluhan{
    
        @Override
    public void Simpan(View_keluhan keluhan) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert keluhan values(?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, keluhan.txtidkeluhan.getText());
            prepare.setString(2, keluhan.txtidpasien.getText());
            prepare.setString(3, keluhan.txtnama.getText());
            prepare.setString(4, keluhan.txtkeluhan.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(keluhan);
            keluhan.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_keluhan keluhan) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update keluhan set idpasien= ?, nama_pasien= ?,keluhan = ? where id_keluhan= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, keluhan.txtidkeluhan.getText());
            prepare.setString(1, keluhan.txtidpasien.getText());
            prepare.setString(2, keluhan.txtnama.getText());
            prepare.setString(3, keluhan.txtkeluhan.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(keluhan);
            keluhan.setLebarKolom();
            Baru(keluhan);
        }
    }

    @Override
    public void Hapus(View_keluhan keluhan) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from keluhan where id_keluhan= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, keluhan.txtidkeluhan.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(keluhan);
            keluhan.setLebarKolom();
            Baru(keluhan);
        }
    }
 
    @Override
    public void Tampil(View_keluhan keluhan) throws SQLException {
        keluhan.tblmodel.getDataVector().removeAllElements();
      keluhan.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from keluhan order by id_keluhan asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              keluhan.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_keluhan keluhan) {
       keluhan.txtidkeluhan.setText("");
        keluhan.txtidpasien.setText("");
        keluhan.txtnama.setText("");
        keluhan.txtkeluhan.setText("");
    }

    @Override
    public void KlikTabel(View_keluhan keluhan) throws SQLException {
       try {
             int pilih = keluhan.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             keluhan.txtidkeluhan.setText(keluhan.tblmodel.getValueAt(pilih, 0).toString());
             keluhan.txtidpasien.setText(keluhan.tblmodel.getValueAt(pilih, 1).toString());
             keluhan.txtnama.setText(keluhan.tblmodel.getValueAt(pilih, 2).toString());
             keluhan.txtkeluhan.setText(keluhan.tblmodel.getValueAt(pilih, 3).toString());         
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
 
}
