package org.designPatterns.strategy.Ex_9_6.A_basic_Strategy_pattern_with_parallel_class_hierarchies;

public abstract class TaxPayer {
    /**
     * Parallel Class Hierarchies A typical use of the Strategy pattern is for tax computation,
     * as shown in Example 9-6. We have a class TaxPayer with subclasses Person and Trust.
     * Every tax payer has an income, and, in addition, a trust may be nonprofit. For example,
     * we
     * */
    public long income; // in cents
    public TaxPayer(long income) { this.income = income; }
    public long getIncome() { return income; }

    /**
     * may define a person with an income of $100,000.00 and two trusts with the same
     * income, one nonprofit and one otherwise:
     *
     * Person person = new Person(10000000);
     * Trust nonProfit = new Trust(10000000, true);
     * Trust forProfit = new Trust(10000000, false);
     *
     * In accordance with good practice, we represent all monetary values, such as incomes
     * or taxes, by long integers standing for the value in cents (see the item “Avoid float and
     * double if exact answers are required”, in the General Programming chapter of Effective
     * Java by Joshua Bloch, Addison-Wesley).
     * For each tax payer P there may be many possible strategies for computing tax. Each
     * strategy implements the interface TaxStrategy<P>, which specifies a method compute
     * Tax that takes as argument a tax payer of type P and returns the tax paid. Class Default
     * TaxStrategy computes the tax by multiplying the income by a fixed tax rate of 40 percent,
     * while class DodgingTaxStrategy always computes a tax of zero:
     *
     * TaxStrategy<Person> defaultStrategy = new DefaultStrategy<Person>();
     * TaxStrategy<Person> dodgingStrategy = new DodgingStrategy<Person>();
     * assert defaultStrategy.computeTax(person) == 4000000;
     * assert dodgingStrategy.computeTax(person) == 0;
     *
     * Of course, our example is simplified for purposes of illustration—we do not recommend that
     * you compute taxes using either of these strategies! But it should be clear
     * how these techniques extend to more complex tax payers and tax strategies.
     * Finally, class TrustTaxStrategy computes a tax of zero if the trust is nonprofit and uses
     * the default tax strategy otherwise:
     *
     * TaxStrategy<Trust> trustStrategy = new TrustTaxStrategy();
     * assert trustStrategy.computeTax(nonProfit) == 0;
     * assert trustStrategy.computeTax(forProfit) == 4000000;
     *
     * Generics allow us to specialize a given tax strategy to a given type of tax payer, and
     * allow the compiler to detect when a tax strategy is applied to the wrong type of tax
     * payer:
     *
     * trustStrategy.computeTax(person); // compile-time error
     *
     * Without generics, the computeTax method of TrustTaxStrategy would have to accept
     * an argument of type TaxPayer and cast it to type Trust, and errors would throw an
     * exception at run time rather than be caught at compile time.
     * This example illustrates a structuring technique found in many object-oriented programs—that
     * of parallel class hierarchies. In this case, one class hierarchy consists of
     * TaxPayer, Person, and Trust. A parallel class hierarchy consists of strategies corresponding
     * to each of these: two strategies, DefaultTaxStrategy and DodgingTaxStrat
     * egy apply to any TaxPayer, no specialized strategies apply to Person, and there is one
     * specialized strategy for Trust.
     * Usually, there is some connection between such parallel hierarchies. In this case, the
     * computeTax method for a TaxStrategy that is parallel to a given TaxPayer expects an
     * argument that is of the corresponding type; for instance, the computeTax method for
     * TrustTaxStrategy expects an argument of type Trust. With generics, we can capture
     * this connection neatly in the types themselves. In this case, the computeTax method for
     * TaxStrategy<P> expects an argument of type P, where P must be subclass of TaxPayer.
     * Using the techniques we have described here, generics can often be used to capture
     * similar relations in other parallel class hierarchies.
     * */
}
