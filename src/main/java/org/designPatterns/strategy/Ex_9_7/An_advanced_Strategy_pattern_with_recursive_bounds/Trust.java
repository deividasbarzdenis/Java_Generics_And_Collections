package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

public class Trust extends TaxPayer<Trust> {
    private boolean nonProfit;
    public Trust(long income, boolean nonProfit, TaxStrategy<Trust> strategy){
        super(income, strategy); this.nonProfit = nonProfit;
    }
    protected Trust getThis() { return this; }
    public boolean isNonProfit() { return nonProfit; }
}
