package two.five;

import shared.ListNode;

/**
 * Created by Aaron on 8/16/2015.
 */
public class SumLists {
    public static int sumListsBackwards(ListNode<Integer> l1, ListNode<Integer> l2) {
        int tens = 0;
        int sum = 0;
        ListNode<Integer> current1 = l1;
        ListNode<Integer> current2 = l2;

        //generalized for not same length of lists
        while (current1.getNext() != null && current2.getNext() != null) {
            if (current1.getValue() != null) {
                sum+=current1.getValue()*Math.pow(10,tens);
                current1 = current1.getNext();
            }

            if (current2.getValue() != null) {
                sum += current2.getValue() * Math.pow(10, tens);
                current2 = current2.getNext();

            }
            tens++;
        }
        return sum;
    }

    //almost the same for the other way-- will have to keep two pointers for adding lists into lists
    public static int sumListsForwards(ListNode<Integer> l1, ListNode<Integer> l2) {
        int sum = 0;
        ListNode<Integer> current1 = l1;
        ListNode<Integer> current2 = l2;
        int length = Math.max(current1.size(), current2.size());
        int tens = length - 1;

        //generalized for not same length of lists
        while (current1.getNext() != null && current2.getNext() != null) {
            if (current1.getValue() != null) {
                sum+=current1.getValue()*Math.pow(10,tens);
                current1 = current1.getNext();
            }

            if (current2.getValue() != null) {
                sum += current2.getValue() * Math.pow(10, tens);
                current2 = current2.getNext();
            }
            tens--;
        }
        return sum;
    }
}
