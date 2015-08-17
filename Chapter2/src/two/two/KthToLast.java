package two.two;

import shared.ListNode;

import java.util.NoSuchElementException;

/**
 * Created by Aaron on 8/16/2015.
 */
public class KthToLast {
    public static <T> T returnKthToLast(ListNode<T> list, int k) throws Exception {
        //sanity check
        if (k < 1 || list.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        //as long as we don't know the length of the list, we have to do two passes
        int length = 1;
        ListNode<T> countingNode = list;
        while (countingNode.getNext() != null) {
            length++;
            countingNode = countingNode.getNext();
        }
        length--; //account for termination node

        //more sanity check
        if (k > length) {
            throw new IndexOutOfBoundsException();
        }

        //now start at the beginning again and then count from the beginning again
        int currentIndex = 0;
        countingNode = list;
        while (currentIndex < length - k) {
            countingNode = countingNode.getNext();
            currentIndex++;
        }

        return countingNode.getValue();
    }
}
