class SuffixSumExample {
    // Function to build the suffix sum array
    static long[] buildSuffixSum(int[] arr, int n) {
        long[] suffix = new long[n + 1]; // +1 to handle 0-based indexing
        suffix[n] = 0; // Empty suffix
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }
        return suffix;
    }

    // Function to answer a range sum query
    static long getRangeSum(long[] suffix, int left, int right, int n) {
        if (left < 0 || right >= n || left > right) {
            System.out.println("Invalid query");
            return -1;
        }
        return suffix[left] - suffix[right + 1];
    }

    // Driver code
    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 3, -1, 4, 5, 6};
        int n = arr.length;

        // Build suffix sum array
        long[] suffix = buildSuffixSum(arr, n);

        // Example queries: Each query is (left, right) inclusive
        int[][] queries = {
            {1, 3}, // Sum from index 1 to 3: arr[1] + arr[2] + arr[3]
            {0, 4}, // Sum from index 0 to 4: arr[0] + arr[1] + ... + arr[4]
            {2, 5}  // Sum from index 2 to 5: arr[2] + arr[3] + ... + arr[5]
        };

        // Process queries
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Suffix Sum Array: " + java.util.Arrays.toString(suffix));
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long result = getRangeSum(suffix, left, right, n);
            System.out.println("Sum from index " + left + " to " + right + ": " + result);
        }
    }
}