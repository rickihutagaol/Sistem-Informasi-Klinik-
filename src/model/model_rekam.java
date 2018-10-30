/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_rekam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_rekam;

/**
 *
 * @author stu
 */
public class model_rekam implements Controller_rekam{
    
    
        @Override
    public void Simpan(View_rekam rekam) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert rekam_medis values(?,?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, rekam.txtidrekammedis.getText());
            prepare.setString(2, rekam.txtidpasien.getText());
            prepare.setString(3, rekam.txtmasuk.getText());
            prepare.setString(4, rekam.txtkeluar.getText());
            prepare.setString(5, rekam.txtiddokter.getText());
            
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(rekam);
            rekam.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_rekam rekam) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update rekam_medis set id_pasien= ?, tanggal_masuk= ?,tanggal_keluar = ?,id_dokter = ? where id_rekammedis= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(5, rekam.txtidrekammedis.getText());
            prepare.setString(1, rekam.txtidpasien.getText());
            prepare.setString(2, rekam.txtmasuk.getText());
            prepare.setString(3, rekam.txtkeluar.getText());
            prepare.setString(3, rekam.txtkeluar.getText());
           
             prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(rekam);
            rekam.setLebarKolom();
            Baru(rekam);
        }
    }

    @Override
    public void Hapus(View_rekam rekam) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from rekam_medis where id_rekammedis= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, rekam.txtidrekammedis.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(rekam);
            rekam.setLebarKolom();
            Baru(rekam);
        }
    }
 
    @Override
    public void Tampil(View_rekam rekam) throws SQLException {
        rekam.tblmodel.getDataVector().removeAllElements();
        rekam.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from rekam_medis order by id_rekammedis asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              
              rekam.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_rekam rekam) {
       rekam.txtidrekammedis.setText("");
       rekam.txtidpasien.setText("");
       rekam.txtmasuk.setText("");
       rekam.txtkeluar.setText("");
       rekam.txtiddokter.setText("");
    
    }

    @Override
    public void KlikTabel(View_rekam rekam) throws SQLException {
       try {
             int pilih = rekam.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             rekam.txtidrekammedis.setText(rekam.tblmodel.getValueAt(pilih, 0).toString());
             rekam.txtidpasien.setText(rekam.tblmodel.getValueAt(pilih, 1).toString());
             rekam.txtmasuk.setText(rekam.tblmodel.getValueAt(pilih, 2).toString());
             rekam.txtkeluar.setText(rekam.tblmodel.getValueAt(pilih, 3).toString());         
             rekam.txtiddokter.setText(rekam.tblmodel.getValueAt(pilih, 4).toString());         
        
       } catch (Exception e) {
            System.out.print(e);
        }
        
    }

}
