package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;

public interface Docs {
    /**
     * We finish with a more extended example, illustrating the generic Subject-Observer
     * pattern. Like the Strategy pattern, the Subject-Observer pattern uses parallel class hierarchies,
     * but this time we require two type variables with mutually recursive bounds,
     * one to stand for the specific kind of subject and one to stand for the specific kind of
     * observer. This is our first example of type variables with mutually recursive bounds.
     * The Java library implements a nongeneric version of the Subject-Observer pattern in
     * the package java.util with the class Observable and the interface Observer (the former
     * corresponding to the subject), signatures for which are shown in Example 9-8.
     * The Observable class contains methods to register observers (addObserver), to indicate
     * that the observable has changed (setChanged), and to notify all observers of any changes
     * (notifyObservers), among others. The notifyObservers method may accept an arbitrary argument
     * of type Object that is to be broadcast to all the observers. The
     * Observer interface specifies the update method that is called by notifyObservers. This
     * method takes two parameters: the first, of type Observable, is the subject that has
     * changed; the second, of type Object, is the broadcast argument.
     * package java.util;
     * public interface Observer {
     * public void update(Observable o, Object arg);
     * }
     * Example 9-9. Observable and Observer with generics
     * package java.util;
     * class StubException extends UnsupportedOperationException {}
     * public class Observable<S extends Observable<S,O,A>,
     * O extends Observer<S,O,A>,
     * A>
     * {
     * public void addObserver(O o) { throw new StubException(); }
     * protected void clearChanged() { throw new StubException(); }
     * public int countObservers() { throw new StubException(); }
     * public void deleteObserver(O o) { throw new StubException(); }
     * public boolean hasChanged() { throw new StubException(); }
     * public void notifyObservers() { throw new StubException(); }
     * public void notifyObservers(A a) { throw new StubException(); }
     * protected void setChanged() { throw new StubException(); }
     * }
     * package java.util;
     * public interface Observer<S extends Observable<S,O,A>,
     * O extends Observer<S,O,A>,
     * A>
     * {
     * public void update(S o, A a);
     * }
     * As a demonstration client for Observable and Observer, a currency converter is presented in Example 9-10.
     * A screenshot of the converter is shown in Figure 9-1. The converter
     * allows you to enter conversion rates for each of three currencies (dollars, euros, and
     * pounds), and to enter a value under any currency. Changing the entry for a rate causes
     * the corresponding value to be recomputed; changing the entry for a value causes all the
     * values to be recomputed.
     * The client instantiates the pattern by declaring CModel to be a subclass of Observable,
     * and CView to be a subinterface of Observer. Furthermore, the argument type is instantiated to Currency,
     * an enumerated type, which can be used to inform an observer which
     * components of the subject have changed. Here are the relevant headers:
     * enum Currency { DOLLAR, EURO, POUND }
     * class CModel extends Observable<CModel, CView, Currency>
     * interface CView extends Observer<CModel, CView, Currency>
     * The classes RateView and ValueView implement CView, and the class Converter defines
     * the top-level frame which controls the display.
     * The CModel class has a method to set and get the rate and value for a given currency.
     * Rates are stored in a map that assigns a rate to each currency, and the value is stored
     * (as a long,
     * in cents, euro cents, or pence) together with its actual currency. To compute the value
     * for a given currency, the value is divided by the rate for its actual currency and multiplied
     * by the rate for the given currency.
     * The CModel class invokes the update method of RateView whenever a rate is changed,
     * passing the corresponding currency as the argument (because only the rate and value
     * for that currency need to be updated); and it invokes the update method of ValueView
     * whenever a value is changed, passing null as the argument (because the values for all
     * currencies need to be updated).
     * We compile and run the code as follows. First, we compile the generic versions of
     * Observable and Observer:
     * % javac -d . java/util/Observable.java java/util/Observer.java
     * Since these are in the package java.util, they must be kept in the subdirectory java/
     * util of the current directory. Second, we compile Converter and related classes in
     * package com.eg.converter. By default, the Java compiler first searches the current directory
     * for class files (even for the standard library). So the compiler uses the stub class
     * files generated for Observable and Observer, which have the correct generic signature
     * (but no runnable code):
     * % javac -d . com/eg/converter/Converter.java
     * Third, we run the class file for the converter. By default, the java runtime does not first
     * search the current directory for class files in the packages java and javax—for reasons
     * of security, these are always taken from the standard library. So the runtime uses the
     * standard class files for Observable and Observer, which contain the legacy code we want
     * to run (but do not have the correct generic signature):
     * */
}
