import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heaps {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn)
            // add at last idx
            arr.add(data);

            int x = arr.size() - 1; // x is child index
            int par = (arr.size() - 2) / 2; // par index

            while (arr.get(x) < arr.get(par)) { // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // Remove from heap
        public int remove() {
            int data = arr.get(0);

            // step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step2 - delete last
            arr.remove(arr.size() - 1);

            // step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // Heap sort

    public static void heapify2(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify2(arr, maxIdx, size);
        }

    }

    public static void heapSort(int arr[]) { // O(n*logn)
        // step1 - build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify2(arr, i, n);
        }
        // step2 - push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify2(arr, 0, i);
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    // Connecting n ropes with min costs
    public static void minCosts() {

        int ropes[] = { 2, 3, 3, 4, 6 };

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }

        System.out.println("Cost of connecting n ropes = " + cost);

    }

    // Weakiest Solider
    static class Row implements Comparable<Row> {
        int soliders;
        int idx;

        public Row(int soliders, int idx) {
            this.soliders = soliders;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soliders == r2.soliders) {
                return this.idx - r2.idx;
            } else {
                return this.soliders - r2.soliders;
            }
        }
    }

    // Sliding Window maximum
    static class Pair implements Comparable<Pair> { // O(nlogk)
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // ascending
            // this.val - p2.val
            // descending
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {
        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // while(!h.isEmpty()) { // heap sort - O(nlogn)
        // System.out.println(h.peek());
        // h.remove();
        // }

        // int arr[] = {1,2,4,5,3};
        // heapSort(arr);

        // for(int i=0; i<arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        // int k = 2;

        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for(int i=0; i<pts.length; i++) {
        // int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
        // pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        // }

        // // nearest k cars
        // for(int i=0; i<k; i++) {
        // System.out.println("C" + pq.remove().idx);
        // }

        // minCosts();

        // Weakiest Solider
        // int army[][] = { { 1, 0, 0, 0 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 0, 0 },
        // { 1, 0, 0, 0 } };
        // int k = 2;

        // PriorityQueue<Row> pq = new PriorityQueue<>();

        // for(int i=0; i<army.length; i++) {
        // int count = 0;
        // for(int j=0; j<army[0].length; j++) {
        // count += army[i][j] == 1 ? 1 : 0;
        // }
        // pq.add(new Row(count, i));
        // }

        // for(int i=0; i<k; i++) {
        // System.out.println("R" + pq.remove().idx);
        // }

        // Sliding maximun window

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int res[] = new int[arr.length - k + 1]; // n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;
        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }

        // print result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
