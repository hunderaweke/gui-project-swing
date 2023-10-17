package stg;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class CustomPasswordField extends JPasswordField {
  public CustomPasswordField(int length) {
    setPreferredSize(new Dimension(length, 30));
    setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    setBackground(new Color(192, 192, 192));
    setForeground(Color.black);
    try {
      Font font;
      InputStream fontStream = new FileInputStream("online-shopping/src/fonts/Supreme-Regular.otf");
      font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
      font = font.deriveFont(Font.BOLD);
      setFont(font);
      fontStream.close();
    } catch (IOException e) {
      e.printStackTrace();
      // Handle the IOException appropriately
    } catch (FontFormatException e) {
      e.printStackTrace();
      // Handle the FontFormatException appropriately
    }
  }
}
