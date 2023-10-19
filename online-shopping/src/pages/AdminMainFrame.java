package pages;

import javax.swing.*;

import custom_components.CustomHeader;
import custom_components.SideBarButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel sidePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    public String userName;

    AdminMainFrame(String title, String userName) {
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
        headerPanel.setBackground(new Color(1, 73, 124));
        headerPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height / 6));
        headerPanel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 40, 0, 0);
        headerPanel.add(heading, gbc);
        this.add(headerPanel, BorderLayout.PAGE_START);
    }

    void sidePanelContent(String userName) {
        var userProfileButton = new SideBarButton(
                "  Admin Profile");
        var productsButton = new SideBarButton(
                "󰒚  Products");
        var cartButton = new SideBarButton(
                "󰄐  Cart");
        var shopIcon = new CustomHeader.BigHeaders(" ");
        shopIcon.setForeground(new Color(255, 255, 255));

        userProfileButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        productsButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        cartButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        sidePanel.setPreferredSize(new Dimension((screenSize.width / 5) + 10, screenSize.height / 6));
        sidePanel.setBackground(new Color(1, 73, 124));
        sidePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        var productPage = new ProductsPage("admin");
        mainPanel.add(productPage);
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                mainPanel.add(new UserProfilePage(UserProfile.getUserData(userName)));
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

    }

    });

    sidePanel.add(userProfileButton);sidePanel.add(productsButton);sidePanel.add(cartButton);sidePanel.add(paymentButton);sidePanel.add(aboutUsButton);sidePanel.add(shopIcon);this.add(sidePanel,BorderLayout.LINE_START);}

    public static void main(String[] args) {
        new AdminMainFrame("Online Shopping", "hundera");
    }
}
