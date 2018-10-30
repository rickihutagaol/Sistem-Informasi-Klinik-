/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_Supplier;

/**
 *
 * @author stu
 */
public class model_supplier implements Controller_Supplier{
    
            @Override
    public void Simpan(View_Supplier Supplier) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert Supplier values(?,?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, Supplier.id.getText());
            prepare.setString(2, Supplier.nama.getText());
            prepare.setString(3, Supplier.Distributor.getText());
            prepare.setString(4, Supplier.Alamat.getText());
            prepare.setString(5, Supplier.No.getText());
            
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(Supplier);
            Supplier.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_Supplier Supplier) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update Supplier set nama_suplier= ?, distributor= ?,alamat = ?,no_telepon = ? where id_Supplier= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(5, Supplier.id.getText());
            prepare.setString(1, Supplier.nama.getText());
            prepare.setString(2, Supplier.Distributor.getText());
            prepare.setString(3, Supplier.Alamat.getText());
            prepare.setString(4, Supplier.No.getText());
            
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(Supplier);
            Supplier.setLebarKolom();
            Baru(Supplier);
        }
    }

    @Override
    public void Hapus(View_Supplier Supplier) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from Supplier where id_supplier= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, Supplier.id.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(Supplier);
            Supplier.setLebarKolom();
            Baru(Supplier);
        }
    }
 
    @Override
    public void Tampil(View_Supplier Supplier) throws SQLException {
        Supplier.tblmodel.getDataVector().removeAllElements();
      Supplier.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from Supplier order by id_supplier asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              Supplier.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_Supplier Supplier) {
        Supplier.id.setText("");
        Supplier.nama.setText("");
        Supplier.Distributor.setText("");
        Supplier.Alamat.setText("");
        Supplier.No.setText("");
    
    }

    @Override
    public void KlikTabel(View_Supplier Supplier) throws SQLException {
       try {
             int pilih = Supplier.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             Supplier.id.setText(Supplier.tblmodel.getValueAt(pilih, 0).toString());
             Supplier.nama.setText(Supplier.tblmodel.getValueAt(pilih, 1).toString());
             Supplier.Distributor.setText(Supplier.tblmodel.getValueAt(pilih, 2).toString());
             Supplier.Alamat.setText(Supplier.tblmodel.getValueAt(pilih, 3).toString());         
             Supplier.No.setText(Supplier.tblmodel.getValueAt(pilih, 4).toString());         
        
       } catch (Exception e) {
            System.out.print(e);
        }
        
    }

}
