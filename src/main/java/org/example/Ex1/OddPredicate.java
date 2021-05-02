package org.example.Ex1;

public class OddPredicate implements UnaryPredicate<Integer>{

    /**
     * Following program counts the number of odd integers in an integer list
     * */
    @Override
    public boolean test(Integer number) {
        return number % 2 != 0;
    }

}
