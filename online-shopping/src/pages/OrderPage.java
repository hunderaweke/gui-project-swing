package pages;

import javax.swing.JPanel;

public class OrderPage extends JPanel {
    public OrderPage(String Products[][]) {
        setLayout(null);
        for (int i = 0; i < Products.length; i++) {
            for (int j = 0; j < Products[i].length; j++) {
                System.out.println(Products[i][j]);
            }
        }
    }
}
