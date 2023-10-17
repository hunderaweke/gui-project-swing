package pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import custom_components.CustomLabel;

public class AboutUsPage extends JPanel {

    public AboutUsPage() {
        var groupHeading = new CustomLabel("Name                ID");
        var groupMember1 = new CustomLabel("Hundera Awoke            UGR/25358/14");
        var groupMember2 = new CustomLabel("Daniel Merga             UGR/25699/14");
        var groupMember3 = new CustomLabel("Kidus Hailu              UGR/25309/14");
        var groupMember4 = new CustomLabel("Hermela Girma            UGR/26306/14");
        var groupMember5 = new CustomLabel("Yididiya Tesfaye         UGR/25451/14");
        var groupMember6 = new CustomLabel("Lelo Mohammed            UGR/25557/14");
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(groupHeading, gbc);
        gbc.gridy = 1;
        add(groupMember1, gbc);
        gbc.gridy = 2;
        add(groupMember2, gbc);
        gbc.gridy = 3;
        add(groupMember3, gbc);
        gbc.gridy = 4;
        add(groupMember4, gbc);
        gbc.gridy = 5;
        add(groupMember5, gbc);
        gbc.gridy = 6;
        add(groupMember6, gbc);

    }

}
