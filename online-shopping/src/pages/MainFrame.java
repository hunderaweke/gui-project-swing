package pages;

import javax.swing.*;

import custom.SideBarButton;
import custom.CustomHeader;

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
        var heading = new CustomHeader("Online Shopping  ");
        heading.setForeground(new Color(19, 126, 217));
        navigationPanel.add(heading);
        navigationPanel.setBackground(Color.WHITE);
        this.add(navigationPanel, BorderLayout.PAGE_START);
    }

    void sidePanelContent(String userName) {
        var userProfileButton = new SideBarButton(
                "  User Profile");
        var productsButton = new SideBarButton(
                "󰒚  Products");
        var cartButton = new SideBarButton(
                "󰄐  Cart");
        var PaymentPanel = new SideBarButton(
                "payment panal");

        userProfileButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        productsButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        cartButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        sidePanel.setPreferredSize(new Dimension((screenSize.width / 5) + 10, screenSize.height / 5));
        sidePanel.setBackground(new Color(1, 73, 124));
        sidePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
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
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                mainPanel.add(new CartItems(), BorderLayout.CENTER);
                mainPanel.setVisible(true);
            }
        });
        sidePanel.add(userProfileButton);
        sidePanel.add(productsButton);
        sidePanel.add(cartButton);
        this.add(sidePanel, BorderLayout.LINE_START);
    }

    public static void main(String[] args) {
        new MainFrame("Online Shopping", "hundera");
    }
}
