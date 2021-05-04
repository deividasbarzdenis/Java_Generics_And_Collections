package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

public interface TaxStrategy<P extends TaxPayer>  {
    public long computeTax(P p);
}
