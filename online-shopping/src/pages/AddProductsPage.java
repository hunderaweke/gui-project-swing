package pages;

import javax.swing.*;

import custom_components.CustomButton;
import custom_components.CustomInputField;

public class AddProductsPage extends JPanel {

    public AddProductsPage() {
        var addButton = new CustomButton("Add product");
        var productName = new CustomInputField();
        var productPrice = new CustomInputField();
        var imageUrl = new CustomInputField();
        var productDescription = new CustomInputField();
        var catagoryId = 1;

    }
}
