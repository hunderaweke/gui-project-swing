import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserProfilePage {
    public UserProfilePage() {
    }

    public static void userProfilePage(String[] var0) {
        JFrame var1 = new JFrame("User Profile");
        JPanel var2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int width = getWidth();
                int height = getHeight();

                Color color1 = Color.BLACK;
                Color color2 = new Color(173, 216, 230);

                GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };

        JLabel var3 = new JLabel(var0[0]);
        JLabel var4 = new JLabel(var0[1]);
        JLabel var5 = new JLabel(var0[2]);
        JLabel var6 = new JLabel(var0[3]);
        JLabel var7 = new JLabel(var0[var0.length - 1]);
        JButton var8 = new JButton("Buy A Product");
        var2.setLayout(new GridBagLayout());
        GridBagConstraints var9 = new GridBagConstraints();
        var9.gridx = 0;
        var9.gridy = 0;
        var9.anchor = GridBagConstraints.CENTER;
        var2.add(var3, var9);
        var9.gridy = 1;
        var2.add(var4, var9);
        var9.gridy = 2;
        var9.gridx = 1;
        var2.add(var8, var9);
        var9.gridx = 0;
        var2.add(var6, var9);
        var9.gridy = 3;
        var2.add(var5, var9);
        var9.gridy = 4;
        var2.add(var7, var9);
        var8.addActionListener(e -> var1.dispose());
        var1.add(var2);
        var1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var1.setSize(400, 700);
        var1.setVisible(true);
    }

    public static void main(String[] var0) {
        String[] var1 = UserProfile.getUserData("hundera");
        userProfilePage(var1);
    }
}