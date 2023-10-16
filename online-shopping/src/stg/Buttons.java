package stg;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public class Buttons extends JButton {
    public Buttons(String text) {
        super(text);
        this.setBackground(new Color(143, 196, 212));
        this.setForeground(Color.BLACK);
        this.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    setBackground(new Color(205, 234, 226));
                    setForeground(Color.BLACK);
                } else {
                    setBackground(new Color(143, 196, 212));
                    setForeground(Color.BLACK);
                }
            }

        });

    }
}