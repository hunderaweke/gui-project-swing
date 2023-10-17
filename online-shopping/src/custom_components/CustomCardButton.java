package custom_components;

import java.awt.*;
import java.io.*;

import javax.swing.JButton;

public class CustomCardButton extends JButton {
    public CustomCardButton(String text) {
        super(text);
        setForeground(Color.WHITE);
        addMouseListener(new CustomCardButtonHoverEffect());
        setBackground(new Color(19, 126, 217));
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
