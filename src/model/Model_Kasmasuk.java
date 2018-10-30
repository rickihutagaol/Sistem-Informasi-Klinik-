/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_Kasmasuk;
import view.View_kasmasuk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;

/**
 *
 * @author HP
 */
public class Model_Kasmasuk implements Controller_Kasmasuk{
    @Override
    public void Simpan(View_kasmasuk kasmasuk) throws SQLException {
        try {           
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert kas_masuk values(?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            prepare.setString(1, kasmasuk.no.getText());
            prepare.setString(2, kasmasuk.bulan.getText());
            prepare.setString(3, kasmasuk.pemasukan.getText());
            prepare.setString(4, kasmasuk.jumlah.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(kasmasuk);
            kasmasuk.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_kasmasuk kasmasuk) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update kas_masuk set pemasukan= ?, bulan= ?, jumlah= ? where id_kasmasuk= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, kasmasuk.no.getText());
            prepare.setString(1, kasmasuk.bulan.getText());
            prepare.setString(2, kasmasuk.pemasukan.getText());
            prepare.setString(3, kasmasuk.jumlah.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(kasmasuk);
            kasmasuk.setLebarKolom();
            Baru(kasmasuk);
        }
    }

    @Override
    public void Hapus(View_kasmasuk kasmasuk) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from kas_masuk where id_kasmasuk= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, kasmasuk.no.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(kasmasuk);
            kasmasuk.setLebarKolom();
            Baru(kasmasuk);
        }
    }

    @Override
    public void Tampil(View_kasmasuk kasmasuk) throws SQLException {
        kasmasuk.tblmodel.getDataVector().removeAllElements();
      kasmasuk.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from kas_masuk order by id_kasmasuk asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              kasmasuk.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_kasmasuk kasmasuk) {
       kasmasuk.no.setText("");
        kasmasuk.bulan.setText("");
        kasmasuk.jumlah.setText("");
        kasmasuk.pemasukan.setText("");
        
    }

    @Override
    public void KlikTabel(View_kasmasuk kasmasuk) throws SQLException {
       try {
             int pilih = kasmasuk.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             kasmasuk.no.setText(kasmasuk.tblmodel.getValueAt(pilih, 0).toString());
             kasmasuk.bulan.setText(kasmasuk.tblmodel.getValueAt(pilih, 1).toString());
             kasmasuk.pemasukan.setText(kasmasuk.tblmodel.getValueAt(pilih, 2).toString());
             kasmasuk.jumlah.setText(kasmasuk.tblmodel.getValueAt(pilih, 3).toString());         
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
}
