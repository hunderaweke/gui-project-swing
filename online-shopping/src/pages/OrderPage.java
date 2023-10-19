package pages;

import javax.swing.*;

import custom_components.CustomButton;
import custom_components.CustomInputField;

public class OrderPage extends JDialog {
    CustomButton orderButton;
    CustomInputField orderPrice;
    int priceSum = 0;

    public OrderPage(String Products[][]) {
        setLayout(null);
        for (String[] product : Products) {
            for (int i = 0; i < product.length; i++) {
                if (i == 1) {
                    priceSum += Integer.parseInt(product[i]);
                }
            }
        }
        System.out.println(priceSum);
    }
}
