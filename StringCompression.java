class StringCompression {
    static String compress(String s) {
        if (s == null || s.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int count = 1;
        char current = chars[0];
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == current) {
                count++;
            } else {
                sb.append(current).append(count);
                current = chars[i];
                count = 1;
            }
        }
        // Append the last group
        sb.append(current).append(count);
        
        // Return original string if compressed is longer
        String result = sb.toString();
        return result.length() < s.length() ? result : s;
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println("Compressed '" + s + "': " + compress(s)); // Output: a2b1c5a3
    }
}