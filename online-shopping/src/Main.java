import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                showGui();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }

    public Main() throws MalformedURLException {
        Icon icon1 = new ImageIcon(new URL(
                "https://pythonanywhere.com/wensal/azure-dress.jpg"));
        Icon icon2 = new ImageIcon(new URL(
                "https://www.cleverpetproducts.com/wp-content/uploads/2018/03/tardar.jpg"));
        Icon icon3 = new ImageIcon(new URL(
                "https://www.cleverpetproducts.com/wp-content/uploads/2018/03/tardar.jpg"));

        String[] columnNames = { "Picture", "Text" };
        Object[][] data = {
                { icon1, "Text 1" },
                { icon2, "Text 2" },
                { icon3, "Text 3" },
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTable table = new JTable(model);
        table.setPreferredSize(new Dimension(500, 500));
        table.getColumn(columnNames[0]).setPreferredWidth(300);
        table.getColumn(columnNames[1]).setPreferredWidth(100);
        table.setRowHeight(0, 100);
        table.setRowHeight(1, 100);
        table.setRowHeight(2, 100);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private static void showGui() throws MalformedURLException {
        JFrame frame = new JFrame("Icon showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

}