package org.collections.The_Collection_Interface.Using_the_Methods_of_Collection;

public abstract class Task implements Comparable<Task>{
    /**
     * To illustrate the use of the collection classes, let’s construct a tiny example.
     * Your authors are forever trying to get organized; let’s imagine that our latest effort involves
     * writing our own to-do manager. We begin by defining a class to represent tasks, and
     * subclasses to represent different kinds of tasks, such as writing some code or making
     * a phone call.
     * Here is the definition of tasks that we shall use:
     * */
protected Task() {}
        public boolean equals(Object o) {
        if (o instanceof Task) {
            return toString().equals(o.toString());
        } else return false;
    }
        public int compareTo(Task t) {
        return toString().compareTo(t.toString());
    }
        public int hashCode() {
        return toString().hashCode();
    }
        public abstract String toString();
}
/**
 * We only require four operations on tasks: equals, compareTo, hashCode and toString.
 * Equality will be used to test whether a collection contains a given task, comparison will
 * be used by ordered collections (such as OrderedSet and OrderedMap) and the hash code
 * will be used by collections based on hash tables (such as HashSet and HashMap), and the
 * string representation of a task will be used whenever we show the contents of a collection.
 * The first three methods are defined in terms of the toString method, which is
 * declared abstract, so it must be defined in each subclass of Task. We consider two tasks
 * equal if they are represented by the same string, and the natural ordering on tasks is
 * the same as the ordering on their strings. This guarantees that the natural ordering on
 * tasks is consistent with equality, as discussed in Section 3.1—that is, compareTo returns
 * 0 exactly when equals returns true.
 * */
