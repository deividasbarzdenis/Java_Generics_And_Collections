package org.collections.The_Collection_Interface.Using_the_Methods_of_Collection;

public class EmptyTask extends Task{
    /**
     * For compactness, the toString method on phone tasks only returns the name of the
     * person to call and not the phone number. We assume we never create two phone tasks
     * with the same name and different numbers; if we did, it would be wrong to test equality
     * using the result returned by toString.
     * We also define an empty task:
     * */
    public EmptyTask() {}
    public String toString() { return ""; }
}
