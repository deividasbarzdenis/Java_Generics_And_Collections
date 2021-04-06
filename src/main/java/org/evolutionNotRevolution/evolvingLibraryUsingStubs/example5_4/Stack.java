package org.evolutionNotRevolution.evolvingLibraryUsingStubs.example5_4;

public interface Stack<E> {
    /**
     * The stubs technique is shown in Example 5-4. Here we write stubs with generic signatures but no bodies.
     * We compile the generic client against the generic signatures, but
     * run the code against the legacy class files. This technique is appropriate when the source
     * is not released, or when others are responsible for maintaining the source.
     * To be precise, we introduce the same modifications to interface and class declarations
     * and method signatures as with the minimal changes technique, except we completely
     * delete all executable code, replacing each method body with code that throws a Stu
     * bException (a new exception that extends UnsupportedOperationException).
     * When we compile the generic client, we do so against the class files generated from the
     * stub code, which contain appropriate generic signatures (say, in directory s). When we
     * run the client, we do so against the original legacy class files (say, in directory l).
     * % javac -classpath s g/Client.java
     * % java -ea -classpath l g/Client
     * Again, this works because the class files generated for legacy and generic files are essentially
     * identical, save for auxiliary information about the types. In particular, the
     * generic signatures that the client is compiled against match the legacy signatures (apart
     * from auxiliary information about type parameters), so the code runs successfully and
     * gives the same answer as previously
     *
     * Example 5-4. Evolving a library using stubs:
     * */

    public boolean empty();
    public void push(E elt);
    public E pop();
}
