package custom_components;

import java.awt.*;

public class SideBarButton extends CustomButton {
    public SideBarButton(String text) {
        super(text);
        setBackground(new Color(143, 196, 212));
        setForeground(Color.BLACK);
    }
}