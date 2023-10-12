import java.util.*;

public class NextGreaterStack {
    public static void main(String[] args) {
        int arr[] = { 6, 4, 3, 10, 9 };
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // 1 While
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2 if-else
            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            // 3 push in s
            s.push(i);
        }
        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();

        // ------- Hint for Next Question Releated to this Ques-------
        // Next greater Right
        // Next greater Left -- reverse the for loop of line 9
        // Next Smaller Right -- do arr[s.peek()] >= arr[i]
        // Next Smaller Left -- reverse the for loop of line 9 and do arr[s.peek()] >= arr[i]
    }
}
