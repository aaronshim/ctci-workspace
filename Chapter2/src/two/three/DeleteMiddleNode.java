package two.three;

import shared.ListNode;

/**
 * Created by Aaron on 8/16/2015.
 */
public class DeleteMiddleNode {
    public static <T> void deleteMiddleNode(ListNode<T> middleNode) {
        if (middleNode.getNext() == null) {
            return; //nothing to do for empty list
        }
        middleNode.setValue(middleNode.getNext().getValue());
        middleNode.setNext(middleNode.getNext().getNext());
    }
}
