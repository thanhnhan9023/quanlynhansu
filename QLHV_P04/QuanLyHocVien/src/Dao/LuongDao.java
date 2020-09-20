/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ChucVu;
import Model.HopDong;
import Model.Luong;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheLuiedsl
 */
public class LuongDao {
    public static ArrayList<Luong> hienthiluong()
    {   
        ArrayList<Luong> dsl=new ArrayList<Luong>();
        try {
        
            String sql="select * from Luong";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Luong luong;
            while (rs.next()) {                
                luong =new Luong(rs.getFloat(1), rs.getFloat(2));
                dsl.add(luong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
                   }
        return dsl;
       
    }
    
    public int themluongnv(Luong luong)
    {
        try {
            String sql="Insert into Luong values(?,?)";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
          
            ps.setFloat(1,luong.getHsl());
            ps.setFloat(2,luong.getLcb());
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
     public int updateHopdong(Luong luong) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Update  Luong set LuongCB=? where HSL=? ";
            PreparedStatement ps;
                 ps = cons.prepareStatement(sql);
            ps.setFloat(1, luong.getLcb());
            ps.setFloat(2,luong.getHsl());
            
                return ps.executeUpdate();
         }
              catch (SQLException ex) {
                 Logger.getLogger(HopDongDao.class.getName()).log(Level.SEVERE, null, ex);
             }
           
         return 0;
        }
    public int DeleteHopdong(Luong luong) {
         try {
            Connection cons = DBConnect.getConnection();
            String sql = "Delete  from Luong where HSL=? ";
            PreparedStatement ps;
                 ps = cons.prepareStatement(sql);
            ps.setFloat(1, luong.getHsl());
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
              String sqlkiemtra="select distinct ChucVu.HSL  from luong,ChucVu where ChucVu.HSL=luong.HSL and ChucVu.HSL='"+ma+"'";
                     
                    
              
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

         public boolean kiemtrachodelete(String ma)
       {
           
          try {
              String sqlkiemtra="select HSL from luong where HSL='4'"+ma+"'";
                     
                    
              
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
           public boolean kiemtrachodelete2(String ma)
       {
           
          try {
              String sqlkiemtra="select* from luong where HSL='4'"+ma+"'";
                     
                    
              
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
