
package demoCuda;











import Clock.SecondCounterDemo;
import Clock.StarDemoEx;
import Gui.DangNhapJDialog;
import cakhia.PuffEx;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheKing
 */
public class NewJFrame extends  javax.swing.JFrame implements Runnable{
     private volatile boolean keepRunning;

    private Font paintFont = new Font("SansSerif", Font.BOLD, 14);

    private volatile String timeMsg = "never started";

    private volatile int arcLen = 0;
      SecondCounterDemo scm = new SecondCounterDemo();
    Thread thread = null;
 SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());

  Date currentDate;

  int xcenter = 100, ycenter = 100, lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0,
      lastyh = 0;
 
//  public void paint(Graphics g) {
//      g.setColor(Color.black);
//      g.setFont(paintFont);
//      g.drawString(timeMsg, 0, 15);
//
//      g.fillOval(0, 20, 100, 100);
//
//      g.setColor(Color.white);
//      g.fillOval(3, 23, 94, 94);
//
//      g.setColor(Color.red);
//      g.fillArc(2, 22, 96, 96, 90, -arcLen);
//    }
  private void drawStructure(Graphics g) {
    g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
    g.setColor(Color.blue);
    g.drawOval(xcenter - 50, ycenter - 50, 100, 100);
    g.setColor(Color.darkGray);
    g.drawString("9", xcenter - 45, ycenter + 3);
    g.drawString("3", xcenter + 40, ycenter + 3);
    g.drawString("12", xcenter - 5, ycenter - 37);
    g.drawString("6", xcenter - 3, ycenter + 45);

  }
  public void paint(Graphics g) {
    int xhour, yhour, xminute, yminute, xsecond, ysecond, second, minute, hour;
    drawStructure(g);

    currentDate = new Date();
    
    formatter.applyPattern("s");
    second = Integer.parseInt(formatter.format(currentDate));
    formatter.applyPattern("m");
    minute = Integer.parseInt(formatter.format(currentDate));

    formatter.applyPattern("h");
    hour = Integer.parseInt(formatter.format(currentDate));

    xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 45 + xcenter);
    ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 45 + ycenter);
    xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 40 + xcenter);
    yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 40 + ycenter);
    xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 30 + xcenter);
    yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 30 + ycenter);

    // Erase if necessary, and redraw
    g.setColor(Color.lightGray);
    if (xsecond != lastxs || ysecond != lastys) {
      g.drawLine(xcenter, ycenter, lastxs, lastys);
    }
    if (xminute != lastxm || yminute != lastym) {
      g.drawLine(xcenter, ycenter - 1, lastxm, lastym);
      g.drawLine(xcenter - 1, ycenter, lastxm, lastym);
    }
    if (xhour != lastxh || yhour != lastyh) {
      g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);
      g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);
    }
    
    g.setColor(Color.darkGray);
    g.drawLine(xcenter, ycenter, xsecond, ysecond);
   
    g.setColor(Color.red);
    g.drawLine(xcenter, ycenter - 1, xminute, yminute);
    g.drawLine(xcenter - 1, ycenter, xminute, yminute);
    g.drawLine(xcenter, ycenter - 1, xhour, yhour);
    g.drawLine(xcenter - 1, ycenter, xhour, yhour);
    lastxs = xsecond;
    lastys = ysecond;
    lastxm = xminute;
    lastym = yminute;
    lastxh = xhour;
    lastyh = yhour;
  }
   public void start1() {
    if (thread == null) {
      thread = new Thread (this);
      thread.start();
    }
  }
     public void stop1() {
    thread = null;
  }
    public void run() {
    while (thread != null) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }
      repaint();
    }
    thread = null;
  }

  
    public NewJFrame() {
        initComponents();
    }
    
      void  sad()
      {
       for(int i=0;i<10000;i++)
                    {
                      proba1.setValue(i);
                      proba1.repaint();
                      proba1.setString(Integer.toString(i)+"%");
                      try{
                          Thread.sleep(100);
                      }
                      catch(Exception ex)
                      {
                          ex.printStackTrace();
                      }
                    }
       
       for(int i=0;i<10000;i++)
               {
                   proba2.setValue(i);
                   proba2.repaint();
                   proba2.setString(Integer.toString(i)+"%");
                 try{
                          Thread.sleep(200);
                      }
                      catch(Exception ex)
                      {
                          ex.printStackTrace();
                      }
               }
      };
       class bat implements Runnable{
             public void run()
             {
                   for(int i=0;i<101;i++)
                    {
                      proba1.setValue(i);
                      proba1.repaint();
                      proba1.setString(Integer.toString(i)+"%");
                      try{
                          Thread.sleep(200);
                      }
                      catch(Exception ex)
                      {
                          ex.printStackTrace();
                      }
                    }
                   
             }
            }
             class knight extends  Thread{
              public void run()
              {
               for(int i=0;i<101;i++)
               {
                   start1();
                   proba2.setValue(i);
                   proba2.repaint();
                   proba2.setString(Integer.toString(i)+"%");
                 try{
                          Thread.sleep(200);
                      }
                      catch(Exception ex)
                      {
                          ex.printStackTrace();
                      }
               }
                  
                stop1();
               
                
               
              }
             }
          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        proba1 = new javax.swing.JProgressBar();
        proba2 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        proba1.setBackground(new java.awt.Color(255, 204, 204));
        proba1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        proba1.setForeground(new java.awt.Color(204, 255, 204));
        proba1.setStringPainted(true);

        proba2.setBackground(new java.awt.Color(255, 204, 204));
        proba2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        proba2.setForeground(new java.awt.Color(255, 255, 102));
        proba2.setStringPainted(true);

        jButton1.setText("Thực Hiện ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quản Lý");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(proba2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(proba1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proba1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proba2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        for(int i=0;i<3;i++)
        {
           EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
 
                PuffEx ex = new PuffEx();
                ex.setVisible(true);
            }
        });      
        }
    

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                StarDemoEx ex = new StarDemoEx();
                ex.setVisible(true);
            }
        });

        JFrame f = new JFrame();
        f.setContentPane(scm);
        f.setSize(320, 200);
        f.setVisible(true);

        bat t=new bat();
        Thread bat=new Thread(t);
        bat.start();
        knight t2=new knight();
        t2.start();

    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar proba1;
    private javax.swing.JProgressBar proba2;
    // End of variables declaration                   
}
