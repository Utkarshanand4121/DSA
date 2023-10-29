import java.util.*;
public class Hashmapp {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        System.out.println(hm);

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
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Keys = "+k+ ",value="+hm.get(k));
        }
    }
}
