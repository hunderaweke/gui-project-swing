package custom_components;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

public class CustomHeader extends JLabel {
  public CustomHeader(String text) {
    super(text);
    try {
      Font font;
      InputStream fontStream = new FileInputStream("src/fonts/ClashGroteskNerdFont-Bold.otf");
      font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
      GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
      font = font.deriveFont(100f);
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