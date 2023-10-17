package custom;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CusomTextFieldHoverEffect extends MouseAdapter {
  private Color originalBackground;

  @Override
  public void mouseEntered(MouseEvent e) {
    JTextField textField = (JTextField) e.getSource();
    originalBackground = textField.getBackground();
    textField.setBackground(Color.WHITE);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    JTextField textField = (JTextField) e.getSource();
    textField.setBackground(originalBackground);
  }
}