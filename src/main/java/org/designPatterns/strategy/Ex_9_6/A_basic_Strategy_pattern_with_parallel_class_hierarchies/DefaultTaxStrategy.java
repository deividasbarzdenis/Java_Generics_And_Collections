package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

public class DefaultTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {
    private static final double RATE = 0.40;
    public long computeTax(P payer) {
        return Math.round(payer.getIncome() * RATE);
    }
}
