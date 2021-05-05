package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;

import java.util.EnumMap;

public class CModel extends Observable<CModel, CView, Currency> {
    private final EnumMap<Currency, Double> rates;
    private long value = 0; // cents, euro cents, or pence
    private Currency currency = Currency.DOLLAR;

    public CModel() {
        rates = new EnumMap<Currency, Double>(Currency.class);
    }

    public void initialize(double... initialRates) {
        for (int i = 0; i < initialRates.length; i++)
            setRate(Currency.values()[i], initialRates[i]);
    }

    public void setRate(Currency currency, double rate) {
        rates.put(currency, rate);
        setChanged();
        notifyObservers(currency);
    }

    public void setValue(Currency currency, long value) {
        this.currency = currency;
        this.value = value;
        setChanged();
        notifyObservers(null);
    }

    public double getRate(Currency currency) {
        return rates.get(currency);
    }

    public long getValue(Currency currency) {
        if (currency == this.currency)
            return value;
        else
            return Math.round(value * getRate(currency) / getRate(this.currency));
    }
}
