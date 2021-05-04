package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void test(){
        Person normal = new Person(10000000, new DefaultTaxStrategy<Person>());
        Person dodger = new Person(10000000, new DodgingTaxStrategy<Person>());
        Trust nonProfit = new Trust(10000000, true, new TrustTaxStrategy());
        Trust forProfit = new Trust(10000000, false, new TrustTaxStrategy());

        assert normal.computeTax() == 4000000;
        assert dodger.computeTax() == 0;
        assert nonProfit.computeTax() == 0;
        assert forProfit.computeTax() == 4000000;

    }

}
