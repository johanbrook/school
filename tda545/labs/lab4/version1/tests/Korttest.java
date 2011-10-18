import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;

 class OvalIcon implements Icon {
   private int w, h;        // bredd och höjd
   private Color color;
   private boolean filled;  // ifylld eller inte
   public OvalIcon(int width, int height, Color col, boolean fi){
     w = width; h = height; color = col; filled = fi;
   }
   public int getIconWidth() { 
     return w; 
   }
   public int getIconHeight() { 
     return h; 
   }
   public void paintIcon(Component c, Graphics g, int x, int y) {
     g.setColor(color);
     if (filled)
       g.fillOval(x, y, w, h);
     else
       g.drawOval(x, y, w, h);
   }
 }
 
public class Korttest extends JFrame implements ActionListener {
  OvalIcon i1 = new OvalIcon(50, 50, Color.red, true);
  OvalIcon i2 = new OvalIcon(50, 50, Color.yellow, true);
  OvalIcon i4 = new OvalIcon(50, 50, Color.black, true);
  Kort k1 = new Kort(i1);
  Kort k2 = new Kort(i2, Kort.Status.DOLT);
  Kort k3;
  Kort k4 = new Kort(i4, Kort.Status.SYNLIGT);
  JPanel p = new JPanel();
  int test = 1;
  JLabel lab = new JLabel("Test 1: Nu skall det visas en vit knapp. Klicka på knappen!", JLabel.CENTER);
  
  public Korttest() {
    setTitle("Korttest");
    if (!(k1 instanceof JButton)) {
      showMessageDialog(null, "Klassen Kort är ingen JButton");
      System.exit(1);
    }
    add(lab, BorderLayout.NORTH);
    add(p, BorderLayout.CENTER);
    p.add(k1);
    k1.addActionListener(this);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    k1.setPreferredSize(new Dimension(100, 70));
    k1.setFocusPainted(false); k2.setFocusPainted(false); 
    setSize(450,150);
    centrera();
    setVisible(true);
  }

  private void centrera() {
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((int)(d.getWidth()-getSize().getWidth())/2,
                (int)(d.getHeight()-getSize().getHeight())/2);
  }    

  public void actionPerformed(ActionEvent e) {     
    if (test == 1) { 
      if (k1.getStatus() != Kort.Status.SAKNAS) {
        showMessageDialog(this, "Fel status i konstruktorn eller i getStatus");
        System.exit(1);
      }
      k1.setStatus(Kort.Status.DOLT);
      lab.setText("Test 2: Nu skall det visas en blå knapp. Klicka på knappen!");
    }
    else if (test == 2) {
      if (k1.getStatus() != Kort.Status.DOLT) {
        showMessageDialog(this, "Fel i getStatus eller setStatus");
        System.exit(1);
      }
      k1.setStatus(Kort.Status.SYNLIGT);
      lab.setText("Test 3: Nu skall det visas en blå knapp med en röd cirkel. Klicka på knappen!");
    }  
    else if (test == 3) {
      if (k1.getStatus() != Kort.Status.SYNLIGT) {
        showMessageDialog(this, "Fel i getStatus eller setStatus");
        System.exit(1);
      }
      k1.setStatus(Kort.Status.DOLT);
      lab.setText("Test 4: Nu skall det visas en blå knapp. Klicka på knappen!");
    } 
    else if (test == 4) {
      if (k1.getStatus() != Kort.Status.DOLT) {
        showMessageDialog(this, "Fel i getStatus eller setStatus");
        System.exit(1);
      }
      k1.setStatus(Kort.Status.SYNLIGT);
      lab.setText("Test 5: Nu skall det visas en blå knapp med en röd cirkel. Klicka på knappen!");
    } 
    else if (test == 5) {
      if (k1.getStatus() != Kort.Status.SYNLIGT) {
        showMessageDialog(this, "Fel i getStatus eller setStatus");
        System.exit(1);
      }
      k1.setStatus(Kort.Status.SAKNAS);
      lab.setText("Test 6: Nu skall det visas en vit knapp. Klicka på knappen!");
    }   
    else if (test == 6) {
      if (k1.getStatus() != Kort.Status.SAKNAS) {
        showMessageDialog(this, "Fel i getStatus eller setStatus");
        System.exit(1);
      }
      p.remove(k1);
      p.add(k2, BorderLayout.CENTER);
      k2.setPreferredSize(new Dimension(100, 70));
      k2.addActionListener(this);
      lab.setText("Test 7: Nu skall det visas en blå knapp. Klicka på knappen!");
    }
    else if (test == 7) {
      if (k2.getStatus() != Kort.Status.DOLT) {
        showMessageDialog(this, "Fel status i konstruktorn eller i getStatus");
        System.exit(1);
      }
      p.remove(k2);
      k3 = k2.copy();
      p.add(k3, BorderLayout.CENTER);
      k3.setPreferredSize(new Dimension(100, 70));
      k3.addActionListener(this);
      if (!k3.sammaBild(k2) || k3 == k2) {
		System.out.println(k3 == k2);
		System.out.println("SammaBild: " + k3.sammaBild(k2));
        showMessageDialog(this, "Fel i copy eller sammaBild");
        System.exit(1);
      }
      k3.setStatus(Kort.Status.SYNLIGT);
      lab.setText("Test 8: Nu skall det visas en blå knapp med en gul cirkel. Klicka på knappen!");
    }
    else if (test == 8) {
      if (k3.getStatus() != Kort.Status.SYNLIGT) {
        showMessageDialog(this, "Fel i getStatus eller setStatus");
        System.exit(1);
      }
      p.remove(k3);
      p.add(k4, BorderLayout.CENTER);
      k4.setPreferredSize(new Dimension(100, 70));
      k4.setBackground(Color.yellow); 
      k4.addActionListener(this);
      lab.setText("Test 9: Nu skall det visas en gul knapp med en svart cirkel. Klicka på knappen!");
    }
    else if (test == 9) {
      if (k4.getStatus() != Kort.Status.SYNLIGT) {
        showMessageDialog(this, "Fel status i konstruktorn eller i getStatus");
        System.exit(1);
      }
      showMessageDialog(this, "Grattis! Inga fel funna!");
      System.exit(0);
    }
    test++;
  }

  public static void main(String[] arg) {
    new Korttest();
  }
}
