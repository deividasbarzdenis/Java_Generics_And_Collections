package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

public class Trust extends TaxPayer {

    private boolean nonProfit;

    public Trust(long income, boolean nonProfit) {
        super(income);
        this.nonProfit = nonProfit;
    }

    public boolean isNonProfit() {
        return nonProfit;
    }
}
