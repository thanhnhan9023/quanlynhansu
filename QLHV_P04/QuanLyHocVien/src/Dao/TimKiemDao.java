/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.PhongBan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author TheLuie
 */
public class TimKiemDao {
     public static ArrayList<PhongBan> gethienthiCSDL(String timkiem) {
         ArrayList<PhongBan> dspb =new ArrayList<>();
     try {
          String  sqlselect="Select * from PhongBan";
           if (timkiem.length() > 0) {
   sqlselect = sqlselect + " where MAPB like '%" + timkiem+"%'" +"or TENPB like'%"+timkiem+"%'"
           +"or DIACHI like '%"+timkiem+"%'"+"or SDTPB like'%"+timkiem+"%'";
           }
         
      
   
           Connection con=DBConnect.getConnection();
         Statement statement=con.createStatement();
            
            ResultSet rs= statement.executeQuery(sqlselect);
//            dtmtim.setRowCount(0);
            PhongBan pb;
            while(rs.next())
            {
                pb=new PhongBan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                dspb.add(pb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return dspb;
            
}
}
