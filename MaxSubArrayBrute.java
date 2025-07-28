import java.util.*;

public class MaxSubArrayBrute {

    public static int maxSubarray(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++){
            int sum = 0;
            for (int j = i;j< arr.length;j++){
                sum += arr[j];
                max = Math.max(max,sum);
            }         
        }
        return max;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Maximum SubArray:"+ maxSubarray(arr));
        scanner.close();
    }
}
 