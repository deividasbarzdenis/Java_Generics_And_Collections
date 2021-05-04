package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

public class Person extends TaxPayer<Person> {
    public Person(long income, TaxStrategy<Person> strategy) {
        super(income, strategy);
    }
    protected Person getThis() { return this; }
}
