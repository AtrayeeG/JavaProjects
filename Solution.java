import java.util.Scanner;

public class Solution {
   public static long arraySum(int[] arr){
        long sum = 0;
        for( int num : arr){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i=0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(arraySum(arr));
        sc.close();
    }
}
