import java.util.*;

public class Arrayslist {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        // Brute force
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wid = j - i;
                int currWater = ht * wid;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    // 2 Pointer Approach -- O(n)
    public static int storeWater2(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            // Calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            // Update
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    // Pair Sum -- Brute Force
    public static boolean pairSum(ArrayList<Integer> list4, int target) {
        for (int i = 0; i < list4.size(); i++) {
            for (int j = i + 1; j < list4.size(); j++) {
                if (list4.get(i) + list4.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Pair Sum -- Pointer Approach
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            // case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            // case 2
            else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            }
            // case 3
            else {
                rp--;
            }
        }
        return false;
    }

    // Pair Sum -2
    public static boolean pairSum3(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1; // Smallest
        int rp = bp; // largest
        while (lp != rp) {
            // case1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        // System.out.println(list);

        // Collections.sort(list); // ascending
        // System.out.println(list);
        // // Descending
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);
        // int idx1 =1, idx2 =3;
        // swap(list,idx1,idx2);
        // System.out.println(list);
        // Max of a value
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<list.size(); i++) {
        // if(max<list.get(i)) {
        // max = list.get(i);
        // }
        // max = Math.max(max,list.get(i));
        // }
        // System.out.println("max element = "+max);
        // Reverse print
        // for(int i=list.size()-1; i>=0; i--) {
        // System.out.print(list.get(i) +" ");
        // }
        // System.out.println();

        // list.add(1,8); // O(n)
        // System.out.println(list);

        // System.out.println(list.size());

        // Printing arary list
        // for(int i=0; i<list.size(); i++) {
        // System.out.print(list.get(i)+" ");
        // }
        // System.out.println();

        // Get elements
        // int elements = list.get(2);
        // System.out.println(elements);

        // delete
        // list.remove(2);
        // System.out.println(list);

        // set
        // list.set(2,10);
        // System.out.println(list);

        // contains

        // System.out.println(list.contains(1));
        // System.out.println(list.contains(10));

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();
        // list3.add(1);list3.add(2);list3.add(3);list3.add(4);list3.add(5);
        // mainList.add(list3);

        // ArrayList<Integer> list4 = new ArrayList<>();
        // list4.add(2);list4.add(4);list4.add(6);list4.add(8);list4.add(10);
        // mainList.add(list4);

        // ArrayList<Integer> list5 = new ArrayList<>();
        // list5.add(3);list5.add(6);list5.add(9);list5.add(12);list5.add(15);
        // mainList.add(list5);

        // for(int i=0; i<mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);
        // for(int j=0; j<currList.size(); j++) {
        // System.out.print(currList.get(j) +" ");
        // }
        // System.out.println();
        // }

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();
        // ArrayList<Integer> list4 = new ArrayList<>();
        // ArrayList<Integer> list5 = new ArrayList<>();

        // for(int i=1; i<=5; i++) {
        // list3.add(i*1);
        // list4.add(i*2);
        // list5.add(i*3);
        // }

        // mainList.add(list3);
        // mainList.add(list4);
        // mainList.add(list5);

        // System.out.println(mainList);

        // for(int i=0; i<mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);
        // for(int j=0; j<currList.size(); j++) {
        // System.out.print(currList.get(j) + " ");
        // }
        // System.out.println();
        // }

        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // System.out.println(storeWater2(height));

        // ArrayList<Integer> list4 = new ArrayList<>();
        // list4.add(1);
        // list4.add(2);
        // list4.add(3);
        // list4.add(4);
        // list4.add(5);

        // System.out.println(pairSum2(list4, 4));

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(11);
        list5.add(15);
        list5.add(6);
        list5.add(8);
        list5.add(9);
        list5.add(10);

        System.out.println(pairSum3(list5, 16));
    }

}
