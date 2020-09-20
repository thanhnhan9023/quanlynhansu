/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ChucVu;
import Model.Luong;
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
 * @author TheLuie
 */
public class DaoChucvu {
    
    public static ArrayList<ChucVu> laydschucvu()
    { 
        ArrayList<ChucVu> dscv=new ArrayList<>();
        try {
           
            String sql="select * from ChucVu";
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
    public  static  ArrayList<Luong> laydsluongloadcombox()
    {
         ArrayList<Luong> dscv=new ArrayList<>();
        try {
           
            String sql="select * from Luong";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
          Luong luong;
            while (rs.next()) {                
                luong =new Luong(rs.getFloat(1),rs.getFloat(2));
                dscv.add(luong);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       return dscv;
        
    }
    
    public int themluongnv(ChucVu chucVu)
    {
        try {
            String sql="Insert into ChucVu values(?,?,?)";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
          
            ps.setString(1,chucVu.getMacv());
            ps.setString(2,chucVu.getTencv());
            ps.setFloat(3,chucVu.getHsl());
                    
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public int updateluongnv(ChucVu chucVu)
    {
        try {
            String sql="Update  ChucVu set TenCV=?,HSL=? where MACV=?";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
          
//            ps.setString(1,chucVu.getMacv());
            ps.setString(1,chucVu.getTencv());
            ps.setFloat(2,chucVu.getHsl());
            ps.setString(3,chucVu.getMacv());
                    
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public int delteluongnv(ChucVu chucVu)
    {
        try {
            String sql="delete from ChucVu where MACV=?";
            Connection con=DBConnect.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
          
            ps.setString(1,chucVu.getMacv());
//            ps.setString(2,chucVu.getTencv());
//            ps.setFloat(2,chucVu.getHsl());
                    
            return ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
        public boolean kiemtramatontai(String ma)
   {
           String sqlselect="select distinct NhanVien.MACV from ChucVu,NhanVien where ChucVu.MACV=NhanVien.MACV and ChucVu.MACV='"+ma+"'";
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
         public boolean kiemtramatontai2(String ma)
   {
           String sqlselect="select Macv from Chucvu where Macv='"+ma+"'";
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
}
