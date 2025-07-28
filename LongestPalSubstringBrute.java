import java.util.Scanner;

public class LongestPalSubstringBrute {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        String longestPal = longestPalindromeBrute(s);
        System.out.println(longestPal);
    }

    public static String longestPalindromeBrute(String s){
       int maxLen = 0;
       String result = "";
       for(int i =0; i<s.length();i++){
        for(int j=i; j<s.length();j++){
           String sub = s.substring(i,j+1);
           if(isPalindrome(sub) && sub.length() > maxLen) {
            maxLen = sub.length();
            result = sub;
           }
        }
       }
       return result; 
    }
    
    public static boolean isPalindrome(String str){
        int l = 0, r = str.length() -1;
        while(l<r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;

    }
}
