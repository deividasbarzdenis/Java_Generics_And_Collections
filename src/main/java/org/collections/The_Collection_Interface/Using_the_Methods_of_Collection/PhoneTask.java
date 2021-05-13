package org.collections.The_Collection_Interface.Using_the_Methods_of_Collection;

public final class PhoneTask extends Task{
    private final String name;
    private final String number;
    public PhoneTask(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public String getName() { return name; }
    public String getNumber() { return number; }
    public String toString() { return "phone " + name; }

    /**
     * A coding task is specified by a string, and a phone task is specified by the name and
     * number of the person to be called. In each case we provide a constructor for the class,
     * methods to access its fields, and a way to convert it to a string. In accordance with good
     * practice, we have made both kinds of task immutable by declaring the fields to be
     * final, and we have declared both subclasses to be final so that no one can later define
     * mutable subclasses (see item “Minimize mutability”/“Favor immutability”) in Chapter
     * 4 of Effective Java by Joshua Bloch, Addison-Wesley).
     * The toString method prefaces every coding task with the string "code" and every phone
     * task with the string "phone“. Since the first precedes the second in alphabetic order, and
     * since tasks are ordered according to the results returned by toString, it follows that
     * coding tasks come before phone tasks in the natural ordering on tasks. This suits our
     * needs—we are geeks, after all!
     * For compactness, the toString method on phone tasks only returns the name of the
     * person to call and not the phone number. We assume we never create two phone tasks
     * with the same name and different numbers; if we did, it would be wrong to test equality
     * using the result returned by toString.
     * */
}
