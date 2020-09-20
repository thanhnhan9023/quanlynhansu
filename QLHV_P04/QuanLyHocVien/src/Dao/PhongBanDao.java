/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ChucVu;
import Model.NhanVien;
import Model.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TheLuie
 */
public class PhongBanDao {
     public static  ArrayList<PhongBan> layDachSachPB()
     {
      ArrayList<PhongBan> dspb=new ArrayList<PhongBan>();
        try {
            Connection cons = DBConnect.getConnection();
             String sql="select * from PhongBan";
             PreparedStatement preparedStatement=cons.prepareCall(sql);
             ResultSet rs =preparedStatement.executeQuery();
            while(rs.next())
            {
                PhongBan pb=new PhongBan();
                pb.setMapb(rs.getString("MAPB"));
                pb.setTenpb(rs.getString("TENPB"));
                pb.setDiachi(rs.getString("DIACHI"));
                pb.setSdtpb(rs.getString("SDTPB"));
//                pb.setMAcv(rs.getString("MACV"));
                 dspb.add(pb);
            }
             return dspb;
             
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       return null;
    }
     
     public int ThemPhongBan(PhongBan phongBan) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "insert into PhongBan values  (?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
//            NhanVien nv=new NhanVien();
            ps.setString(1, phongBan.getMapb());
            ps.setString(2, phongBan.getTenpb());
            ps.setString(3, phongBan.getDiachi());
            ps.setString(4, phongBan.getSdtpb());
          
          
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
     public int updateNhanVien(PhongBan phongBan) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Update  PhongBan set DIACHI=?,SDTPB=? where MAPB=? ";
            PreparedStatement ps = cons.prepareStatement(sql);

            ps.setString(1, phongBan.getDiachi());
            ps.setString(2, phongBan.getSdtpb());
            ps.setString(3,phongBan.getMapb());

          
         
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
       public int XoaNhanPb(PhongBan phongBan) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Delete from PhongBan where MAPB=?";
            PreparedStatement ps = cons.prepareStatement(sql);
//            NhanVien nv=new NhanVien();
            ps.setString(1, phongBan.getMapb());
          
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
       
       
        public boolean kiemtramatontai(String ma)
   {
           String sqlselect="select * from  PhongBan where MAPB='"+ma+"'";
       try {
           
           Connection con=DBConnect.getConnection();
           Statement statement=con.createStatement();
           ResultSet rs=statement.executeQuery(sqlselect);
           while(rs.next())
           {
               return  true;
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }
               return false;
   }
        
        
        public ArrayList<ChucVu> loadcombox()
        {  ArrayList<ChucVu> dscv=new ArrayList<ChucVu>();
         try {
           
             String sql="Select * from ChucVu";
             Connection con=DBConnect.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             ChucVu cv;
             while (rs.next()) {
                 cv=new ChucVu(rs.getString(1),rs.getString(2),rs.getFloat(3));
                 dscv.add(cv);
             }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
         return dscv;
                    
           
        }
         
       public boolean kiemtrakhoangoai(String ma)
       {
          try {
              String sqlkiemtra="select * from PhongBan,NhanVien where NhanVien.MAPB=PhongBan.MAPB and  NhanVien.MAPB='"+ma+"'";
              
              Connection con=DBConnect.getConnection();
              Statement statement=con.createStatement();
              ResultSet rs=statement.executeQuery(sqlkiemtra);
              while(rs.next())
              {
                    return  true;
              }
             
           
          } catch (Exception ex) {
             ex.printStackTrace();
          }
          return false;
       }
    }
  


