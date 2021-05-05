package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RateView extends JTextField implements CView {
    private final CModel model;
    private final Currency currency;

    public RateView(final CModel model, final Currency currency) {
        this.model = model;
        this.currency = currency;
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rate = Double.parseDouble(getText());
                    model.setRate(currency, rate);
                } catch (NumberFormatException x) {
                }
            }
        });
        model.addObserver(this);
    }

    public void update(CModel model, Currency currency) {
        if (this.currency == currency) {
            double rate = model.getRate(currency);
            setText(String.format("%10.6f", rate));
        }
    }
}
