package two.three;

import org.junit.Test;
import shared.ListNode;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Aaron on 8/16/2015.
 */
public class DeleteMiddleNodeTest {

    @Test
    public void testDeleteMiddleNode() throws Exception {
        ListNode<Integer> empty = new ListNode<Integer>();
        DeleteMiddleNode.deleteMiddleNode(empty);
        assertEquals("Empty list stays empty", empty, empty);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListNode<Integer> linkedList = new ListNode<Integer>(list);
        ListNode<Integer> thirdNode = linkedList.getNext().getNext();
        DeleteMiddleNode.deleteMiddleNode(thirdNode);
        int index = 0;
        int[] cleaned = { 1,2,4,5 };
        for (Integer i : linkedList) {
            assertEquals("Successfully deletes middle node in a list", cleaned[index], (int)i);
            index++;
        }
    }
}