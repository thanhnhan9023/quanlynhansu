package Model;

import java.util.Date;

/**
 *
 * @author TVD
 */
public class NhanVien {

   private String MANV;
   private String HoTen;
   private String NGSINH;
   private boolean GIOITINH;
   private String DiaChi;
   private String SODT;
   private String MAPB;
   private String MACV;
   private boolean TinhTrang;

    public NhanVien() {
    }

    public NhanVien(String MANV, String HoTen, String NGSINH, boolean GIOITINH, String DiaChi, String SODT, String MAPB, String MACV, boolean TinhTrang) {
        this.MANV = MANV;
        this.HoTen = HoTen;
        this.NGSINH = NGSINH;
        this.GIOITINH = GIOITINH;
        this.DiaChi = DiaChi;
        this.SODT = SODT;
        this.MAPB = MAPB;
        this.MACV = MACV;
        this.TinhTrang = TinhTrang;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNGSINH() {
        return NGSINH;
    }

    public void setNGSINH(String NGSINH) {
        this.NGSINH = NGSINH;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSODT() {
        return SODT;
    }

    public void setSODT(String SODT) {
        this.SODT = SODT;
    }

    public String getMAPB() {
        return MAPB;
    }

    public void setMAPB(String MAPB) {
        this.MAPB = MAPB;
    }

    public String getMACV() {
        return MACV;
    }

    public void setMACV(String MACV) {
        this.MACV = MACV;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

 

    
    @Override
    public String toString() {
        return MANV ;
    }

   
   
   
   
   
   
}
