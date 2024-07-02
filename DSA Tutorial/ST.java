public class ST {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int arr[], int i, int start, int end) { // O(n)
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid); // left subtree - 2*i+1
        buildST(arr, 2 * i + 2, mid + 1, end); // right subtree - 2*i+2
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    // Query on ST
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) { // O(logn)
        if (qj <= si || qi >= sj) { // non-overlapping
            return 0;
        } else if (si >= qi && sj <= qj) { // complete overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // Update on ST
    public static void updateUtil(int i, int si, int sj, int idx, int diff) { // O(logn)
        if (idx > sj || idx < si) {
            return;
        }

        tree[i] += diff;
        if (si != sj) { // non-leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff); // left
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff); // right
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n - 1, idx, diff);
    }

    // Max/Min Segment Tree
    public static void constructST(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        constructST(2 * i + 1, si, mid, arr);
        constructST(2 * i + 2, mid + 1, sj, arr);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Query
    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) { // no overlap
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) { // complete overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    // Update
    public static void update2(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil2(0, 0, n - 1, idx, newVal);
    }

    public static void updateUtil2(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }

        tree[i] = Math.max(tree[i], newVal);
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateUtil2(2 * i + 1, 0, mid, idx, newVal); // left
            updateUtil2(2 * i + 2, mid + 1, sj, idx, newVal); // right
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int n = arr.length;
        // init(n);
        // buildST(arr, 0, 0, n - 1);

        // for (int i = 0; i < tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }
        // System.out.println();
        // Query on ST
        // System.out.println(getSum(arr, 2, 5));

        // Update on ST
        // update(arr, 2, 2);
        // System.out.println(getSum(arr, 2, 5));

        // Max/Min Segment Tree
        int arr1[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr1.length;
        init(n);
        constructST(0, 0, n - 1, arr1);
        // for(int i=0; i<tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }

        int max = getMax(arr1, 2, 5);
        System.out.println(max);

        update2(arr1, 2, 20);
        int max2 = getMax(arr1, 2, 5);
        System.out.println(max2);
    }
}
