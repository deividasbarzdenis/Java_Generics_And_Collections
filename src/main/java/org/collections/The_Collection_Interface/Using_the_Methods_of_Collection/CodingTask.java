package org.collections.The_Collection_Interface.Using_the_Methods_of_Collection;

public final class CodingTask extends Task{

    private final String spec;
    public CodingTask(String spec) {
        this.spec = spec;
    }
    public String getSpec() { return spec; }
    public String toString() { return "code " + spec; }
}
