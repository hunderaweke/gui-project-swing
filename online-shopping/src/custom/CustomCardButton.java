package custom;

import java.awt.*;
import java.io.*;

import javax.swing.JButton;

public class CustomCardButton extends JButton {
    public CustomCardButton(String text) {
        super(text);
        setForeground(Color.BLACK);
        addMouseListener(new CustomCardButtonHoverEffect());
        try {
            Font font;
            InputStream fontStream = new FileInputStream("src/fonts/VictorMonoNerdFont-Bold.ttf");
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
