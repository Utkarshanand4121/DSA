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

    // Queue using 2 stacks
    static class Queuees{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add O(n)
        public static void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue Empty");
                return -1;
            }
            return s1.pop();
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Queue Empty");
                return -1;
            }
            return s1.peek();
        }
    }

    
    // Stack Using two Queue
    static class Stacks {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }
        public static int pop() {
            if(isEmpty()) {
                System.out.println("Empty statck");
                return -1;
            }
            int top = -1;

            // case 1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // case2
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty statck");
                return -1;
            }
            int top = -1;

            // case 1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { // case2
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    // Non- Repeating Character
    public static void printNonRepeating(String str) {
        int freq[]= new int[26]; // 'a' - 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1+" ");
            } else {
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
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
        // Queue<Integer> q = new ArrayDeque<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while(!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }
        // Queuees q = new Queuees();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while(!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Stacks s = new Stacks();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String str = "aabccxb";
        // printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        while(!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}