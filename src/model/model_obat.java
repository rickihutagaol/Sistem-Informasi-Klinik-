/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_obat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_obat;

/**
 *
 * @author abednego(11315020)
 */
public class model_obat implements Controller_obat{
       
    @Override
    public void Simpan(View_obat obt) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert stok_obat values(?,?,?,?,?)";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, obt.txtidobat.getText());
            prepare.setString(2, obt.txtnamaobat.getText());
            prepare.setString(3, obt.txtharga.getText());
            prepare.setString(4, obt.txtstok.getText());
            prepare.setString(5, obt.txtidsupplier.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(obt);
            obt.setLebarKolom();
        }
    }

    @Override
    public void Ubah(View_obat obt) throws SQLException {
         try {
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "update stok_obat set nama_obat= ?, harga= ?, stok_obat= ?, id_supplier = ? where id_obat= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(5, obt.txtidobat.getText());
            prepare.setString(1, obt.txtnamaobat.getText());
            prepare.setString(2, obt.txtharga.getText());
            prepare.setString(3, obt.txtstok.getText());
            prepare.setString(4, obt.txtidsupplier.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(obt);
            obt.setLebarKolom();
            Baru(obt);
        }
    }

    @Override
    public void Hapus(View_obat obt) throws SQLException {
        try {
           
            
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "delete  from stok_obat where id_obat= ?";
            PreparedStatement prepare= con.prepareStatement(sql);
            
            prepare.setString(1, obt.txtidobat.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Tampil(obt);
            obt.setLebarKolom();
            Baru(obt);
        }
    }

    @Override
    public void Tampil(View_obat obt) throws SQLException {
        obt.tblmodel.getDataVector().removeAllElements();
      obt.tblmodel.fireTableDataChanged();
      try {
          Connection con = Db_Koneksi.getKoneksi();
          Statement stt = con.createStatement();
          String sql = "select * from stok_obat order by id_obat asc";
          ResultSet res = stt.executeQuery(sql);
          while(res.next())
          {
              Object[] ob= new Object[8];
              ob[0] = res.getString(1);
              ob[1] = res.getString(2);
              ob[2] = res.getString(3);
              ob[3] = res.getString(4);
              ob[4] = res.getString(5);
              obt.tblmodel.addRow(ob);
          } 
      } catch (Exception e) {
          System.out.println(e);
      }
    }

    @Override
    public void Baru(View_obat obt) {
       obt.txtidobat.setText("");
        obt.txtnamaobat.setText("");
        obt.txtstok.setText("");
        obt.txtharga.setText("");
        obt.txtidsupplier.setText("");
    }

    @Override
    public void KlikTabel(View_obat obt) throws SQLException {
       try {
             int pilih = obt.tabel.getSelectedRow();
             if (pilih == -1 ){    
                 return;
             }
             obt.txtidobat.setText(obt.tblmodel.getValueAt(pilih, 0).toString());
             obt.txtnamaobat.setText(obt.tblmodel.getValueAt(pilih, 1).toString());
             obt.txtharga.setText(obt.tblmodel.getValueAt(pilih, 2).toString());
             obt.txtstok.setText(obt.tblmodel.getValueAt(pilih, 3).toString());
             obt.txtidsupplier.setText(obt.tblmodel.getValueAt(pilih, 4).toString());  
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
   
}
