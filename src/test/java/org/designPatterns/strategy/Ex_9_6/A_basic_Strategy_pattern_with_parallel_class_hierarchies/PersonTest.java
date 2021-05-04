package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void test(){
        Person person = new Person(10000000);
        Trust nonProfit = new Trust(10000000, true);
        Trust forProfit = new Trust(10000000, false);

        TaxStrategy<Trust> trustStrategy = new TrustTaxStrategyextends();
        assert trustStrategy.computeTax(nonProfit) == 0;
        assert trustStrategy.computeTax(forProfit) == 4000000;
    }

}
