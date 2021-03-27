package org.comparator.example3_5;

import org.comparator.example3_4.Enum1;

public final class Season extends Enum1<Season> {

    private Season(String name, int ordinal) {
        super(name, ordinal);
    }

    public static final Season WINTER = new Season("WINTER", 0);
    public static final Season SPRING = new Season("SPRING", 1);
    public static final Season SUMMER = new Season("SUMMER", 2);
    public static final Season FALL = new Season("FALL", 3);
    public static final Season[] VALUES = {WINTER, SPRING, SUMMER, FALL};
    public static Season[] values(){
        return VALUES.clone();
    }
    public static Season valueOf(String name){
        for(Season e : VALUES){
            if(e.name().equals(name)){
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
