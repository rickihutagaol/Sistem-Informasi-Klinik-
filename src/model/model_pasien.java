/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_pasien;

/**
 *
 * @author abednego(11315020)
 */
public class model_pasien implements Controller_pasien {
       
    @Override
    public void Simpan(View_pasien psn) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert pasien values(?,?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, psn.txtidpasien.getText());
            prepare.setString(2, psn.txtnamapasien.getText());
            prepare.setString(3, psn.txttanggallahir.getText());
            prepare.setString(4, (String) psn.cbprodi.getSelectedItem());
            prepare.setString(5, psn.txtangkatan.getText());
            prepare.executeUpdate();
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(psn);
            psn.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_pasien psn) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update pasien set nama= ?, tgl_lahir= ?, prodi=?, angkatan= ? where id_mahasiswa= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(5, psn.txtidpasien.getText());
            prepare.setString(1, psn.txtnamapasien.getText());
            prepare.setString(2, psn.txttanggallahir.getText());
            prepare.setString(3, (String) psn.cbprodi.getSelectedItem());
            prepare.setString(4, psn.txtangkatan.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(psn);
            psn.setLebarKolom();
            Baru(psn);
        }
    }

    @Override
    public void Hapus(View_pasien psn) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from pasien where id_mahasiswa= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, psn.txtidpasien.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(psn);
            psn.setLebarKolom();
            Baru(psn);
        }
    }

    @Override
    public void Tampil(View_pasien psn) throws SQLException {
        psn.tblmodel.getDataVector().removeAllElements();
      psn.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from pasien order by id_mahasiswa asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              psn.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_pasien psn) {
       psn.txtidpasien.setText("");
        psn.txtnamapasien.setText("");
        psn.txttanggallahir.setText("");
        psn.cbprodi.setSelectedIndex(0);
        psn.txtangkatan.setText("");
    }

    @Override
    public void KlikTabel(View_pasien psn) throws SQLException {
       try {
             int pilih = psn.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             psn.txtidpasien.setText(psn.tblmodel.getValueAt(pilih, 0).toString());
             psn.txtnamapasien.setText(psn.tblmodel.getValueAt(pilih, 1).toString());
             psn.txttanggallahir.setText(psn.tblmodel.getValueAt(pilih, 2).toString());
             psn.cbprodi.setSelectedItem(psn.tblmodel.getValueAt(pilih, 3).toString());
             psn.txtangkatan.setText(psn.tblmodel.getValueAt(pilih, 3).toString());         
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
   
}
