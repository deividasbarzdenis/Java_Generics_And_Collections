package org.effectiveGenerics.useCheckedCollectionsToEnforceSecurity;

public class Order {
    /**
     *
     * It is important to be aware that the guarantees offered by generic types apply only if
     * there are no unchecked warnings. This means that generic types are useless for ensuring
     * security in code written by others, since you have no way of knowing whether that code
     * raised unchecked warnings when it was compiled.
     * */
}
