package org.designPatterns.interpreter.Ex_9_4An_interpreter_with_generics;

public abstract class Exp<T> {
    /**
     * One use of trees is to represent expressions in a programming language. As in the
     * previous section, the expression type is represented by an abstract class, with each kind
     * of expression represented by a subclass. There is an abstract method to evaluate an
     * expression, and each subclass implements the method as appropriate for the corresponding kind of expression.
     * With generics, it is possible to parameterize the expression type by the type of the
     * expression. For example, Exp<Integer> is an expression that returns an integer, while
     * Exp<Pair<Integer, Integer>> is an expression that returns a pair of integers.
     * Example 9-4 demonstrates the Interpreter pattern with generics. It begins by defining
     * a class Pair<A, B>, with a constructor and two methods to select the left and right
     * components of a pair. It then declares an abstract class, Exp<A>, for an expression that
     * returns a value of type A, with an abstract method eval that returns a value of type A.
     * In our example, there are five kinds of expression:
     * • An integer literal, of type Exp<Integer>
     * • A sum expression, of type Exp<Integer>, which has two subexpressions, each of
     * type Exp<Integer>
     * • An expression to construct a pair, of type Exp<Pair<A, B>>, which has two subexpressions of type Exp<A> and Exp<B>
     * • An expression to select the left component of a pair, of type Exp<A>, which has a
     * subexpression of type Exp<Pair<A, B>>
     *     An expression to select the right component of a pair, of type Exp<B>, which has a
     * subexpression of type Exp<Pair<A, B>>
     * There are five static methods corresponding to five kinds of expression, each returning
     * an instance of an appropriate subclass of the expression class, with an appropriate
     * definition of the eval method. Finally, the main method constructs and evaluates a
     * sample expression.
     * Generics in Java were inspired by similar features in functional languages such as ML
     * and Haskell. The generic Interpreter pattern is interesting because it shows a way in
     * which generics in Java are more powerful than generics in these other languages. It is
     * not possible to implement this pattern in the standard versions of ML and Haskell,
     * although a recent version of Haskell includes an experimental feature, generalized abstract data types,
     * designed specifically to support this pattern
     * */
    abstract public T eval();

    static Exp<Integer> lit(final int i) {
        return new Exp<Integer>() {
            public Integer eval() {
                return i;
            }
        };
    }

    static Exp<Integer> plus(final Exp<Integer> e1, final Exp<Integer> e2) {
        return new Exp<Integer>() {
            public Integer eval() {
                return e1.eval() + e2.eval();
            }
        };
    }

    static <A, B> Exp<Pair<A, B>> pair(final Exp<A> e1, final Exp<B> e2) {
        return new Exp<Pair<A, B>>() {
            public Pair<A, B> eval() {
                return new Pair<>(e1.eval(), e2.eval());
            }
        };
    }

    static <A, B> Exp<A> left(final Exp<Pair<A, B>> e) {
        return new Exp<A>() {
            public A eval() {
                return e.eval().left();
            }
        };
    }

    static <A, B> Exp<B> right(final Exp<Pair<A, B>> e) {
        return new Exp<B>() {
            public B eval() {
                return e.eval().right();
            }
        };
    }

    public static void main(String[] args) {
        Exp<Integer> e = left(pair(plus(lit(3), lit(4)), lit(5)));
        assert e.eval() == 7;
    }
}
