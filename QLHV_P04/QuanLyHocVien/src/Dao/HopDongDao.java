/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.HopDong;
import Model.NhanVien;
import Model.PhongBan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.PSource;

/**
 *
 * @author TheLuie
 */
public class HopDongDao {
    
    public static ArrayList<HopDong> laydachsachhd()
    {
        ArrayList<HopDong> dshd=new ArrayList<HopDong>();
        try {
            String sql="Select * from HopDong";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            HopDong hd;
            while (rs.next()) {
                 hd=new HopDong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                dshd.add(hd);
            }
        } catch (Exception ex) {
        ex.printStackTrace();;
        }
        return dshd;
    }
    
    
    
    public static ArrayList<HopDong> gethienthiCSDL(String timkiem) {
         ArrayList<HopDong> dspb =new ArrayList<>();
     try {
          String  sqlselect="Select * from HopDong";
           
   sqlselect = sqlselect + " where MAHD like '%" + timkiem+"%'" +"or MANV like'%"+timkiem+"%'"
           +"or LoaiHD like '%"+timkiem+"%'"+"or NgayBD like'%"+timkiem+"%'" +"or NgayKT like'%"+timkiem+"%'"+
           "or TinhTrang like'%"+timkiem+"%'";
           Connection con=DBConnect.getConnection();
         Statement statement=con.createStatement();
            
            ResultSet rs= statement.executeQuery(sqlselect);
//            dtmtim.setRowCount(0);
          HopDong hd;
            while(rs.next())
            {
                hd=new HopDong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                dspb.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return dspb;
            
}
    
    
    public int Themhopdong(HopDong hopDong) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "insert into HopDong values  (?,?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql);
//            NhanVien nv=new NhanVien();
            ps.setString(1, hopDong.getMAHD());
            ps.setString(2, hopDong.getMaNV());
            ps.setString(3, hopDong.getLoaiHD());
            ps.setString(4, hopDong.getNgayBD());
            ps.setString(5, hopDong.getNgayKT());
            ps.setBoolean(6, hopDong.isTinhTrang());
            
          
         return ps.executeUpdate();
            
        }
         
         catch (SQLException ex) {
            ex.printStackTrace();
        }
         return 0;
    
    
    
}
     public boolean kiemtramatontai(String ma)
   {
           String sqlselect="select * from  HopDong  where MAHD='"+ma+"'";
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
            
      public static  ArrayList<NhanVien> loadcombox()
      {
         ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
          String sqlselect="select * from NhanVien ";
       try {
            Connection cons=DBConnect.getConnection();
           PreparedStatement ps=cons.prepareStatement(sqlselect);
           ResultSet rs=ps.executeQuery();
         
           
           
            NhanVien nv;
           while(rs.next()){
            nv = new NhanVien(rs.getString(1), rs.getString(2),rs.getString(3),rs.getBoolean(4),
                  rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getBoolean(9));
                  dsnv.add(nv);
                   
            dsnv.add(nv);
           }
            
       } catch (SQLException ex) {
          ex.printStackTrace();
       }
       return dsnv;
      }
      
       public int updateHopDonng(HopDong hopDong) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Update  HopDong set MANV=?, LOAIHD=?,NgayBD=?,NgayKT=?,TinhTrang=? where MAHD=? ";
            PreparedStatement ps;

                 ps = cons.prepareStatement(sql);
                    
            ps.setString(1, hopDong.getMaNV());
            ps.setString(2, hopDong.getLoaiHD());
            ps.setString(3, hopDong.getNgayBD());
            ps.setString(4, hopDong.getNgayKT());
            ps.setBoolean(5, hopDong.isTinhTrang());
             ps.setString(6, hopDong.getMAHD());
            
              
                return ps.executeUpdate();
         }
              catch (SQLException ex) {
                 Logger.getLogger(HopDongDao.class.getName()).log(Level.SEVERE, null, ex);
             }
           
         return 0;
        }

      public int DeleteHopdong(HopDong hopDong) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Delete  from HopDong where MAHD=? ";
            PreparedStatement ps;
                 ps = cons.prepareStatement(sql);
            ps.setString(1, hopDong.getMAHD());
                return ps.executeUpdate();
         }
              catch (SQLException ex) {
                 Logger.getLogger(HopDongDao.class.getName()).log(Level.SEVERE, null, ex);
             }
           
         return 0;
        }
      
        public boolean kiemtrakhoangoai(String ma)
       {
           
          try {
              String sqlkiemtra="select NhanVien.MANV from NhanVien,HopDong where HopDong.MANV=NhanVien.MANV and HopDong.MANV='"+ma+"'";
                     
                    
              
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