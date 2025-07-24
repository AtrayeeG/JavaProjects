import java.io.*;
import java.util.*;

public class Anagrams {
    public static List<String> funWithAnagrams(List<String> text) {
        // Map to store sorted string as key and first occurrence as value
        Map<String, String> anagramMap = new HashMap<>();
        
        // Process each string
        for (String str : text) {
            char[] chars = str.toLowerCase().toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // Keep the first occurrence of the anagram
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, str);
            }
        }
        
        // Convert map values to list and sort
        List<String> result = new ArrayList<>(anagramMap.values());
        Collections.sort(result);
        
        return result;
    }

    // Test the solution
    public static void main(String[] args) throws IOException {
        // // Test Case 1: ["code", "aaagmnrs", "anagrams", "doce"]
        // List<String> test1 = Arrays.asList("code", "aaagmnrs", "anagrams", "doce");
        // System.out.println("Test Case 1: " + funWithAnagrams(test1)); // Expected: ["aaagmnrs", "code"]

        // // Test Case 2: ["poke", "pkoe", "okpe", "ekop"]
        // List<String> test2 = Arrays.asList("poke", "pkoe", "okpe", "ekop");
        // System.out.println("Test Case 2: " + funWithAnagrams(test2)); // Expected: ["poke"]
        
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<String> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            data.add(scanner.nextLine().trim());
        }

        List<String> result = funWithAnagrams(data);

        for (String s : result) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush(); // Make sure all output is written
        bufferedWriter.close();
        scanner.close();
    }
}