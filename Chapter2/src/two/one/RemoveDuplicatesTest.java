package two.one;

import org.junit.Test;
import shared.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Aaron on 8/16/2015.
 */
public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() throws Exception {
        LinkedList<Object> empty= new LinkedList<Object>();
        RemoveDuplicates.removeDuplicates(empty);
        assertEquals("Empty lists stay empty", empty, new LinkedList<Object>());

        Integer[] array = {1};
        List<Integer> list = Arrays.asList(array);
        LinkedList<Object> linkedList = new LinkedList<Object>(list);
        RemoveDuplicates.removeDuplicates(linkedList);
        assertEquals("Single lists stay single", linkedList, new LinkedList<Object>(list));

        Integer[] array2 = {1,2,3};
        List<Integer> list2 = Arrays.asList(array2);
        LinkedList<Object> linkedList2 = new LinkedList<Object>(list2);
        RemoveDuplicates.removeDuplicates(linkedList2);
        assertEquals("Nonrepeating lists stay the same", linkedList2, new LinkedList<Object>(list2));

        Integer[] array3 = {1,1,2,3,4,2,5,3};
        List<Integer> list3 = Arrays.asList(array3);
        LinkedList<Object> linkedList3 = new LinkedList<Object>(list3);
        RemoveDuplicates.removeDuplicates(linkedList3);
        Integer[] cleaned = {1,2,3,4,5};
        list3 = Arrays.asList(cleaned);
        assertEquals("Repeating lists are cleaned properly", linkedList3, new LinkedList<Object>(list3));
    }

    @Test
    public void testRemoveDuplicatesNodewise() throws Exception {
        ListNode<Integer> empty = new ListNode<Integer>();
        RemoveDuplicates.removeDuplicatesNodewise(empty);
        assertTrue("Empty lists stay empty", empty.isEmpty());

        Integer[] array = {1};
        List<Integer> list = Arrays.asList(array);
        ListNode<Integer> linkedList = new ListNode<Integer>(list);
        RemoveDuplicates.removeDuplicatesNodewise(linkedList);
        assertFalse("Single lists stay single", linkedList.isEmpty());

        Integer[] array2 = {1,2,3};
        List<Integer> list2 = Arrays.asList(array2);
        ListNode<Integer> linkedList2 = new ListNode<Integer>(list2);
        RemoveDuplicates.removeDuplicatesNodewise(linkedList2);
        int index = 0;
        for (Integer i : linkedList2) {
            assertEquals("Nonrepeating lists stay the same", (int)array2[index], (int)i);
            index++;
        }

        Integer[] array3 = {1,1,2,3,4,2,5,3};
        List<Integer> list3 = Arrays.asList(array3);
        ListNode<Integer> linkedList3 = new ListNode<Integer>(list3);
        RemoveDuplicates.removeDuplicatesNodewise(linkedList3);
        Integer[] cleaned = {1,2,3,4,5};
        index = 0;
        for (Integer i : linkedList3) {
            assertEquals("Repeating lists are cleaned properly", (int)cleaned[index], (int)i);
            index++;
        }
    }
}