import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the limit of fibonacci series: ");
        int limit = s.nextInt();

        int n1 = 0;
        int n2 = 1;

        for (int i = 0; i < limit; i++) {
            System.out.print(n1 + " ");
            int sum = n1;
            n1 = n1 + n2;
            n2 = sum;
        }
    }
}
