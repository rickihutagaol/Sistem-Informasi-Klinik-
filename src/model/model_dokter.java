/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_dokter;
import controller.Controller_obat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_dokter;

/**
 *
 * @author abednego(11315020)
 */
public class model_dokter implements Controller_dokter{
       
    @Override
    public void Simpan(View_dokter dokter) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert dokter values(?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, dokter.txtiddokter.getText());
            prepare.setString(2, dokter.txtnamadokter.getText());
            prepare.setString(3, dokter.txtalamat.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(dokter);
            dokter.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_dokter dokter) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update dokter set nama= ?, alamat= ? where id_dokter= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(3, dokter.txtiddokter.getText());
            prepare.setString(1, dokter.txtnamadokter.getText());
            prepare.setString(2, dokter.txtalamat.getText());
          
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(dokter);
            dokter.setLebarKolom();
            Baru(dokter);
        }
    }

    @Override
    public void Hapus(View_dokter dokter) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from dokter where id_dokter= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, dokter.txtiddokter.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(dokter);
            dokter.setLebarKolom();
            Baru(dokter);
        }
    }

    @Override
    public void Tampil(View_dokter dokter) throws SQLException {
        dokter.tblmodel.getDataVector().removeAllElements();
        dokter.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from dokter order by id_dokter asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[100];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              dokter.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_dokter dokter) {
        dokter.txtiddokter.setText("");
        dokter.txtnamadokter.setText("");
        dokter.txtalamat.setText("");
    }

    @Override
    public void KlikTabel(View_dokter dokter) throws SQLException {
       try {
             int pilih = dokter.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             dokter.txtiddokter.setText(dokter.tblmodel.getValueAt(pilih, 0).toString());
             dokter.txtnamadokter.setText(dokter.tblmodel.getValueAt(pilih, 1).toString());
             dokter.txtalamat.setText(dokter.tblmodel.getValueAt(pilih, 2).toString());      
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
}
