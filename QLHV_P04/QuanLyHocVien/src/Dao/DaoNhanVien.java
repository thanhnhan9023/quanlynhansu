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
import java.util.List;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheLuie
 */
public class DaoNhanVien {
    
      public static  ArrayList<NhanVien> layDachSachNV()
    {
        ArrayList<NhanVien> dsNV=new ArrayList<NhanVien>();
        try {
            Connection cons = DBConnect.getConnection();
             String sql="select * from NhanVien";
             PreparedStatement preparedStatement=cons.prepareCall(sql);
             ResultSet rs =preparedStatement.executeQuery();
            while(rs.next())
            {
               NhanVien nv=new NhanVien();
                nv.setMANV(rs.getString("MANV"));
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setNGSINH(rs.getString("NGSINH"));
                nv.setGIOITINH(rs.getBoolean("GIOITINH"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setSODT(rs.getString("SODT"));
                nv.setMAPB(rs.getString("MAPB"));
                nv.setMACV(rs.getString("MACV"));
                nv.setTinhTrang(rs.getBoolean("TinhTrang"));
                 dsNV.add(nv);
            }
             return dsNV;
             
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       return null;
    }
      public int ThemNhanVien(NhanVien nhanVien) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "insert into NhanVien values  (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
//            NhanVien nv=new NhanVien();
            ps.setString(1, nhanVien.getMANV());
            ps.setString(2, nhanVien.getHoTen());
            ps.setString(3, nhanVien.getNGSINH());
            ps.setBoolean(4, nhanVien.isGIOITINH());
            ps.setString(5, nhanVien.getDiaChi());
            ps.setString(6, nhanVien.getSODT());
            ps.setString(7, nhanVien.getMAPB());
            ps.setString(8, nhanVien.getMACV());
            ps.setBoolean(9, nhanVien.isTinhTrang());
           
           
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
      public static  ArrayList<PhongBan> loadcombox()
      {
         ArrayList<PhongBan> dspb=new ArrayList<PhongBan>();
          String sqlselect="select * from PhongBan ";
       try {
            Connection cons=DBConnect.getConnection();
           PreparedStatement ps=cons.prepareStatement(sqlselect);
           ResultSet rs=ps.executeQuery();
         
           
           
            PhongBan pb;
           while(rs.next()){
            pb = new PhongBan(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4));
            dspb.add(pb);
           }
            
       } catch (SQLException ex) {
          ex.printStackTrace();
       }
          
      return dspb;
      }
      public int XoaNhanVien(NhanVien nhanVien) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Delete from NhanVien where MANV=?";
            PreparedStatement ps = cons.prepareStatement(sql);
//            NhanVien nv=new NhanVien();
            ps.setString(1, nhanVien.getMANV());
          
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
       public int updateNhanVien(NhanVien nhanVien) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Update  NhanVien set HOTEN=?,NGSINH=?,GIOITINH=?,DIACHI=?,SODT=?,MAPB=?,MACV=?,TinhTrang=? where MANV=? ";
            PreparedStatement ps = cons.prepareStatement(sql);
//            NhanVien nv=new NhanVien();
            ps.setString(1, nhanVien.getHoTen());
            ps.setString(2, nhanVien.getNGSINH());
            ps.setBoolean(3, nhanVien.isGIOITINH());
            ps.setString(4, nhanVien.getDiaChi());
            ps.setString(5, nhanVien.getSODT());
            ps.setString(6, nhanVien.getMAPB());
            ps.setString(7, nhanVien.getMACV());
              ps.setBoolean(8, nhanVien.isTinhTrang());
             ps.setString(9, nhanVien.getMANV());
           
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    }
       public static ArrayList<NhanVien> layDSNvTheopb(String mapb)
       {
           ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
           try {
               String sql="select * from NhanVien where MAPB='"+"'";
           Connection con=DBConnect.getConnection();
               Statement statement=con.createStatement();
//            PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs=statement.executeQuery(sql);
               NhanVien nv;
           while(rs.next())
           {
                  nv = new NhanVien(rs.getString(1), rs.getString(2),rs.getString(3),rs.getBoolean(4),
                  rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getBoolean(9));
                  dsnv.add(nv);
                   
           }
                   
               
           } catch (Exception e) {
           }
         
           return dsnv;
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
       
       
         public boolean kiemtramatontai(String ma)
   {
           String sqlselect="select * from  NhanVien  where MANV='"+ma+"'";
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
          public boolean kiemtrakhoangoai2(String ma)
       {
          try {
              String sqlkiemtra="select distinct NhanVien.MACV from ChucVu,NhanVien where ChucVu.MACV=NhanVien.MACV and ChucVu.MACV='"+ma+"'";
              
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
         public static ArrayList<ChucVu> laydschucvu()
    { 
        ArrayList<ChucVu> dscv=new ArrayList<>();
        try {
           
            String sql="select * from ChucVu ";
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
}
