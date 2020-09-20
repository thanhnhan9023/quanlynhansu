/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TheLuie
 */
public class TaiKhoan {
    private int MaTK;
    private String taikhoan;
    private String matkhau;
    private boolean  tinhtrang;

    public TaiKhoan(int MaTK, String taikhoan, String matkhau, boolean tinhtrang) {
        this.MaTK = MaTK;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.tinhtrang = tinhtrang;
    }

    public TaiKhoan() {
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int MaTK) {
        this.MaTK = MaTK;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

   
}
