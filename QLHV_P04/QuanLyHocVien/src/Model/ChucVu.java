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
public class ChucVu {
   private String macv;
    private String Tencv;
    private float hsl;

    public ChucVu(String macv, String Tencv, float hsl) {
        this.macv = macv;
        this.Tencv = Tencv;
        this.hsl = hsl;
    }

    public ChucVu() {
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return Tencv;
    }

    public void setTencv(String Tencv) {
        this.Tencv = Tencv;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }

    @Override
    public String toString() {
        return   macv;
    }
    
    
}
