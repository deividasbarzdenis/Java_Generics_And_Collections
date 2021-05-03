package org.effectiveGenerics.specializeToCreateReifiableTypes;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListString extends ArrayList<String> implements ListString{

    public ArrayListString() { super(); }
    public ArrayListString(Collection<? extends String> c) { super(c); }
    public ArrayListString(int capacity) { super(capacity); }
/**
 * This declares ListString (an unparameterized type, hence reifiable) to be a subtype of
 * List<String> (a parameterized type, hence not reifiable). Thus, every value of the first
 * type also belongs to the second, but not conversely. The interface declares no new
 * methods; it simply specializes the existing methods to the parameter type String.
 * */
}
