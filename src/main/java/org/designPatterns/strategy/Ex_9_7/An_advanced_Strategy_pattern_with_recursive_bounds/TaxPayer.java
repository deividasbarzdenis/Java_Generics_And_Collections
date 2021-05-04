package org.designPatterns.strategy.Ex_9_7.An_advanced_Strategy_pattern_with_recursive_bounds;

abstract class TaxPayer<P extends TaxPayer<P>>  {
    /**
     * An Advanced Strategy Pattern with Recursive Generics In more advanced uses of
     * the Strategy pattern, an object contains the strategy to be applied to it. Modelling this
     * situation requires recursive generic types and exploits a trick to assign a generic type
     * to this.
     * The revised Strategy pattern is shown in Example 9-7. In the advanced version, each
     * tax payer object contains its own tax strategy, and the constructor for each kind of tax
     * payer includes a tax strategy as an additional argument:
     * Person normal = new Person(10000000, new DefaultTaxStrategy<Person>());
     * Person dodger = new Person(10000000, new DodgingTaxStrategy<Person>());
     * Trust nonProfit = new Trust(10000000, true, new TrustTaxStrategy());
     * Trust forProfit = new Trust(10000000, false, new TrustTaxStrategy());
     * Now we may invoke a computeTax method of no arguments directly on the tax payer,
     * which will in turn invoke the computeTax method of the tax strategy, passing it the tax
     * payer:
     * assert normal.computeTax() == 4000000;
     * assert dodger.computeTax() == 0;
     * assert nonProfit.computeTax() == 0;
     * assert forProfit.computeTax() == 4000000;
     * This structure is often preferable, since one may associate a given tax strategy directly
     * with a given tax payer.
     * Before, we used a class TaxPayer and an interface TaxStrategy<P>, where the type variable P
     * stands for the subclass of TaxPayer to which the strategy applies. Now we must
     * add the type parameter P to both, in order that the class TaxPayer<P> can have a field
     * of type TaxStrategy<P>. The new declaration for the type variable P is necessarily recursive,
     * as seen in the new header for the TaxPayer class:
     * class TaxPayer<P extends TaxPayer<P>>
     * We have seen similar recursive headers before:
     * interface Comparable<T extends Comparable<T>>
     * class Enum<E extends Enum<E>>
     * In all three cases, the class or interface is the base class of a type hierarchy, and the type
     * parameter stands for a specific subclass of the base class. Thus, P in TaxPayer<P> stands
     * for the specific kind of tax payer, such as Person or Trust; just as T in Comparable<T>
     * stands for the specific class being compared, such as String; or E in Enum<E> stands for
     * the specific enumerated type, such as Season.
     * The tax payer class contains a field for the tax strategy and a method that passes the
     * tax payer to the tax strategy, as well as a recursive declaration for P just like the one
     * used in TaxPayer. In outline, we might expect it to look like this:
     * // not well-typed!
     * class TaxPayer<P extends TaxPayer<P>> {
     * private TaxStrategy<P> strategy;
     * public long computeTax() { return strategy.computeTax(this); }
     * ...
     * }
     * class Person extends TaxPayer<Person> { ... }
     * class Trust extends TaxPayer<Trust> { ... }
     * But the compiler rejects the above with a type error. The problem is that this has type
     * TaxPayer<P>, whereas the argument to computeTax must have type P. Indeed, within
     * each specific tax payer class, such as Person or Trust, it is the case that this does have
     * type P; for example, Person extends TaxPayer<Person>, so P is the same as Person within
     * this class. So, in fact, this will have the same type as P, but the type system does not
     * know that!
     * We can fix this problem with a trick. In the base class TaxPayer<P> we define an abstract
     * method getThis that is intended to return the same value as this but gives it the type
     * P. The method is instantiated in each class that corresponds to a specific kind of tax
     * payer, such as Person or Trust, where the type of this is indeed the same as the type
     * P. In outline, the corrected code now looks like this:
     * // now correctly typed
     * abstract class TaxPayer<P extends TaxPayer<P>> {
     * private TaxStrategy<P> strategy;
     * protected abstract P getThis();
     * public long computeTax() { return strategy.computeTax(getThis()); }
     * ...
     * }
     * final class Person extends TaxPayer<Person> {
     * protected Person getThis() { return this; }
     * ...
     * }
     * final class Trust extends TaxPayer<Trust> {
     * protected Trust getThis() { return this; }
     * ...
     * }
     * The differences from the previous code are in bold. Occurences of this are replaced by
     * calls to getThis; the method getThis is declared abstract in the base class and it is
     * instantiated appropriately in each final subclass of the base class. The base class Tax
     * Payer<P> must be declared abstract because it declares the type for getThis but doesn’t
     * declare the body. The body for getThis is declared in the final subclasses Person and
     * Trust.
     * Since Trust is declared final, it cannot have subclasses. Say we wanted a subclass
     * NonProfitTrust of Trust. Then not only would we have to remove the final declaration
     * on the class Trust, we would also need to add a type parameter to it. Here is a sketch
     * of the required code:
     * abstract class Trust<T extends Trust<T>> extends TaxPayer<T> { ... }
     * final class NonProfitTrust extends Trust<NonProfitTrust> { ... }
     * final class ForProfitTrust extends Trust<ForProfitTrust> { ... }
     * */
    public long income; // in cents
    private TaxStrategy<P> strategy;
    public TaxPayer(long income, TaxStrategy<P> strategy) {
        this.income = income; this.strategy = strategy;
    }
    protected abstract P getThis();
    public long getIncome() { return income; }
    public long computeTax() { return strategy.computeTax(getThis()); }
}
