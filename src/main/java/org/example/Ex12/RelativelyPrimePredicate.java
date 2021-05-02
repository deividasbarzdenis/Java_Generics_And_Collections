package org.example.Ex12;

import java.util.Collection;

public class RelativelyPrimePredicate implements UnaryPredicate<Integer>{
    private Collection<Integer> c;

    public RelativelyPrimePredicate(Collection<Integer> c) {
        this.c = c;
    }

    public boolean test(Integer x) {
        for (Integer i : c)
            if (Algorithm.gcd(x, i) != 1)
                return false;

        return c.size() > 0;
    }


}
