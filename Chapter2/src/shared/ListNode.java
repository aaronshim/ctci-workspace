package shared;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Aaron on 8/16/2015.
 *
 * The most conventional way of doing this is to make an outer List class and a inner, private ListNode class
 * but I wanted to be able to expose individual nodes themselves for coding practice purposes, more akin to
 * how this would be done in pure C.
 *
 * This list has an empty terminator node.
 */
public class ListNode<T> implements Iterable<T>{

    private T data;
    private ListNode<T> nextNode;

    //create empty list/terminator node
    public ListNode()
    {
        this.data = null;
        this.nextNode = null;
    }

    //create list with first item
    public ListNode(T item)
    {
        this.data = item;
        this.nextNode = new ListNode<T>();
    }

    //quick and dirty create
    public ListNode(List<T> list)
    {
        this.data = null;
        this.nextNode = null;
        for (T item : list)
        {
            this.addValue(item);
        }
    }

    public boolean isEmpty()
    {
        return this.data==null;
    }

    public ListNode<T> getNext()
    {
        return nextNode;
    }

    public void setNext(ListNode<T> node)
    {
        nextNode = node;
    }

    public T getValue()
    {
        return data;
    }

    public void setValue(T data)
    {
        this.data = data;
    }

    // insert to the end of list
    public void addValue(T item)
    {
        ListNode<T> last = this;
        while (last.nextNode != null) {
            last = last.nextNode;
        }

        //fix broken no terminator case
        if (last.data != null)
        {
            last.nextNode = new ListNode<T>();
            last = last.nextNode;
        }

        last.data = item;
        //new terminator
        last.nextNode = new ListNode<T>();
    }

    // size of list starting at the current node
    public int size()
    {
        ListNode<T> last = this;
        int count = 1;
        while (last.nextNode != null) {
            last = last.nextNode;
            count++;
        }

        //fix broken no terminator case
        if (last.data != null)
        {
            last.nextNode = new ListNode<T>();
            last = last.nextNode;
            count++;
        }

        return count-1; //correct for terminator
    }

    /* The tricky thing about this again is that next and hasNext are not really next but current
    *
    * */
    private class ListIterator implements Iterator<T>
    {
        ListNode<T> current = ListNode.this;

        @Override
        public boolean hasNext() {
            return current.data != null;
        }

        @Override
        public T next() {
            if (hasNext())
            {
                T value = current.data;
                current = current.nextNode;
                return value;
            }
            else
            {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (hasNext())
            {
                //just slide one on past
                current.data = current.nextNode.data;
                current.nextNode = current.nextNode.nextNode;
            }
            else
            {
                current.data = null;
                current.nextNode = null;
            }
        }
    }

    public Iterator<T> iterator()
    {
        return new ListIterator();
    }
}
