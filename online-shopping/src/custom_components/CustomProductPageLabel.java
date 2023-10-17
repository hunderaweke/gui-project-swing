package custom_components;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class CustomProductPageLabel {
    public static class PriceLabel extends JLabel {
        public PriceLabel(String text) {
            super(text);
            setForeground(new Color(19, 126, 217));
            try {
                Font font;
                InputStream fontStream = new FileInputStream("src/fonts/Supreme-Regular.otf");
                font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
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

    public static class DescriptionLabel extends JLabel {
        public DescriptionLabel(String text) {
            super(text);
            try {
                Font font;
                InputStream fontStream = new FileInputStream("src/fonts/Supreme-Light.otf");
                font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
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

    public static class NameLabel extends JLabel {
        public NameLabel(String text) {
            super(text);
            try {
                Font font;
                InputStream fontStream = new FileInputStream("src/fonts/Supreme-Regular.otf");
                font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(16f);
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
