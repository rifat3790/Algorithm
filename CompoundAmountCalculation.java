import java.util.Scanner;

public class CompoundAmountCalculation {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principalAmount = s.nextDouble();

        System.out.print("Enter the rate: ");
        double rate = s.nextDouble();

        System.out.print("Enter the time period: ");
        double timePeriod = s.nextDouble();

        System.out.print("Enter the number of the time interest compound: ");
        double interestPeriod = s.nextDouble();

        double compoundInterest = principalAmount * (Math.pow((1 + (rate/100)), (timePeriod * interestPeriod))) - principalAmount;

        System.out.println("Principal: "+principalAmount);
        System.out.println("Interest Rate: "+rate);
        System.out.println("Time Duration: "+timePeriod);
        System.out.println("Number of the Time interest compound: "+interestPeriod);
        System.out.println();
        System.out.println("Compound Interest: "+compoundInterest);
    }
}
