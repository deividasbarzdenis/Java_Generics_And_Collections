package org.collections.The_Collection_Interface.Using_the_Methods_of_Collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class TaskTest {

    @Test
    public void test() {
        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
        CodingTask databaseCode = new CodingTask("db");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");
        Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
        Collection<CodingTask> codingTasks = new ArrayList<CodingTask>();
        Collection<Task> mondayTasks = new ArrayList<Task>();
        Collection<Task> tuesdayTasks = new ArrayList<Task>();
        Collections.addAll(phoneTasks, mikePhone, paulPhone);
        Collections.addAll(codingTasks, databaseCode, interfaceCode, logicCode);
        Collections.addAll(mondayTasks, logicCode, mikePhone);
        Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);
        assert phoneTasks.toString().equals("[phone Mike, phone Paul]");
        assert codingTasks.toString().equals("[code db, code gui, code logic]");
        assert mondayTasks.toString().equals("[code logic, phone Mike]");
        assert tuesdayTasks.toString().equals("[code db, code gui, phone Paul]");
        /**
         * Since the empty string precedes all others in the natural ordering on strings, the empty
         * task comes before all others in the natural ordering on tasks. This task will be useful
         * when we construct range views of sorted sets (see Section 13.2).
         * Example 12-1 shows how we can define a series of tasks to be carried out (even if, in a
         * real system, they would be more likely to be retrieved from a database). We’ve chosen
         * ArrayList as the implementation of Collection to use in this example, but we’re not
         * going to take advantage of any of the special properties of lists; we’re treating Array
         * List as an implementation of Collection and nothing more. As part of the retrieval
         * process, we have organized the tasks into various categories represented by lists, using
         * the methodCollections.addAll introduced in Section 1.4
         * */

        /*Adding Elements We can add new tasks to the schedule:*/
        mondayTasks.add(new PhoneTask("Ruth", "567 1234"));
        assert mondayTasks.toString().equals(
                "[code logic, phone Mike, phone Ruth]");

        /*or we can combine schedules together:*/
        Collection<Task> allTasks = new ArrayList<Task>(mondayTasks);
        allTasks.addAll(tuesdayTasks);
        assert allTasks.toString().equals(
                "[code logic, phone Mike, phone Ruth, code db, code gui, phone Paul]");

        /*Removing Elements When a task is completed, we can remove it from a schedule:*/
        boolean wasPresent = mondayTasks.remove(mikePhone);
        assert wasPresent;
        assert mondayTasks.toString().equals("[code logic, phone Ruth]");

        /*and we can clear a schedule out altogether because all of its tasks have been done (yeah,
right):*/
        mondayTasks.clear();
        assert mondayTasks.toString().equals("[]");

        /*The removal methods also allow us to combine entire collections in various ways. For
example, to see which tasks other than phone calls are scheduled for Tuesday, we can
write:*/
        Collection<Task> tuesdayNonphoneTasks = new ArrayList<Task>(tuesdayTasks);
        tuesdayNonphoneTasks.removeAll(phoneTasks);
        assert tuesdayNonphoneTasks.toString().equals("[code db, code gui]");

        /*or to see which phone calls are scheduled for that day*/
        Collection<Task> phoneTuesdayTasks = new ArrayList<Task>(tuesdayTasks);
        phoneTuesdayTasks.retainAll(phoneTasks);
        assert phoneTuesdayTasks.toString().equals("[phone Paul]");

        /*This last example can be approached differently to achieve the same result:*/
        Collection<PhoneTask> tuesdayPhoneTasks =
                new ArrayList<PhoneTask>(phoneTasks);
        tuesdayPhoneTasks.retainAll(tuesdayTasks);
        assert tuesdayPhoneTasks.toString().equals("[phone Paul]");

        /**
         * Note that phoneTuesdayTasks has the type List<Task>, while tuesdayPhoneTasks has the
         * more precise type List<PhoneTask>.
         * This example provides an explanation of the signatures of methods in this group and
         * the next. We have already discussed (Section 2.6) why they take arguments of type
         * Object or Collection<?> when the methods for adding to the collection restrict their
         * arguments to its parametric type. Taking the example of retainAll, its contract requires
         * the removal of those elements of this collection which do not occur in the argument
         * collection. That gives no justification for restricting what the argument collection may
         * contain; in the preceding example it can contain instances of any kind of Task, not just
         * PhoneTask. And it is too narrow even to restrict the argument to collections of supertypes
         * of the parametric type; we want the least restrictive type possible, which is Collection<?
         * >. Similar reasoning applies to remove, removeAll, contains, and containsAll
         * */

        /**
         * Querying the Contents of a Collection These methods allow us to check, for example,
         * that the operations above have worked correctly. We are going to use assert here
         * to make the system check our belief that we have programmed the previous operations
         * correctly. For example the first statement will throw an AssertionError if tuesdayPho
         * neTasks does not contain paulPhone:
         * */
        assert tuesdayPhoneTasks.contains(paulPhone);
        assert tuesdayTasks.containsAll(tuesdayPhoneTasks);
        assert mondayTasks.isEmpty();
        assert mondayTasks.size() == 0;

        /**
         * Making the Collection Contents Available for Further Processing The methods
         * in this group provide an iterator over the collection or convert it to an array.
         * Section 11.1 showed how the simplest—and most common—explicit use of iterators
         * has been replaced in Java 5 by the foreach statement, which uses them implicitly. But
         * there are uses of iteration with which foreach can’t help; you must use an explicit iter-
         * ator if you want to change the structure of a collection without encountering Concur
         * rentModification-Exception, or if you want to process two lists in parallel. For example,
         * suppose that we decide that we don’t have time for phone tasks on Tuesday. It may
         * perhaps be tempting to use foreach to filter them from our task list, but that won’t work
         * for the reasons described in Section 11.1:
         * But using the iterator’s structure-changing methods gives the result we want:
         * */
        for (Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext() ; ) {
            Task t = it.next();
            if (t instanceof PhoneTask) {
                it.remove();
            }
        }
    }

}
