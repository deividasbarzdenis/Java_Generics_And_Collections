package org.reification.instanceTestsAndCasts;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    /**
     * In addition to changing the type of the instance test and the cast, the type of the second
     * iterator is changed from Iterator<E> to Iterator<?>, and the type of the second element
     * is changed from E to Object. The code type-checks, because even though the element
     * type of the second iterator is unknown, it is guaranteed that it must be a subtype of
     * Object, and the nested call to equals requires only that its second argument be an object.
     * (This code properly satisfies the contract for equality on lists. Now a List<Integer> will
     * be equal to a List<Object> if they contain the same values in the same order.)
     * Alternative fixes are possible. Instead of the wildcard types List<?> and Iterator<?>,
     * you could use the raw types List and Iterator, which are also reifiable. We recommend
     * using unbounded wildcard types in preference to raw types because they provide stronger
     * static typing guarantees; many mistakes that are caught as an error when you use
     * unbounded wildcards will only be flagged as a warning if you use raw types. Also, you
     * could change the declaration of the first iterator to Iterator<?> and of the first element
     * to Object, so that they match the second iterator, and the code will still type-check. We
     * recommend always using type declarations that are as specific as possible; this helps
     * the compiler to catch more errors and to compile more-efficient code.
     * */
    public boolean equals(Object o) {
        if (o instanceof List<?>) {
            Iterator<E> it1 = iterator();
            Iterator<?> it2 = ((List<?>)o).iterator();
            while (it1.hasNext() && it2.hasNext()) {
                E e1 = it1.next();
                Object e2 = it2.next();
                if (!(e1 == null ? e2 == null : e1.equals(e2)))
                    return false;
            }
            return !it1.hasNext() && !it2.hasNext();
        } else return false;
    }

    /*Non reifiable Casts An instance test against a type that is not reifiable is always an
error. However, in some circumstances a cast to a type that is not reifiable is permitted.
For example, the following method converts a collection to a list:*/
    public static <T> List<T> asList(Collection<T> c)
            throws InvalidArgumentException
    {
        if (c instanceof List<?>) {
            return (List<T>)c;
        } else throw new InvalidArgumentException("Argument not a list");
    }
    /*Compiling this code succeeds with no errors or warnings. The instance test is not in
error because List<?> is a reifiable type. The cast does not report a warning because
the source of the cast has type Collection<T>, and any object with this type that implements
the interface List must, in fact, have type List<T>.*/
}
