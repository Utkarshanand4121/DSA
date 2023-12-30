public class Triess {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;
        for(int level = 0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // search
    public static boolean search(String key) { // O(L)
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) { // O(L)
        if(key.length() == 0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    static class Node2 {
        Node2[] children = new Node2[26];
        boolean eow = false;
        int freq;

        public Node2() {
            for(int i=0; i<children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }
    
    public static Node2 root2 = new Node2();

    public static void insert2(String word) {
        Node2 curr = root2;

        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node2();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void findPrefix(Node2 root, String ans) { // O(L) == L -- Longest words
        if(root == null) {
            return;
        }
        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static boolean startsWith(String prefix) {
        Node curr = root;

        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // Unique Substring
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }
    public static void main(String[] args) {
        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }

        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));

        // find prefix
        // String arr[] = {"zebra", "dog", "duck", "dove"};
        // for(int i=0; i<arr.length; i++) {
        //     insert2(arr[i]);
        // }
        // root2.freq = -1;
        // findPrefix(root2, "");

        // startsWith

        // String words[] = {"apple", "app", "mango", "man", "women"};
        // String prefix1 = "app"; // true
        // String prefix2 = "moon"; // false

        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }

        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));
        
        // Unique Substring
        String str = "apple"; // ans = 10

        // Suffix -> insert in trie

        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}
