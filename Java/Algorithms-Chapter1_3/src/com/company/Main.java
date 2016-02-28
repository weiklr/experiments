package com.company;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Bag;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");
        Stack<Integer> intStack = new Stack();
        intStack.push(1);
        intStack.push(3);
        intStack.push(5);
        intStack.push(7);
        Queue<Integer> intQueue = new Queue();
        intQueue.enqueue(2);
        intQueue.enqueue(4);

        Stack<String> strStack = new Stack();
        strStack.push("1");

        TestLinkList<String> testLL = new TestLinkList();

        for(String t : testLL) {
            System.out.println(t);
        }
        for(String s : strStack) {
            System.out.println(s);
        }
         /*
        Note the LIFO behaviour in stack and FIFO behaviour in queue when contents are iterated and displayed.
         */
        for(Integer num : intQueue) {
            System.out.println("queue content is " + num);
        }
        for(Integer num : intStack){
            System.out.println("stack content is " + num);
        }

        System.out.println("stack length is " +  intStack.size());
        System.out.println(Integer.toString(intStack.pop()));
        System.out.println("stack length is " +  intStack.size());
        System.out.println("queue content is "  + intQueue.dequeue());
    }
}
