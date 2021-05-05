package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValueView extends JTextField implements CView {
    private final CModel model;
    private final Currency currency;

    public ValueView(final CModel model, final Currency currency) {
        this.model = model;
        this.currency = currency;
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long value = Math.round(100.0 * Double.parseDouble(getText()));
                    model.setValue(currency, value);
                } catch (NumberFormatException x) {
                }
            }
        });
        model.addObserver(this);
    }

    public void update(CModel model, Currency currency) {
        if (currency == null || currency == this.currency) {
            long value = model.getValue(this.currency);
            setText(String.format("%15d.%02d", value / 100, value % 100));
        }
    }
}
