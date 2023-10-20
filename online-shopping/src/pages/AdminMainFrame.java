package pages;

import javax.swing.*;

import custom_components.CustomHeader;
import custom_components.SideBarButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminMainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel sidePanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    public String userName = "admin";

    AdminMainFrame(String title) {
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
        var shopIcon = new CustomHeader.BigHeaders(" ");
        shopIcon.setForeground(new Color(255, 255, 255));

        userProfileButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        productsButton.setPreferredSize(new Dimension(screenSize.width / 5, 40));
        sidePanel.setPreferredSize(new Dimension((screenSize.width / 5) + 10, screenSize.height / 6));
        sidePanel.setBackground(new Color(1, 73, 124));
        sidePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        var customerId = getCustomerId(userName);
        var productPage = new ProductsPage(customerId);
        mainPanel.add(productPage);

        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.setVisible(false);
                mainPanel.add(new JScrollPane(productPage));
                mainPanel.setVisible(true);
            }
        });

        sidePanel.add(productsButton);
        sidePanel.add(shopIcon);
        this.add(sidePanel, BorderLayout.LINE_START);
    }

    public int getCustomerId(String userName) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
        var getCustomerIdQuery = "SELECT customer_id FROM Customer WHERE username = ?;";
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            var getCustomerIdStatement = con.prepareStatement(getCustomerIdQuery);
            getCustomerIdStatement.setString(1, userName);
            var getCustomerIdResultSet = getCustomerIdStatement.executeQuery();
            getCustomerIdResultSet.next();
            var customerId = getCustomerIdResultSet.getString("customer_id");
            return Integer.parseInt(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        new AdminMainFrame("Online Shopping");
    }
}