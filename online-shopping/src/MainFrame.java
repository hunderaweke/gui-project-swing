import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel sidePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel navigationPanel = new JPanel();

    MainFrame(String title, String userName) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 0));
        navigationPanelContent();
        sidePanelContent(userName);
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

    void sidePanelContent(String userName) {
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
        new UserProfile();
        var userProfile = UserProfile.getUserData(userName);
        mainPanel.add(new UserProfilePage(userProfile));
        // add hover effect for the buttons
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                mainPanel.add(new UserProfilePage(UserProfile.getUserData("hundera")));
                mainPanel.setVisible(true);
            }
        });
        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                mainPanel.add(productPage);
                mainPanel.setVisible(true);
            }
        });
        sidePanel.add(userProfileButton);
        sidePanel.add(productsButton);
        this.add(sidePanel, BorderLayout.LINE_START);
    }

}
