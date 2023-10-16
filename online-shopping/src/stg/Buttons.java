package stg;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public class Buttons extends JButton {
    public Buttons(String text) {
        super(text);
        this.setBackground(new Color(1, 73, 124));
        this.setForeground(Color.WHITE);
        this.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    setBackground(new Color(0, 0, 0));
                    setForeground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(1, 73, 124));
                    setForeground(Color.WHITE);
                }
            }

        });

    }
}