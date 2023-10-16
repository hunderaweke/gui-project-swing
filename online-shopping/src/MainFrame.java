import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel sidePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel navigationPanel = new JPanel();

    MainFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 0));
        navigationPanelContent();
        sidePanelContent();
        mainPanel.setBackground(Color.WHITE);
        this.add(mainPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setSize(screenSize.width, screenSize.height);
    }

    void navigationPanelContent() {
        var heading = new JLabel(
                "<html><h1 style='font-size:50px; color: rgb(19, 126, 217); font-weight: bold;'>Online Shopping</h1></html>");
        navigationPanel.add(heading);
        navigationPanel.setBackground(Color.WHITE);
        this.add(navigationPanel, BorderLayout.PAGE_START);
    }

    void sidePanelContent() {
        var userProfileButton = new JButton(
                "<html><h2 style='color: rgb(225, 225, 225); font-weight: bold;'>User Profile</h2></html>");
        var productsButton = new JButton(
                "<html><h2 style='color: rgb(225, 225, 225); font-weight: bold;'>Products</h2></html>");
        userProfileButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        productsButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        sidePanel.setPreferredSize(new Dimension((screenSize.width / 5) + 10, screenSize.height / 5));
        sidePanel.setBackground(new Color(19, 126, 217));
        sidePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        userProfileButton.setBackground(new Color(19, 180, 217));
        productsButton.setBackground(new Color(19, 180, 217));
        var productPage = new ProductsPage();
        mainPanel.add(productPage);
        productPage.setVisible(false);
        var userData = UserProfile.getUserData("hundera");
        mainPanel.add(new UserProfilePage(userData));

        // add hover effect for the buttons
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new UserProfilePage(userData));
                mainPanel.revalidate();
                mainPanel.repaint();
                mainPanel.setVisible(true);
            }
        });
        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sidePanel.add(userProfileButton);
        sidePanel.add(productsButton);
        this.add(sidePanel, BorderLayout.LINE_START);
    }

    public static void main(String[] args) {
        new MainFrame("Online Shopping");
    }
}
