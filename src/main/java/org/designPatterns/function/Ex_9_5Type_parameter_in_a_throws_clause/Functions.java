package org.designPatterns.function.Ex_9_5Type_parameter_in_a_throws_clause;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Functions {
    public static <A, B, X extends Throwable>
    List<B> applyAll(Function<A, B, X> f, List<A> list) throws X {
        List<B> result = new ArrayList<B>(list.size());
        for (A x : list) result.add(f.apply(x));
        return result;
    }
    public static void main(String[] args) {
        Function<String, Integer, Error> length =
                new Function<String, Integer, Error>() {
                    public Integer apply(String s) {
                        return s.length();
                    }
                };
        Function<String, Class<?>, ClassNotFoundException> forName =
                new Function<String, Class<?>, ClassNotFoundException>() {
                    public Class<?> apply(String s)
                            throws ClassNotFoundException {
                        return Class.forName(s);
                    }
                };
        Function<String, Method, Exception> getRunMethod =
                new Function<String, Method, Exception>() {
                    public Method apply(String s)
                            throws ClassNotFoundException,NoSuchMethodException {
                        return Class.forName(s).getMethod("run");
                    }
                };
        List<String> strings = Arrays.asList(args);
        System.out.println(applyAll(length, strings));
        try { System.out.println(applyAll(forName, strings)); }
        catch (ClassNotFoundException e) { System.out.println(e); }
        try { System.out.println(applyAll(getRunMethod, strings)); }
        catch (ClassNotFoundException e) { System.out.println(e); }
        catch (NoSuchMethodException e) { System.out.println(e); }
        catch (RuntimeException e) { throw e; }
        catch (Exception e) { throw new AssertionError(); }
    }
    /**
     * that accepts an argument of type List<A>, returns a result of type List<B>, and again
     * may throw an exception of type X; the method invokes the apply method on each element
     * of the argument list to produce the result list.
     * The main method of the class defines three objects of this type. The first is length of
     * type Function<String, Integer, Error>. It accepts a string and returns an integer,
     * which is the length of the given string. Since it raises no checked exceptions, the third
     * type is set to Error. (Setting it to RuntimeException would work as well.)
     * The second is forName of type Function<String, Class<?>,ClassNotFoundException>. It
     * accepts a string and returns a class, namely the class named by the given string. The
     * apply method may throw a ClassNotFoundException, so this is taken as the third type
     * parameter.
     * The third is getRunMethod of type Function<String, Method, Exception>. It accepts a
     * string and returns a method, namely the method named run in the class named by the
     * given string. The body of the method might raise either a ClassNotFoundException or a
     * NoSuchMethodException, so the third type parameter is taken to be Exception, the smallest class
     * that contains both of these exceptions.
     * This last example shows the chief limitation of giving generic types to exceptions. Often
     * there is no suitable class or interface that contains all exceptions the function may raise,
     * and so you are forced to fall back on using Exception, which is too general to provide
     * useful information.
     * The main method uses applyAll to apply each of the three functions to a list of strings.
     * Each of the three invocations is wrapped in a try statement appropriate to the exceptions it may throw.
     * The length function has no try statement, because it throws no
     * checked exceptions. The forName function has a try statement with a catch clause for
     * ClassNotFoundException, the one kind of exception it may throw. The getRunMethod
     * function requires a try statement with catch clauses for ClassNotFoundException and
     * NoSuchMethodException, the two kinds of exception it may throw. But the function is
     * declared to throw type Exception, so we need two additional “catchall” clauses, one to
     * rethrow any run-time exception that is raised, and one to assert that it is an error if any
     * exception is raised that is not handled by the previous three clauses. For this particular
     * example, re-raising runtime exceptions is not required, but it is good practice if there
     * may be other code that handles such exceptions
     * */
}
