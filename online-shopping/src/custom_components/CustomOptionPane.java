package custom_components;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

public class CustomOptionPane extends JOptionPane {
    public CustomOptionPane() {
        super();
        try {
            Font font;
            InputStream fontStream = new FileInputStream("src/fonts/Supreme-Medium.otf");
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            setFont(font.deriveFont(18f));
            setBackground(new Color(19, 126, 217));
            setForeground(Color.WHITE);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the IOException appropriately
        } catch (FontFormatException e) {
            e.printStackTrace();
            // Handle the FontFormatException appropriately
        }
    }

    public static void main(String[] args) {
        // CustomOptionPane customOptionPane = new CustomOptionPane();
        CustomOptionPane.showMessageDialog(null, "Hello World!");
    }
}
