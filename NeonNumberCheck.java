import java.util.Scanner;

public class NeonNumberCheck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = s.nextInt();

        int square =(int) Math.pow(n,2);

        System.out.print("Square: "+square);
        int sum =0;

        while(square!=0){
            int rem = square%10;
            sum+= rem;
            square = square/10;
        }
        
        System.out.println();
        if(sum == n){
            System.out.println(n+" is a Neon Number");
        }
        else{
            System.out.println(n+" is not a Neon Number");
        }
    }
}
