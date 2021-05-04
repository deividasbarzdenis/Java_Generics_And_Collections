package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

public interface TaxStrategy<P extends TaxPayer<P>> {
    public long computeTax(P p);
}
