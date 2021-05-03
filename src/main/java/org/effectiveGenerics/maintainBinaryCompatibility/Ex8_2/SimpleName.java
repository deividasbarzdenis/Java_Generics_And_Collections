package org.effectiveGenerics.maintainBinaryCompatibility.Ex8_2;

public class SimpleName implements Name{
    private String base;
    public SimpleName(String base) {
        this.base = base;
    }
    public int compareTo(Object o) {
        return base.compareTo(((SimpleName)o).base);
    }
}
