
import java.util.*;
import java.util.Scanner;

public class TwoSumBruteForce {

    public static int[] twoSumBrute(int[]arr, int target){
        for(int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                   return new int[]{i,j};
                }
            }
        }
       return new int[] {-1,-1};
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); //size of the array
        int[] arr = new int[num];

        //input array elements
        for(int i=0;i<num;i++) {
            arr[i]=scanner.nextInt();
        }

        int target = scanner.nextInt();

         System.out.println("target:"+target);
         System.out.println("arr:"+ Arrays.toString(arr));
        int[] result = twoSumBrute(arr,target);
        
        System.out.println(result[0]+" "+result[1]);

        scanner.close();

    }
    
}
