package org.reflection;

public interface Reflection {
    /**
     * Reflection is the term for a set of features that allows a program to examine its own
     * definition. Reflection in Java plays a role in class browsers, object inspectors, debuggers, interpreters,
     * services such as JavaBeans™ and object serialization, and any tool
     * that creates, inspects, or manipulates arbitrary Java objects on the fly.
     * Reflection has been present in Java since the beginning, but the advent of generics
     * changes reflection in two important ways, introducing both generics for reflection and
     * reflection for generics.
     * By generics for reflection we mean that some of the types used for reflection are now
     * generic types. In particular, the class Class becomes the generic class Class<T>. This
     * may seem confusing at first, but once understood it can make programs using reflection
     * much clearer. Class literals and the method Object.getClass use special tricks to return
     * more-precise type information. Generics are used to especially good effect in the reflection of annotations.
     * We observe that the type parameter T in Class<T> should always
     * be bound to a reifiable type, and we present a short library that can help you avoid
     * many common cases of unchecked casts.
     * By reflection for generics we mean that reflection now returns information about generic
     * types. There are new interfaces to represent generic types, including type variables,
     * parameterized types, and wildcard types, and there are new methods that get the generic
     * types of fields, constructors, and methods.
     * We explain each of these points in turn. We don’t assume any previous knowledge of
     * reflection, but we focus on the aspects tied to generics.
     * */
}
