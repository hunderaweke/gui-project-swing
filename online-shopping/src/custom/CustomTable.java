package custom;

import java.io.*;
import java.awt.*;
import javax.swing.*;

public class CustomTable extends JTable {
    public CustomTable() {
        super();
        try {
            Font font;
            InputStream fontStream = new FileInputStream("src/fonts/Supreme-Medium.otf");
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            var header = getTableHeader();
            header.setFont(font.deriveFont(18f));
            header.setBackground(new Color(19, 126, 217));
            header.setForeground(Color.WHITE);
            
            setFont(font.deriveFont(14f));
            setRowHeight(20);
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
