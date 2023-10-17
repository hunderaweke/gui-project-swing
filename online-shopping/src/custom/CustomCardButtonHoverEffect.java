package custom;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;

public class CustomCardButtonHoverEffect extends MouseAdapter {
    private Color originalBackground;

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        originalBackground = button.getBackground();
        button.setBackground(new Color(205, 234, 226));
        button.setForeground(Color.BLACK);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(originalBackground);
        button.setForeground(Color.WHITE);
    }
}
