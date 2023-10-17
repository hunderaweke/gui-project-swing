package custom_components;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;

public class CustomButton extends JButton {
  public CustomButton(String text) {
    super(text);
    setForeground(Color.BLACK);
    addMouseListener(new CustomButtonHoverEffect());
    try {
      Font font;
      InputStream fontStream = new FileInputStream("src/fonts/VictorMonoNerdFont-Bold.ttf");
      font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
      font = font.deriveFont(Font.BOLD);
      setFont(font);
      fontStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (FontFormatException e) {
      e.printStackTrace();
    }
  }
}
