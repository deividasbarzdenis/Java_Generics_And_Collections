package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

public class DefaultTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
    private static final double RATE = 0.40;
    public long computeTax(P payer) {
        return Math.round(payer.getIncome() * RATE);
    }
}
