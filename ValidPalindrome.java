class ValidPalindrome {
    static boolean isPalindrome(String s) {
        // Convert to lowercase and use character array
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            // Compare characters
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is '" + s + "' a palindrome? " + isPalindrome(s)); // Output: true
    }
}