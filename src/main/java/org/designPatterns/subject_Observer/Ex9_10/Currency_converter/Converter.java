package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;

import javax.swing.*;
import java.awt.*;

public class Converter extends JFrame {
    public Converter() {
        CModel model = new CModel();
        setTitle("Currency converter");
        setLayout(new GridLayout(Currency.values().length + 1, 3));
        add(new JLabel("currency"));
        add(new JLabel("rate"));
        add(new JLabel("value"));
        for (Currency currency : Currency.values()) {
            add(new JLabel(currency.name()));
            add(new RateView(model, currency));
            add(new ValueView(model, currency));
        }
        model.initialize(1.0, 0.83, 0.56);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new Converter().setVisible(true);
    }
}
