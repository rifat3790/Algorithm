import java.util.Scanner;

public class SimpleInterestCalculate {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the principal amount: ");
        double p = s.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double r = s.nextDouble();

        System.out.print("Enter the number of years: ");
        double n = s.nextDouble();

        double SimpleInterest = (p * r * n)/100;
        
        System.out.println("The Simple Interest is: " + SimpleInterest);


    }
}
