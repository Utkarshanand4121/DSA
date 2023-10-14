import java.util.*;
import java.util.LinkedList;
public class Queues {
    static class Queuess {
        static int arr[];
        static int size;
        static int rear;
        Queuess(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1]; 
            } 
            rear = rear - 1;
            return front;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[0];
        }
    }

    static class CircularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;
        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear+1)% size == front;
        }

        // add
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // add first element
            if(front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int result = arr[front];

            // last element delete
            if(rear == front) {
                rear = front = -1;
            } else{
                front = (front + 1) % size;
            }
            return front;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[front];
        }
    }

    // Queue through Linked List

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class LLQueue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public static void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            int front = head.data;
            // single element
            if(tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return head.data;
        }
    }
    public static void main(String[] args) {
        // LLQueue q = new LLQueue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);

        // while(!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Queue<Integer> q = new LinkedList<>(); // ArrayDeque
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}