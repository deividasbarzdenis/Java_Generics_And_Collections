package org.reflection.reflectingGenericTypes;

import java.io.PrintStream;
import java.lang.reflect.*;

public class ReflectionDemo {
    /*Much of this code would be unnecessary if the Type interface had a toGenericString
method. Sun is considering this change*/

    /**
     * The reflection library provides a Type interface to describe a generic type. There is one
     * class that implements this interface and four other interfaces that extend it, corresponding
     * to the five different kinds of types:
     * The class Class, representing a primitive type or raw type
     * • The interface ParameterizedType, representing an application of a generic class or
     * interface to parameter types, from which you can extract an array of the parameter
     * types
     * • The interface TypeVariable, representing a type variable, from which you can extract the bounds on the type variable
     * • The interface GenericArrayType, representing an array, from which you can extract
     * the array component type
     * • The interface WildcardType, representing a wildcard, from which you can extract
     * a lower or upper bound on the wildcard
     * By performing a series of instance tests on each of these interfaces, you may determine
     * which kind of type you have, and print or process the type; we will see an example of
     * this shortly.
     * Methods are available to return the superclass and superinterfaces of a class as types,
     * and to access the generic type of a field, the argument types of a constructor, and the
     * argument and result types of a method.
     * You can also extract the type variables that stand for the formal parameters of a class
     * or interface declaration, or of a generic method or constructor. The type for type variables takes a parameter,
     * and is written TypeVariable<D>, where D represents the type of
     * object that declared the type variable. Thus, the type variables of a class have type
     * TypeVariable<Class<?>>, while the type variables of a generic method have type Type
     * Variable<Method>. Arguably, the type parameter is confusing and is not very helpful.
     * Since it is responsible for the problem described in Section 6.6, Sun may remove it in
     * the future.
     *
     * Example 7-5 uses these methods to print out all of the header information associated
     * with a class. Here are two examples of its use:
     *
     *
     * The code in Example 7-5 is lengthy but straightforward. It contains methods to print
     * every component of a class: its superclass, its interfaces, its fields, and its methods. The
     * core of the code is the method printType, which uses a cascade of instance tests to
     * classify a type according to the five cases above.
     * */
    private final static PrintStream out = System.out;
    public static void printSuperclass(Type sup) {
        if (sup != null && !sup.equals(Object.class)) {
            out.print("extends ");
            printType(sup);
            out.println();
        }
    }
    public static void printInterfaces(Type[] impls) {
        if (impls != null && impls.length > 0) {
            out.print("implements ");
            int i = 0;
            for (Type impl : impls) {
                if (i++ > 0) out.print(",");
                printType(impl);
            }
            out.println();
        }
    }
    public static void printTypeParameters(TypeVariable<?>[] vars) {
        if (vars != null && vars.length > 0) {
            out.print("<");
            int i = 0;
            for (TypeVariable<?> var : vars) {
                if (i++ > 0) out.print(",");
                out.print(var.getName());
                printBounds(var.getBounds());
            }
            out.print(">");
        }
    }
    public static void printBounds(Type[] bounds) {
        if (bounds != null && bounds.length > 0
                && !(bounds.length == 1 && bounds[0] == Object.class)) {
            out.print(" extends ");
            int i = 0;
            for (Type bound : bounds) {
                if (i++ > 0) out.print("&");
                printType(bound);
            }
        }
    }
    public static void printParams(Type[] types) {
        if (types != null && types.length > 0) {
            out.print("<");
            int i = 0;
            for (Type type : types) {
                if (i++ > 0) out.print(",");
                printType(type);
            }
            out.print(">");
        }
    }
    public static void printType(Type type) {
        if (type instanceof Class) {
            Class<?> c = (Class)type;
            out.print(c.getName());
        } else if (type instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType)type;
            Class c = (Class)p.getRawType();
            Type o = p.getOwnerType();
            if (o != null) { printType(o); out.print("."); }
            out.print(c.getName());
            printParams(p.getActualTypeArguments());
        } else if (type instanceof TypeVariable<?>) {
            TypeVariable<?> v = (TypeVariable<?>)type;
            out.print(v.getName());
        } else if (type instanceof GenericArrayType) {
            GenericArrayType a = (GenericArrayType)type;
            printType(a.getGenericComponentType());
            out.print("[]");
        } else if (type instanceof WildcardType) {
            WildcardType w = (WildcardType)type;
            Type[] upper = w.getUpperBounds();
            Type[] lower = w.getLowerBounds();
            if (upper.length == 1 && lower.length == 0) {
                out.print("? extends ");
                printType(upper[0]);
            } else if (upper.length == 0 && lower.length == 1) {
                out.print("? super ");
                printType(lower[0]);
            } else throw new AssertionError();
        }
    }
    public static void printClass(Class c) {
        out.print("class ");
        out.print(c.getName());
        printTypeParameters(c.getTypeParameters());
        out.println();
        printSuperclass(c.getGenericSuperclass());
        printInterfaces(c.getGenericInterfaces());
    }
    public static void main(String[] args) throws ClassNotFoundException {
        for (String name : args) {
            Class<?> c = Class.forName(name);
            printClass(c);
        }
    }

}
