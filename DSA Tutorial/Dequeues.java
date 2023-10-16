import java.util.*;
import java.util.LinkedList;
public class Dequeues {

    // Implementing Stack using Deque
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    // Implementing Queue using Deque
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1); //1
        // deque.addFirst(2); //2 1
        // deque.addLast(3); // 2 1 3
        // deque.addLast(4); // 2 1 3 4
        // System.out.println(deque);
        // deque.removeLast();
        // System.out.println(deque);
        // // deque.removeFirst();
        // // System.out.println(deque);

        // System.out.println("first el = " + deque.getFirst());
        // System.out.println("last el = " + deque.getLast());

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("peek = "+ s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        // Implementing Queue using Deque

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = "+ q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
