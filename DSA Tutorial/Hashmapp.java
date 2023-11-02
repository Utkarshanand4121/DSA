import java.util.*;
public class Hashmapp {
    public static void majorityEle() {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            // if(map.containsKey(arr[i])) {
            //     map.put(arr[i], map.get(arr[i]) + 1);
            // } else {
            //     map.put(arr[i], 1);
            // }
            
            // short form
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if(map.get(key) > arr.length/3) {
                System.out.println(key);
            }
        }
    }

    public static boolean isAnangram(String s, String t) { // O(n)
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    // Count Distinct Elements
    public static void count() {
        int num[] = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<num.length; i++) {
            set.add(num[i]);
        }

        System.out.println("ans = "+set.size());
    }

    // Union and intersection
    public static void unionInter() {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();

        // union
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("union = " + set.size());

        // intersection
        set.clear();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("intersection = "+ count);
    }

    // Find itinerary for tickets
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key; // starting point
            }
        }

        return null;
    }
    public static void iterTicket() { // O(n)
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }

        System.out.println();
    }

    public static void largestSubarray() {
        int arr[] = {15,-2,2,-8,1,7,10,23};

        HashMap<Integer, Integer> map = new HashMap<>();
        //(sum, idx)

        int sum = 0;
        int len = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum)) {
                len = Math.max(len, j-map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("largest subarray with sum as 0 => " +len);
    }
    public static void main(String[] args) {
        // Create
        // HashMap<String, Integer> hm = new HashMap<>();

        // // Insert - O(1)
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Indonesia", 6);
        // hm.put("Nepal", 5);

        // System.out.println(hm);

        // Get - O(1)
        // int population = hm.get("India");
        // System.out.println(population);

        // Contains Key - O(1)
        // System.out.println(hm.containsKey("India")); // true
        // System.out.println(hm.containsKey("Indonesia")); // false

        // Remove
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        //Size
        // System.out.println(hm.size());

        //  Is Empty
        // hm.clear();
        // System.out.println(hm.isEmpty());

        // Iterate
        // hm.entrySet()
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("Keys = "+k+ ",value="+hm.get(k));
        // }

        // // Linked Hashmap
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India", 150);
        // lhm.put("China", 100);
        // lhm.put("US", 50);
        // System.out.println(lhm);

        // majorityEle();

        // String s = "tulip";
        // String t = "lipid";

        // System.out.println(isAnangram(s, t));

        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // set.add(1);

        // // Iterate in a set
        // System.out.println(set);
        // Iterator it = set.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // for(Integer net : set) {
        //     System.out.println(net);
        // }
        // set.clear();
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());
        // set.remove(2);
        // if(set.contains(2)) {
        //     System.out.println("set contains 2");
        // } 
        
        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Noida");
        // cities.add("Pune");
        // System.out.println(cities);

        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Mumbai");
        // lhs.add("Noida");
        // lhs.add("Pune");
        // lhs.add("Bangaluru");
        // System.out.println(lhs);

        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Delhi");
        // ts.add("Mumbai");
        // ts.add("Noida");
        // ts.add("Pune");
        // ts.add("Bangaluru");
        // System.out.println(ts);

        // count();

        //unionInter();
        // iterTicket();

        largestSubarray();
    }
}
