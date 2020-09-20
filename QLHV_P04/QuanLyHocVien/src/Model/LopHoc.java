package Model;

import java.util.Date;

/**
 *
 * @author TVD
 */
public class LopHoc {

    private int ma_lop_hoc;
    private PhongBan khoaHoc;
    private NhanVien hocVien;
    private Date ngay_dang_ky;
    private boolean tinh_trang;

    public int getMa_lop_hoc() {
        return ma_lop_hoc;
    }

    public void setMa_lop_hoc(int ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
    }

    public PhongBan getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(PhongBan khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public NhanVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(NhanVien hocVien) {
        this.hocVien = hocVien;
    }

    public Date getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public void setNgay_dang_ky(Date ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

}
