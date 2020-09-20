package Model;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author TVD
 */
public class PhongBan {

  private String Mapb;
  private String Tenpb;
  private String Diachi;
  private String Sdtpb;

    public PhongBan() {
    }

    public PhongBan(String Mapb, String Tenpb, String Diachi, String Sdtpb) {
        this.Mapb = Mapb;
        this.Tenpb = Tenpb;
        this.Diachi = Diachi;
        this.Sdtpb = Sdtpb;
      
    }
   

  
    public String getMapb() {
        return Mapb;
    }

    public void setMapb(String Mapb) {
        this.Mapb = Mapb;
    }

    public String getTenpb() {
        return Tenpb;
    }

    public void setTenpb(String Tenpb) {
        this.Tenpb = Tenpb;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdtpb() {
        return Sdtpb;
    }

    public void setSdtpb(String Sdtpb) {
        this.Sdtpb = Sdtpb;
    }


    
  @Override
    public String toString() {
        return Mapb;
    }
  
  

}