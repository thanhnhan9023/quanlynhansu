/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author TheLuie
 */
public class TaiKhoanDao {
     public TaiKhoan login(String tdn, String mk) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM TaiKhoan WHERE UserTk = ? and MatKhau = ?";
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setMaTK(rs.getInt("MaTK"));
                taiKhoan.setTaikhoan(rs.getString("UserTK"));
                taiKhoan.setMatkhau(rs.getString("MatKhau"));
                taiKhoan.setTinhtrang(rs.getBoolean("TinhTrang"));
              
            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }
}
