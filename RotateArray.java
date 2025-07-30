import java.util.*;

public class RotateArray {

    public static void rotate(int [] nums, int k){
        k %= nums.length;
        System.out.println("k:"+k);
        System.out.println("Reverse1:" + Arrays.toString(reverse(nums, 0, nums.length - 1))+"\n");
        System.out.println("Reverse2:" + Arrays.toString(reverse(nums, 0, k-1))+"\n");
        System.out.println("Reverse3:" + Arrays.toString(reverse(nums, k, nums.length - 1))+"\n");
    }
    
    public static int[] reverse (int []nums, int start, int end ){
        while(start<end){
            int temp = nums[start];
            System.out.println("temp:"+temp);
            nums[start++] = nums[end];
            System.out.println("nums[start]:"+nums[start]+"nums[end]:"+nums[end]);
            nums[end--] = temp;
            System.out.println("nums:"+ Arrays.toString(nums));
        }
        return nums;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        rotate(arr,k);
        scanner.close();
    }
}
