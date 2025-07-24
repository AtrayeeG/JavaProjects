class TwoSum {
    // Function to find two numbers in a sorted array that sum to target
    static int[] twoSum(int[] numbers, int target) {
        int left = 0; // Pointer at the start
        int right = numbers.length - 1; // Pointer at the end
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == target) {
                // Return 1-based indices as per HackerRank convention
                return new int[] {left + 1, right + 1};
            } else if (currentSum < target) {
                left++; // Need a larger sum, move left pointer right
            } else {
                right--; // Need a smaller sum, move right pointer left
            }
        }
        
        // No solution found (though problem guarantees a solution)
        return new int[] {-1, -1};
    }

    // Driver code
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 26;
        
        int[] result = twoSum(numbers, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
