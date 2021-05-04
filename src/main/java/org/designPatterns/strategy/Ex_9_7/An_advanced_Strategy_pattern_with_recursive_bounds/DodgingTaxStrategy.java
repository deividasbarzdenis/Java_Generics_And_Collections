package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

public class DodgingTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
    public long computeTax(P payer) { return 0; }
}
