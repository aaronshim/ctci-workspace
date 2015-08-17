package two.two;

import org.junit.Test;
import shared.ListNode;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Aaron on 8/16/2015.
 */
public class KthToLastTest {

    @Test(expected=IndexOutOfBoundsException.class)
    public void testBiggerKThanListSize() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListNode<Integer> linkedList = new ListNode<Integer>(list);
        KthToLast.returnKthToLast(linkedList, 10);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testEmptyList() throws Exception {
        ListNode<Integer> linkedList = new ListNode<Integer>();
        KthToLast.returnKthToLast(linkedList, 1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testNegativeK() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListNode<Integer> linkedList = new ListNode<Integer>(list);
        KthToLast.returnKthToLast(linkedList, -1);
    }

    @Test
    public void testReturnKthToLast() throws Exception {
        ListNode<Integer> linkedList = new ListNode<Integer>(1);
        assertEquals("Works on a singleton list", 1, (int)KthToLast.returnKthToLast(linkedList,1));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        linkedList = new ListNode<Integer>(list);
        for (int k = 1; k <= list.size(); k++) {
            assertEquals("Finds the right indexed number", list.get(list.size() - k),
                    KthToLast.returnKthToLast(linkedList, k));
        }
    }
}