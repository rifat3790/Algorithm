import java.util.Scanner;

public class LCMOfTwoNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter two numbers: ");
        int a = s.nextInt();
        int b = s.nextInt();
        
        int n1 = a;
        int n2 = b;

        while(n2 !=0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        int gcd = n1;
        int lcm = (a * b)/gcd;
        System.out.print("GCD: "+gcd);
        System.out.print("\nLCM: "+lcm);
    }

}
