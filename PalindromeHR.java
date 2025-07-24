import java.io.*;
import java.util.*;

public class PalindromeHR {

    static int getMinOperations(int[] data) {
        int n = data.length;
        UnionFind uf = new UnionFind();

        for (int i = 0; i < n / 2; i++) { //[1, 2, 3, 3, 2, 5, 4]
            int a = data[i];
            int b = data[n - 1 - i];
            if (a != b) {
                uf.union(a, b);
            }
        }

        return uf.getOperationCount();
    }

    // Union-Find Data Structure 
    static class UnionFind {
        Map<Integer, Integer> parent = new HashMap<>();
        int operations = 0;

        int find(int x) {
            if (!parent.containsKey(x)) parent.put(x, x);
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent.put(rootA, rootB);
                operations++;
            }
        }

        int getOperationCount() {
            return operations;
        }
    } 
    
    static int getPalindrome(int[] data){ // O(n^2)

        int n = data.length;
        int counter = 0;

        for(int i= 0; i<n/2;i++){
            int x= data[i];
            int y= data[n-1-i];
            for(int j=i;j<n-1-i;j++){
                if(j == n/2 && x==y){
                    break;
                }
                if(data[j]==x && x != y){
                    data[j]= y;
                    if(i==j){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static int getOperations(List<Integer> data) {
        int n = data.size();
        int operations = 0;

        // Use a set to track unique numbers that need replacement
        Set<Integer> toReplace = new HashSet<>();

        // Check symmetric pairs
        for (int i = 0; i < n / 2; i++) {
            int left = data.get(i);
            int right = data.get(n - 1 - i);
            if (left != right) {
                toReplace.add(left);
                toReplace.add(right);
            }
        }

        // The number of operations is the number of unique values to replace,
        // but we need to ensure we count distinct replacement needs
        operations = toReplace.size() / 2; // Each pair (x, y) can be resolved with one operation

        // If the set size is odd, we need to round up to account for the last unmatched value
        if (toReplace.size() % 2 != 0) {
            operations++;
        }

        return operations > 0 ? operations : 0;
    }



    public static void main(String[]args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        int[] data = new int[n];
        List<Integer> data1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            data1.add(data[i]);
        }
        
        System.out.println("n=" + n);
        System.out.println("Data=" + Arrays.toString(data));
        System.out.println("Data1=" + data1);
        
        int result = getMinOperations(data);
        int result1 = getPalindrome(data);
        int result2 = getOperations(data1);
        System.out.println("result=" + result);
        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);

        System.out.println("Data=" + Arrays.toString(data));
        System.out.println("Data1=" + data1);
        bufferedWriter.write(String.valueOf(result1));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }
}
