/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller_request;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Db_Koneksi;
import view.View_request;

/**
 *
 * @author abednego(11315020)
 */
public class model_request implements Controller_request {
    
    @Override
    public void Request(View_request req) throws SQLException {
        try {
           
            String txtidrequest = "";
            Connection con = Db_Koneksi.getKoneksi();
            String sql = "insert request_berobat values(null,?,?,?,?, DEFAULT)";
            PreparedStatement prepare= con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            // prepare.setString(1, req.txtidobat.getText());
            prepare.setString(1, req.txtidmahasiswa.getText());
            prepare.setString(2, req.txtnamamahasiswa.getText());
            prepare.setString(3, req.txttanggalberobat.getText());
            prepare.setString(4, req.txtpukul.getText());
            prepare.executeUpdate();
            // Using the getGeneratedKeys() method to retrieve
            // the key(s). In this case there is only one key column
            ResultSet keyResultSet = prepare.getGeneratedKeys();
            int newrequestId = 0;
            if (keyResultSet.next()) {
                newrequestId = (int) keyResultSet.getInt(1);
                txtidrequest = String.valueOf(newrequestId);
            }
            
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            Baru(req);
        }
    }
    @Override
    public void Print(View_request req) throws SQLException {
        int y=0;
        Frame fr = new Frame();
        
        PrintJob print = fr.getToolkit().getPrintJob(fr, "Form Request", null,null);
        
        Graphics g = print.getGraphics();
        if(g!=null){
            g.setFont(new Font("Verdana",1,15));
            g.drawString("Form Request Berobat", 40, 65);
            g.setFont(new Font("Microsoft San Serif : ",1,11));
            g.drawString("Diberikan Izin Berobat Kepada: ", 40, 110);
            //ambil data dari form
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk  tanggal
            g.drawString("NIM : ", 40, 125);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String tanggal = req.txtidmahasiswa.getText();
            g.drawString(tanggal, 100, 125);
            
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk NIM
            g.drawString("Nama : ", 40, 140);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String nim = req.txtnamamahasiswa.getText();
            g.drawString(nim, 100, 140);
            
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk nama
            g.drawString("Tanggal : ", 40, 155);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String nama = req.txttanggalberobat.getText();
            g.drawString(nama, 100, 155);
            
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk kelas
            g.drawString("Pukul : ", 40, 170);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String kelas = req.txtpukul.getText();
            g.drawString(kelas, 100, 170);
            
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk keperluam
            g.drawString("Keperluan : ", 40, 185);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String keperluan = "Izin Berobat ke Klinik Del";
            g.drawString(keperluan, 100, 185);
            
            /* g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk informaasi
            g.drawString("Informasi : ", 40, 200);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String informasi = ur.areaInformation.getText();
            g.drawString(informasi, 100, 200); */
            
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk tanda tangan
            g.drawString("Pemohon  ", 90, 240);
            g.setFont(new Font("Microsoft San Serif",0,10));
            String nama2 = req.txtnamamahasiswa.getText();
            g.drawString("("+nama2+")", 70, 290);
            
            g.setFont(new Font("Microsoft San Serif : ",0,10)); // untuk tanda tangan
            g.drawString("Petugas  ", 340, 240);
            g.setFont(new Font("Microsoft San Serif",0,10));
            g.drawString("(........................................)", 310, 290);
            
            g.setFont(new Font("Microsoft San Serif : ",2,10)); // untuk catatan
            g.drawString("*Form ini wajib ditandatangani pihak petugas dan pihak pemohon", 40, 350);
            g.setFont(new Font("Microsoft San Serif : ",2,10)); // untuk nama
            g.drawString("*Form ini diserahkan kepada petugas Satpam", 40, 365);
            
            g.drawLine(40, 400, 600, 400); // untuk garis
            
            g.setFont(new Font("Microsoft San Serif : ",1,10)); // untuk tanda tangan petugas ketertiban
            g.drawString("Realisasi Izin (diisi petugas Satpam) : ", 40, 420);
            g.setFont(new Font("Microsoft San Serif",0,10));
            g.drawString("Pukul : ", 40, 435);
            g.setFont(new Font("Microsoft San Serif : ",0,10)); 
            g.drawString("Petugas  ", 40, 450);
            g.setFont(new Font("Microsoft San Serif",0,10));
            g.drawString("(........................................)", 40, 500);
            
            g.setFont(new Font("Verdana",1,11));
            g.setFont(new Font("Dialog",1,11));
        }
        print.end();
    }
    
   
    @Override
    public void Baru(View_request req) {
       req.txtidmahasiswa.setText("");
        req.txtnamamahasiswa.setText("");
        req.txttanggalberobat.setText("");
        req.txtpukul.setText("");
    }

   

    
}
