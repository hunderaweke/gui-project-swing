package custom;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class CustomInputField extends JTextField {

  public CustomInputField() {
    setPreferredSize(new Dimension(200, 30));
    setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    setBackground(new Color(192, 192, 192));
    setForeground(Color.black);
    addMouseListener(new CusomTextFieldHoverEffect());
    try {
      Font font;
      InputStream fontStream = new FileInputStream("src/fonts/Supreme-Regular.otf");
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
