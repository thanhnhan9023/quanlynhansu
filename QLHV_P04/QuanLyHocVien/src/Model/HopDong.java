/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author TheLuie
 */
public class HopDong {
    private String MAHD;
   private  String MaNV;
   private  String LoaiHD;
    private String NgayBD;
    private String NgayKT;
    private boolean  TinhTrang;

    public HopDong() {
    }

    public HopDong(String MAHD, String MaNV, String LoaiHD, String NgayBD, String NgayKT, boolean TinhTrang) {
        this.MAHD = MAHD;
        this.MaNV = MaNV;
        this.LoaiHD = LoaiHD;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.TinhTrang = TinhTrang;
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getLoaiHD() {
        return LoaiHD;
    }

    public void setLoaiHD(String LoaiHD) {
        this.LoaiHD = LoaiHD;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

   

   
  
    
    
}
