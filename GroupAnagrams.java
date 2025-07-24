import java.util.*;

class GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store frequency key -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Create frequency array for lowercase letters
            int[] freq = new int[26];
            for (char c : s.toLowerCase().toCharArray()) {
                freq[c - 'a']++;
            }
            // Convert frequency array to string key
            String key = Arrays.toString(freq);
            // Add to map
            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);


        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Anagram groups: " + result);
        // Output: [[eat, tea, ate], [tan, nat], [bat]]
    }
}