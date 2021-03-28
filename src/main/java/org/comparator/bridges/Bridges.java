package org.comparator.bridges;

import org.comparator.bridges.example3_7.Integer;
import java.lang.reflect.Method;

public class Bridges {
    /*To implement generic behaviour, java compiler apply type erasure. Type erasure is a process in which
    compiler replaces a generic parameter with actual class or bridge method. In type erasure, compiler
    ensures that no extra classes are created and there is no runtime overhead.*/

/*As we mentioned earlier, generics are implemented by erasure: when you write code
with generics, it compiles in almost exactly the same way as the code you would have
written without generics. In the case of a parameterized interface such as Compara
ble<T>, this may cause additional methods to be inserted by the compiler; these additional
 methods are called bridges*/

    //You can see the bridge if you apply reflection. Here is code that finds all methods with
    //the name compareTo in the class Integer, using toGenericString to print the generic
    //signature of a method
    public static void main(String[] args) {
        for (Method m : Integer.class.getMethods()){
            if(m.getName().equals("compareTo")){
                System.out.println(m.toGenericString());
            }
        }
    }



}

