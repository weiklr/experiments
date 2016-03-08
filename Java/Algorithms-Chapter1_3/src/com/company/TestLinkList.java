package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by wayne on 2/23/16.
 * dummy link list for exercises
 * FIFO linked list
 *  @param <Item> the generic type of an item in this stack
 */
public class TestLinkList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int N = 0;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public TestLinkList() {
        first = null;
        last = null;
        N = 0;
    }

    public void insert(Item newItem) {
        Node oldLast = last;
        last = new Node<Item>();
        last.item = newItem;
        last.next = null;

        if(isEmpty()) first = last;
        else {
            oldLast.next = last;
        }
        N++;
    }

    public Item pop() {
        Node<Item>oldFirst = first;
        Item item = oldFirst.item;
        first = first.next;
        N--;
        return item;
    }

    public void delete(int k) {
        Node<Item> currentItem = first;
        Node<Item> prevItem=first;
        int i =0;
        if (k == 0) System.out.println("Nothing to delete");

        while(i<(k-1)) {
            prevItem = currentItem;
            //System.out.println("prev item is " + prevItem.item);
            currentItem = currentItem.next;
            i++;
        }
        System.out.println("item to update is " + prevItem.item);
        prevItem.next = currentItem.next;

        /*
        for (Node<Item> currentItem = first; currentItem != null; currentItem = currentItem.next) {

        }*/
    }

    public void deleteLastNode() {
        Node<Item> currentNode = first;
        Node<Item> lastNode = first;

        int i =0, counter=0;
        //System.out.println("last node is " + last.item);
        if(isEmpty()) System.out.println("Nothing to delete");

        //find last node
        while(currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
        System.out.println("Last node:" + lastNode.item);
        currentNode = first;
        if (currentNode.item.equals(lastNode.item))
        {
            first = null;
            last = null;
            N--;
        }
        //find 2nd last node set to null to delete last node. we check that the 2nd last node is pointing to the last node by ensuring it's next node points to null.
        else {
            while (currentNode != null) {
                if (currentNode.next.item.equals(lastNode.item) && currentNode.next.next==null) {
                    System.out.println("deleting:" + currentNode.item);
                    currentNode.next = null;
                    N--;

                    System.out.println("N is" + N);
                }
                currentNode = currentNode.next;
            }
        }
        //System.out.println("first node is " + first.item);
        System.out.println("new size is " + size());

    }
    public boolean isEmpty(){return first == null;}

    public int size() {return N;}

    public Iterator<Item> iterator() {return new ListIterator<Item>(first);}

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {current = first;}

        public boolean hasNext() {return current != null;}
        public void remove()      { throw new UnsupportedOperationException();  }
        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();

            Item item = current.item;
            current = current.next;
            return item;
        }
    }




    public static void main (String [] args) {
        Node<String> tNode = new Node<String>();
        tNode.item="Test";

        TestLinkList<String> testLL = new TestLinkList<String>();
        testLL.insert("test");
        testLL.insert("test1");
        testLL.insert("test2");
        testLL.insert("test4");
        testLL.insert("test4");
        System.out.println("old size is " + testLL.size());
        //testLL.deleteLastNode();
        //testLL.deleteLastNode();
        //testLL.deleteLastNode();
        //testLL.deleteLastNode();
        //testLL.deleteLastNode();
        testLL.delete(4);
        System.out.println("size is " + testLL.size());

        for (String t : testLL) {
            System.out.println("after delete:" + t);

        }

    }
}


