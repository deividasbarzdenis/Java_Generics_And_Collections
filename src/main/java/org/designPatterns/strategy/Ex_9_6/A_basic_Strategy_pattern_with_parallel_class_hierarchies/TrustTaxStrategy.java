package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

class TrustTaxStrategyextends extends DefaultTaxStrategy<Trust> {
    public long computeTax(Trust trust) {
        return trust.isNonProfit() ? 0 : super.computeTax(trust);
    }
}
