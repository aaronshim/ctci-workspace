package two.four;

import shared.ListNode;

import java.util.ArrayList;

/**
 * Created by Aaron on 8/16/2015.
 */
public class Partition {
    //the biggest observation here is that we can join lists quite cheaply with linked lists
    public static <T extends Comparable<T>> ListNode<T> partition(ListNode<T> list, T value) {
        ListNode<T> smaller = null; ListNode<T> smallerEndNode = null;
        ListNode<T> equal = null; ListNode<T> equalEndNode = null;
        ListNode<T> larger = null; ListNode<T> largerEndNode = null;

        ListNode<T> currentNode = list;
        while (currentNode.getNext() != null) {
            //This approach makes new nodes and doesn't destroy the original
            // -- we can also try a version where we just move links around
            int comparison = currentNode.getValue().compareTo(value);
            if (comparison < 0) {
                if (smaller == null) {
                    smaller = new ListNode<T>(currentNode.getValue());
                    smallerEndNode = smaller;
                }
                else {
                    smallerEndNode.addValue(currentNode.getValue());
                    smallerEndNode = smallerEndNode.getNext();
                }
            }
            else if (comparison == 0) {
                if (equal == null) {
                    equal = new ListNode<T>(currentNode.getValue());
                    equalEndNode = equal;
                }
                else {
                    equalEndNode.addValue(currentNode.getValue());
                    equalEndNode = equalEndNode.getNext();
                }
            }
            else {
                if (larger == null) {
                    larger = new ListNode<T>(currentNode.getValue());
                    largerEndNode = larger;
                }
                else {
                    largerEndNode.addValue(currentNode.getValue());
                    largerEndNode = largerEndNode.getNext();
                }
            }
            currentNode = currentNode.getNext();
        }

        //join three lists together
        smallerEndNode.setNext(equal);
        equalEndNode.setNext(larger);
        return smaller;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);

        ListNode<Integer> linkedList = new ListNode<Integer>(list);
        ListNode<Integer> partitionedList = Partition.partition(linkedList, 5);
        for (int i : partitionedList) {
            System.out.println(i);
        }
    }
}
