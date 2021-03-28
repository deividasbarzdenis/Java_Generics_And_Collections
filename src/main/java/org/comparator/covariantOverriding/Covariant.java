package org.comparator.covariantOverriding;

public class Covariant {

    /*Java 5 supports covariant method overriding. This feature is not directly related to
generics, but we mention it here because it is worth knowing, and because it is implemented
using a bridging technique like that described in the previous section.
In Java 1.4 and earlier, one method can override another only if the argument and return
types match exactly. In Java 5, a method can override another if the argument types
match exactly and the return type of the overriding method is a subtype of the return
type of the other method.
The clone method of class Object illustrates the advantages of covariant overriding:

class Object {
...
public Object clone() { ... }
}

In Java 1.4, any class that overrides clone must give it exactly the same return type,
namely Object:

class Point {
public int x;
public int y;
public Point(int x, int y) { this.x=x; this.y=y; }
public Object clone() { return new Point(x,y); }
}

Here, even though clone always returns a Point, the rules require it to have the return
type Object. This is annoying, since every invocation of clone must cast its result.

Point p = new Point(1,2);
Point q = (Point)p.clone();
In Java 5, it is possible to give the clone method a return type that is more to the point:
class Point {
public int x;
public int y;
public Point(int x, int y) { this.x=x; this.y=y; }
public Point clone() { return new Point(x,y); }
}

Now we may clone without a cast:

Point p = new Point(1,2);
Point q = p.clone();

Covariant overriding is implemented using the bridging technique described in the
previous section. As before, you can see the bridge if you apply reflection. Here is code
that finds all methods with the name clone in the class Point:

for (Method m : Point.class.getMethods())
if (m.getName().equals("clone"))
System.out.println(m.toGenericString());

*/
}
