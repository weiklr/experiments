package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.Queue;
/**
 * Created by Wk&Sy on 06/03/2016.
 *
 */
public class DoubleNodeList<Item> implements Iterable<Item> {
    private DoubleNode<Item> first;
    private DoubleNode<Item> last;

    public DoubleNodeList () {
        first = null;
        last = null;
    }
    private static class DoubleNode<Item> {
        private Item item;
        private DoubleNode<Item> next;
        private DoubleNode<Item> prev;

        public DoubleNode() {
            next = null;
            prev = null;
        }

    }
    public boolean isEmpty() {return first == null;}

    public static <Item> void insertAtBeginnning(DoubleNodeList<Item> list, Item item) {
        if (item != null) {
            System.out.println(" item is " + item);
            System.out.println("list empty:" + list.isEmpty());
            DoubleNode<Item> newNode = new DoubleNode<Item>();
            newNode.item = item;
            if (list.isEmpty()) {
                list.first = newNode;
                list.last = newNode;
            } else {
                insertBeforeGivenNode(list,list.first,newNode);
            }
        }
    }

    public static <Item> void insertAtBeginnning2(DoubleNodeList<Item> list, Item item) {
        if (item != null) {
            System.out.println(" item is " + item);
            System.out.println("list empty:" + list.isEmpty());
            DoubleNode<Item> newNode = new DoubleNode<Item>();
            newNode.item = item;
            if (list.isEmpty()) {
                list.first = newNode;
                list.last = newNode;
            } else {
                DoubleNode<Item> oldFirst = list.first;
                oldFirst.prev = newNode;
                newNode.next = oldFirst;
                list.first = newNode;
            }
        }
    }

    public static <Item> void insertAtEnd2(DoubleNodeList<Item> list, Item item) {
        if (item != null) {
            DoubleNode<Item> newNode = new DoubleNode<Item>();
            newNode.item = item;
            System.out.println(list.isEmpty());
            if (list.isEmpty()) {
                list.first = newNode;
                list.last = newNode;
            }
            else {
                DoubleNode<Item> oldLast = list.last;
                System.out.println("old end is " + oldLast.item);
                oldLast.next = newNode;
                newNode.prev = oldLast;
                list.last = newNode;
                //list.first.next = newNode;
            }
        }

    }
    public static <Item> void insertAtEnd(DoubleNodeList<Item> list, Item item) {
        if (item != null) {
            DoubleNode<Item> newNode = new DoubleNode<Item>();
            newNode.item = item;
            System.out.println(list.isEmpty());
            if (list.isEmpty()) insertAtBeginnning(list,item);
            else {
                insertAfterGivenNode(list,list.last,newNode);
            }
        }

    }

    public static <Item> void insertBeforeGivenNode(DoubleNodeList<Item> list, DoubleNode<Item> givenNode, DoubleNode<Item> newNode) {
        newNode.prev = givenNode.prev;
        newNode.next = givenNode;
        if (givenNode.prev == null) {
            list.first = newNode;
        }
        else {
            //System.out.println("g node prev is " + givenNode.item);
            givenNode.prev.next = newNode;
        }
        givenNode.prev = newNode;

    }

    public static <Item> void insertAfterGivenNode(DoubleNodeList<Item> list, DoubleNode<Item> givenNode, DoubleNode<Item> newNode) {
        if (givenNode != null) {

            newNode.prev = givenNode;
            newNode.next = givenNode.next;
            if (givenNode.next == null) {
                list.last = newNode;
            }
            else {
               givenNode.next.prev = newNode;
            }
            givenNode.next = newNode;
        }
    }

    public static <Item> void removeFromBeginning(DoubleNodeList<Item> list) {
        if (!list.isEmpty()) {
            removeFromGivenNode(list, list.first);
        }
    }

    public static <Item> void removeFromEnd(DoubleNodeList<Item> list) {
        if(!list.isEmpty()) {
            removeFromGivenNode(list,list.last);
        }
    }
    public static <Item> void removeFromGivenNode(DoubleNodeList<Item> list, DoubleNode<Item> givenNode) {
        if (givenNode.prev == null) {
            list.first = givenNode.next;
        }
        else
        {
            givenNode.prev.next = givenNode.next;
        }
        if (givenNode.next == null) {
            list.last = givenNode.prev;
            list.last.next = null;
        }
        else {
            givenNode.next.prev = givenNode.prev;
        }
    }

    public Iterator<Item> iterator() {return new ListIterator<Item>(first);}

    private class ListIterator<Item> implements Iterator{
        DoubleNode<Item> current;
        public ListIterator(DoubleNode<Item> first){current = first;}

        public boolean hasNext(){return current != null;}

        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    public static void main(String [] args) {
        DoubleNodeList<String>ddl = new DoubleNodeList<String>();
        /*DoubleNode <String> testNode = new DoubleNode<String>();
        testNode.item = "1";
        DoubleNode <String> testNode2 = new DoubleNode<String>();
        testNode2.item = "2";
        DoubleNode <String> testNode3 = new DoubleNode<String>();
        testNode3.item = "3";*/

        String test = "1";
        String test2 = "2";

        /*
        using insert before/after given node
         */

        ddl.insertAtBeginnning(ddl,"5");
        ddl.insertAtBeginnning(ddl,"4");
        ddl.insertAtBeginnning(ddl,"3");
        ddl.insertAtBeginnning(ddl,"6");
        ddl.insertAtEnd(ddl,"1");
        ddl.insertAtEnd(ddl,test2);
        ddl.insertAtBeginnning(ddl,"3");
        ddl.insertAtEnd(ddl,"6");

        ddl.removeFromEnd(ddl);
        ddl.removeFromBeginning(ddl);
        //test4
        /*
        Custom insert at beginning and at end testing (wihtout using insertbefore/after given node
         */
        /*ddl.insertAtBeginnning2(ddl,"5");
        ddl.insertAtBeginnning2(ddl,"4");
        ddl.insertAtBeginnning2(ddl,"3");
        ddl.insertAtBeginnning2(ddl,"6");
        ddl.insertAtEnd2(ddl,"1");
        ddl.insertAtEnd2(ddl,test2);
        ddl.insertAtBeginnning2(ddl,"3");
        ddl.insertAtEnd2(ddl,"6");*/
        //ddl.insertAtBeginnning(ddl,testNode3);

        Iterator ddlIterator = ddl.iterator();
        int counter = 0;
        while(ddlIterator.hasNext()) {
            System.out.println(String.format("items are %s", ddlIterator.next()));
            counter ++;
        }
        System.out.println("Total items:" + counter);
    }






}
