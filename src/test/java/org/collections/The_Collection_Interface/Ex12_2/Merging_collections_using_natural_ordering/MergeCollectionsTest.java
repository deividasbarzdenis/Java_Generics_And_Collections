package org.collections.The_Collection_Interface.Ex12_2.Merging_collections_using_natural_ordering;

import org.collections.The_Collection_Interface.Using_the_Methods_of_Collection.PhoneTask;
import org.collections.The_Collection_Interface.Using_the_Methods_of_Collection.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class MergeCollectionsTest {

    @Test
    public void test(){
        Collection<Task> mondayTasks = new ArrayList<Task>();
        Collection<Task> tuesdayTasks = new ArrayList<Task>();
        mondayTasks.add(new PhoneTask("Ruth", "567 1234"));

        Collection<Task> mergedTasks =
                MergeCollections.merge(mondayTasks, tuesdayTasks);
        assert mergedTasks.toString().equals(
                "[code db, code gui, code logic, phone Mike, phone Paul]");
    }

}
