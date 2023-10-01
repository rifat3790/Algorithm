import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter any integer number: ");
        int n = s.nextInt();

        int fact = 1;
        if(n < 0) {
            System.out.println("Factorial is not possible.");
        }
        else{
            for(int i = 1; i <= n; i++) {
                fact = fact * i;
            }
            System.out.println(fact);
        }
    }
}
