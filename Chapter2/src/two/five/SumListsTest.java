package two.five;

import org.junit.Test;
import shared.ListNode;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Aaron on 8/16/2015.
 */
public class SumListsTest {

    @Test
    public void testSumListsBackwards() throws Exception {
        ListNode<Integer> l1 = new ListNode<Integer>(2);
        ListNode<Integer> l2 = new ListNode<Integer>(7);
        assertEquals("Adds single digit numbers properly", 9, SumLists.sumListsBackwards(l1, l2));

        ArrayList<Integer> n1 = new ArrayList<Integer>();
        n1.add(7);
        n1.add(1);
        n1.add(6);
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        n2.add(5);
        n2.add(9);
        n2.add(2);
        l1 = new ListNode<Integer>(n1);
        l2 = new ListNode<Integer>(n2);

        assertEquals("Adds multiple digit numbers correctly", 912, SumLists.sumListsBackwards(l1,l2));
    }

    @Test
    public void testSumListsForwards() throws Exception {
        ListNode<Integer> l1 = new ListNode<Integer>(2);
        ListNode<Integer> l2 = new ListNode<Integer>(7);
        assertEquals("Adds single digit numbers properly", 9, SumLists.sumListsForwards(l1, l2));

        ArrayList<Integer> n1 = new ArrayList<Integer>();
        n1.add(6);
        n1.add(1);
        n1.add(7);
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        n2.add(2);
        n2.add(9);
        n2.add(5);
        l1 = new ListNode<Integer>(n1);
        l2 = new ListNode<Integer>(n2);

        assertEquals("Adds multiple digit numbers correctly", 912, SumLists.sumListsForwards(l1,l2));
    }
}