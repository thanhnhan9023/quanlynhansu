/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.HopDong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TheLuie
 */
public class ThongKeDao {
    
     public ArrayList<HopDong> getListByLopHoc() {
        Connection cons = DBConnect.getConnection();
        String sql = "select NgayBD ,count (*) as'SoLuong' from HopDong";
         ArrayList<HopDong> list=new ArrayList<>();
//        List<LopHocBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                LopHocBean lopHocBean = new LopHocBean();
                HopDong hopDong=new HopDong();
                hopDong.setMAHD(rs.getString("MAHD"));
                hopDong.setMaNV(rs.getString("MANV"));
                hopDong.setLoaiHD(rs.getString("LoaiHD"));
                hopDong.setNgayBD(rs.getString("NgayBD"));
                hopDong.setNgayKT(rs.getString("NgayKT"));
                hopDong.setTinhTrang(rs.getBoolean("TinhTrang"));
//             
                list.add(hopDong);
            }
            
         
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
