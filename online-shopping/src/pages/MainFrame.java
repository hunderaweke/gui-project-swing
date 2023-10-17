package pages;

import javax.swing.*;

import custom_components.CustomHeader;
import custom_components.CustomLabel;
import custom_components.SideBarButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel sidePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel navigationPanel = new JPanel();
    public String userName;

    MainFrame(String title, String userName) {
        this.userName = userName;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 0));
        navigationPanelContent();
        sidePanelContent(this.userName);
        mainPanel.setBackground(Color.WHITE);
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
        pack();
        setVisible(true);
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    void navigationPanelContent() {
        var heading = new CustomHeader("<html><h1 style='font-size:70rem;'>Online Shopping   </h1></html>");
        heading.setForeground(new Color(255, 255, 255));
        navigationPanel.setBackground(new Color(1, 73, 124));
        navigationPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height / 6));
        navigationPanel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 40, 0, 0);
        navigationPanel.add(heading, gbc);
        this.add(navigationPanel, BorderLayout.PAGE_START);
    }

    void sidePanelContent(String userName) {
        var userProfileButton = new SideBarButton(
                "  User Profile");
        var productsButton = new SideBarButton(
                "󰒚  Products");
        var cartButton = new SideBarButton(
                "󰄐  Cart");
        var paymentButton = new SideBarButton(
                "  Payment");
        var shopIcon = new CustomHeader.BigHeaders("  ");
        shopIcon.setForeground(new Color(255, 255, 255));

        var groupMember = new JPanel();
        groupMember.setBackground(new Color(1, 73, 124));

        var groupMember1 = new CustomLabel("Hundera Awoke");
        var groupMember2 = new CustomLabel("Daniel Merga");
        var groupMember3 = new CustomLabel("Kidus Hailu");
        var groupMember4 = new CustomLabel("Hermela Girma");
        var groupMember5 = new CustomLabel("Yididiya Tesfaye");
        var groupMember6 = new CustomLabel("Lelo Mohammed");
        userProfileButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        productsButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        cartButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        paymentButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        sidePanel.setPreferredSize(new Dimension((screenSize.width / 5) + 10, screenSize.height / 6));
        sidePanel.setBackground(new Color(1, 73, 124));
        sidePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        var productPage = new ProductsPage();
        // var userProfile = pages.UserProfile.getUserData(this.userName);
        mainPanel.add(productPage);
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
                mainPanel.add(new JScrollPane(productPage));
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
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                mainPanel.add(new PaymentPanel(), BorderLayout.CENTER);
                mainPanel.setVisible(true);
            }
        });
        sidePanel.add(userProfileButton);
        sidePanel.add(productsButton);
        sidePanel.add(cartButton);
        sidePanel.add(paymentButton);
        sidePanel.add(shopIcon);
        groupMember.add(groupMember1);
        groupMember.add(groupMember2);
        groupMember.add(groupMember3);
        groupMember.add(groupMember4);
        groupMember.add(groupMember5);
        groupMember.add(groupMember6);
        sidePanel.add(groupMember);
        this.add(sidePanel, BorderLayout.LINE_START);
    }

    public static void main(String[] args) {
        new MainFrame("Online Shopping", "hundera");
    }
}
