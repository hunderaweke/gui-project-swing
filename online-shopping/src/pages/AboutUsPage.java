package pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import custom_components.CustomLabel;

public class AboutUsPage extends JPanel {

    public AboutUsPage() {
        var groupMember1 = new CustomLabel("Hundera Awoke");
        var groupMember2 = new CustomLabel("Daniel Merga");
        var groupMember3 = new CustomLabel("Kidus Hailu");
        var groupMember4 = new CustomLabel("Hermela Girma");
        var groupMember5 = new CustomLabel("Yididiya Tesfaye");
        var groupMember6 = new CustomLabel("Lelo Mohammed");
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(groupMember1, gbc);
        gbc.gridy = 1;
        add(groupMember2, gbc);
        gbc.gridy = 2;
        add(groupMember3, gbc);
        gbc.gridy = 3;
        add(groupMember4, gbc);
        gbc.gridy = 4;
        add(groupMember5, gbc);
        gbc.gridy = 5;
        add(groupMember6, gbc);

    }

}
