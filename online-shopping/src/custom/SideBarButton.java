package custom;

import java.awt.*;

import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SideBarButton extends CustomButton {
    public SideBarButton(String text) {
        super(text);
        setBackground(new Color(143, 196, 212));
        setForeground(Color.BLACK);
        getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                var model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    setBackground(new Color(205, 234, 226));
                } else {
                    setBackground(new Color(143, 196, 212));
                }
            }
        });

    }
}