package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;


public interface Observer<S extends Observable<S, O, A>,
        O extends Observer<S, O, A>,
        A> {
    public void update(S o, A a);
}
