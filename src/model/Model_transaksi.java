/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import controller.Controller_transaksi;
import view.View_kasmasuk;
import view.View_transaksi;
import view.View_transaksi;
import view.View_transaksi;
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
public class Model_transaksi implements Controller_transaksi {
    @Override
    public void Simpan(View_transaksi transaksi) throws SQLException {
        try {           
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert transaksi values(?,?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            prepare.setString(1, transaksi.Notransaksi.getText());
            prepare.setString(2, transaksi.tanggaltransaksi.getText());
            prepare.setString(3, transaksi.idmahasiswa.getText());
            prepare.setString(4, transaksi.iddokter.getText());
            prepare.setString(5, transaksi.biaya.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(transaksi);
            transaksi.setLebarKolom();
        }
    }
@Override
    public void Ubah(View_transaksi transaksi) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update transaksi set tgl_transaksi= ?, id_mahasiswa= ?, id_dokter= ?, biaya= ? where no_transaksi= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(5, transaksi.Notransaksi.getText());
            prepare.setString(1, transaksi.tanggaltransaksi.getText());
            prepare.setString(2, transaksi.idmahasiswa.getText());
            prepare.setString(3, transaksi.iddokter.getText());
            prepare.setString(4, transaksi.biaya.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(transaksi);
            transaksi.setLebarKolom();
            Baru(transaksi);
        }
    }
    
    @Override
    public void Hapus(View_transaksi transaksi) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from transaksi where no_transaksi= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, transaksi.Notransaksi.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(transaksi);
            transaksi.setLebarKolom();
            Baru(transaksi);
        }
    }
    
    @Override
    public void Tampil(View_transaksi transaksi) throws SQLException {
        transaksi.tblmodel.getDataVector().removeAllElements();
      transaksi.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from transaksi order by no_transaksi asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              transaksi.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    
    @Override
    public void Baru(View_transaksi transaksi) {
       transaksi.Notransaksi.setText("");
        transaksi.tanggaltransaksi.setText("");
        transaksi.iddokter.setText("");
        transaksi.idmahasiswa.setText("");
        transaksi.biaya.setText("");
    }
    @Override
    public void KlikTabel(View_transaksi transaksi) throws SQLException {
       try {
             int pilih = transaksi.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             transaksi.Notransaksi.setText(transaksi.tblmodel.getValueAt(pilih, 0).toString());
             transaksi.tanggaltransaksi.setText(transaksi.tblmodel.getValueAt(pilih, 1).toString());
             transaksi.idmahasiswa.setText(transaksi.tblmodel.getValueAt(pilih, 2).toString());
             transaksi.iddokter.setText(transaksi.tblmodel.getValueAt(pilih, 3).toString());       
             transaksi.biaya.setText(transaksi.tblmodel.getValueAt(pilih, 4).toString());       
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
