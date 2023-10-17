package custom_components;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        setForeground(Color.BLACK);
        try {
            Font font;
            InputStream fontStream = new FileInputStream("src/fonts/VictorMonoNerdFont-Bold.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
            font = font.deriveFont(Font.BOLD);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            setFont(font);
            fontStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    public static class UserNameLabel extends JLabel {
        public UserNameLabel(String text) {
            super(text);
            setForeground(Color.BLACK);
            try {
                Font font;
                InputStream fontStream = new FileInputStream("src/fonts/Supreme-Regular.otf");
                font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(40f);
                font = font.deriveFont(Font.BOLD);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
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

}
