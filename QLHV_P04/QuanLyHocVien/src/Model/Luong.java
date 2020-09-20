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
public class Luong {
    private float hsl;
    private float lcb;

    public Luong() {
    }

    public Luong(float hsl, float lcb) {
        this.hsl = hsl;
        this.lcb = lcb;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }

    public float getLcb() {
        return lcb;
    }

    public void setLcb(float lcb) {
        this.lcb = lcb;
    }

    @Override
    public String toString() {
        return  hsl+"" ;
    }
    
    
}
