package two.one;

import shared.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Aaron on 8/16/2015.
 */
public class RemoveDuplicates {
    // as long as the two objects are comparable (will destroy original list)
    public static <T> void removeDuplicates(LinkedList<T> list)
    {
        //we can keep a hashmap to see what we've seen before -- that way we can scan and remove on one go
        HashMap<T, Integer> map = new HashMap<T, Integer>();
        ArrayList<Integer> indicesToRemove = new ArrayList<Integer>();
        int index = 0;
        for (T o : list)
        {
            if (map.get(o) == null)
            {
                map.put(o, 1);
            }
            else
            {
                //well, this puts away all of the link manipulation we have to do ourselves...
                // (it's also probably not efficient)
                indicesToRemove.add(index);
            }
            index++;
        }
        int offset = 0; //hack to remove certain selected indices
        for (Integer i : indicesToRemove)
        {
            list.remove((int)(i-offset));
            offset++;
        }
    }

    public static <T> void removeDuplicatesNodewise(ListNode<T> list)
    {
        HashMap<T, Boolean> map = new HashMap<T, Boolean>();
        ListNode<T> currentNode = list;
        while (currentNode.getNext() != null) {
            if (map.get(currentNode.getValue()) == null) {
                map.put(currentNode.getValue(), true);
                //only move if we didn't delete (already moved ahead if deleted node)
                currentNode = currentNode.getNext();
            }
            else {
                //remove current node
                currentNode.setValue(currentNode.getNext().getValue());
                //save next link in a temporary variable here to free for C
                currentNode.setNext(currentNode.getNext().getNext());
                // (two-skip link is guarenteed to work here because we have a terminator)
            }
        }
    }
}
