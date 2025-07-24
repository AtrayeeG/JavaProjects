class PrefixSumExample {
    // Function to build the prefix sum array
    static long[] buildPrefixSum(int[] arr, int n) {
        long[] prefix = new long[n + 1]; // +1 to handle 0-based indexing
        prefix[0] = 0; // Empty prefix
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        return prefix;
    }

    // Function to answer a range sum query
    static long getRangeSum(long[] prefix, int left, int right) {
        if (left < 0 || right >= prefix.length - 1 || left > right) {
            System.out.println("Invalid query");
            return -1;
        }
        return prefix[right + 1] - prefix[left];
    }

    // Driver code
    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 3, -1, 4, 5, 6};
        int n = arr.length;

        // Build prefix sum array
        long[] prefix = buildPrefixSum(arr, n);

        // Example queries: Each query is (left, right) inclusive
        int[][] queries = {
            {1, 3}, // Sum from index 1 to 3: arr[1] + arr[2] + arr[3]
            {0, 4}, // Sum from index 0 to 4: arr[0] + arr[1] + ... + arr[4]
            {2, 5}  // Sum from index 2 to 5: arr[2] + arr[3] + ... + arr[5]
        };

        // Process queries
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Prefix Sum Array: " + java.util.Arrays.toString(prefix));
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long result = getRangeSum(prefix, left, right);
            System.out.println("Sum from index " + left + " to " + right + ": " + result);
        }
    }
}