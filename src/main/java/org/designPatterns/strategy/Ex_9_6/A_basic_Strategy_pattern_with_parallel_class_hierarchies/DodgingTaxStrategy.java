package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

public class DodgingTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {
    public long computeTax(P payer) { return 0; }
}
