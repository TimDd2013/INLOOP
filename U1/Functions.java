public class Functions{
    public static int factorial(int n) {
        int result=1;
        if (n==0) return 1;
        while (n>0){
            result=result*n;
            n=n-1;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("The factorial of 5 is "+factorial(5)+".");
    }
}