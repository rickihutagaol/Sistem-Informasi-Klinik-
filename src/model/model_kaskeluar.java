/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_Kaskeluar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_kaskeluar;

/** 
 *
 * @author stu
 */
public class model_kaskeluar implements Controller_Kaskeluar {
    
    
     @Override
    public void Simpan(View_kaskeluar kaskeluar) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert kas_keluar values(?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, kaskeluar.txtidkaskeluar.getText());
            prepare.setString(2, kaskeluar.txtpengeluaran.getText());
            prepare.setString(3, kaskeluar.txtbulan.getText());
            prepare.setString(4, kaskeluar.txtjumlah.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(kaskeluar);
            kaskeluar.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_kaskeluar kaskeluar) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update kas_keluar set pengeluaran= ?, bulan= ?, jumlah= ? where id_kaskeluar= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(4, kaskeluar.txtidkaskeluar.getText());
            prepare.setString(1, kaskeluar.txtpengeluaran.getText());
            prepare.setString(2, kaskeluar.txtbulan.getText());
            prepare.setString(3, kaskeluar.txtjumlah.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(kaskeluar);
            kaskeluar.setLebarKolom();
            Baru(kaskeluar);
        }
    }

    @Override
    public void Hapus(View_kaskeluar kaskeluar) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from kas_keluar where id_kaskeluar= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, kaskeluar.txtidkaskeluar.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(kaskeluar);
            kaskeluar.setLebarKolom();
            Baru(kaskeluar);
        }
    }
 
    @Override
    public void Tampil(View_kaskeluar kaskeluar) throws SQLException {
        kaskeluar.tblmodel.getDataVector().removeAllElements();
      kaskeluar.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from kas_keluar order by id_kaskeluar asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              kaskeluar.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_kaskeluar kaskeluar) {
       kaskeluar.txtidkaskeluar.setText("");
        kaskeluar.txtpengeluaran.setText("");
        kaskeluar.txtbulan.setText("");
        kaskeluar.txtjumlah.setText("");
    }

    @Override
    public void KlikTabel(View_kaskeluar kaskeluar) throws SQLException {
       try {
             int pilih = kaskeluar.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             kaskeluar.txtidkaskeluar.setText(kaskeluar.tblmodel.getValueAt(pilih, 0).toString());
             kaskeluar.txtpengeluaran.setText(kaskeluar.tblmodel.getValueAt(pilih, 1).toString());
             kaskeluar.txtbulan.setText(kaskeluar.tblmodel.getValueAt(pilih, 2).toString());
             kaskeluar.txtjumlah.setText(kaskeluar.tblmodel.getValueAt(pilih, 3).toString());         
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
   
}
