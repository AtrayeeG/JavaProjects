public class FibonacciRecursion {
    public static int fibonacci(int n){
        if( n == 0)
            return 0;
        if( n == 1 )
            return 1;
        return fibonacci(n-1)+ fibonacci(n-2);
    }
    public static void main(String[] args){
        int count = 10;
        System.out.println("fibonacci Series");
        for(int i=0; i<count; i++){
            System.out.print(fibonacci(i)+" ");
        }
        
    }
}
