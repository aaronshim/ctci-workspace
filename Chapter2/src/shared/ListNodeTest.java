package shared;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Aaron on 8/16/2015.
 */
public class ListNodeTest {

    @Test
    public void testIsEmpty() throws Exception {
        ListNode<Integer> empty = new ListNode<Integer>();
        ListNode<Integer> notempty = new ListNode<Integer>();
        notempty.addValue(1);
        notempty.addValue(2);
        notempty.addValue(3);
        assertTrue("Empty list is empty", empty.isEmpty());
        assertFalse("Non-empty list is not empty", notempty.isEmpty());
    }

    @Test
    public void testGetNext() throws Exception {
        ListNode<Integer> list = new ListNode<Integer>();
        list.addValue(1);
        list.addValue(2);
        assertEquals("Can get next value", (int) list.getNext().getValue(), 2);
    }

    @Test
    public void testSetNext() throws Exception {
        ListNode<Integer> list = new ListNode<Integer>();
        list.addValue(1);
        list.setNext(new ListNode<Integer>(2));
        assertEquals("Can set next node properly", (int)list.getNext().getValue(), 2);
    }

    @Test
    public void testGetValue() throws Exception {
        ListNode<Integer> list = new ListNode<Integer>(1337);
        assertEquals("Can extract the value properly", (int)list.getValue(), 1337);
    }

    @Test
    public void testSetValue() throws Exception {
        ListNode<Integer> list = new ListNode<Integer>(0);
        list.setValue(1337);
        assertEquals("Can extract the value properly", (int)list.getValue(), 1337);
    }

    @Test
    public void testAddValue() throws Exception {
        ListNode<Integer> empty = new ListNode<Integer>();
        empty.addValue(1);
        assertEquals("Can add value properly to empty list", (int)empty.getValue(), 1);

        ListNode<Integer> notempty = new ListNode<Integer>(1);
        notempty.addValue(2);
        notempty.addValue(3);
        assertEquals("Can add value to the empty of an already formed list",
                (int)notempty.getNext().getNext().getValue(), 3);
    }

    @Test
    public void testSize() throws Exception {
        ListNode<Integer> empty = new ListNode<Integer>();
        assertEquals("Sizes empty lists", empty.size(), 0);

        ListNode<Integer> one = new ListNode<Integer>(1);
        assertEquals("Sizes single list", one.size(), 1);

        for (int i=0; i < 1000; i++)
        {
            one.addValue(1);
        }
        assertEquals("Sizes bigger lists", one.size(), 1001);
    }

    @Test
    public void testIterator() throws Exception {
        ListNode<Integer> empty = new ListNode<Integer>();
        assertFalse("Empty list does not have hasNext()", empty.iterator().hasNext());
        ListNode<Integer> notempty = new ListNode<Integer>(1);
        assertTrue("Not empty list does have hasNext()", notempty.iterator().hasNext());

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i=0; i < 1000; i++)
        {
            arrayList.add(i+1);
        }
        ListNode<Integer> fullList = new ListNode<Integer>(arrayList);
        for (Integer i : fullList) {
            assertEquals("Iterator must return full list", arrayList.get(0), i);
            arrayList.remove(0);
        }
    }
}