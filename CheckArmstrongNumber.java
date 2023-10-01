import java.util.Scanner;

public class CheckArmstrongNumber {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter initial value: ");
        int initialValue = s.nextInt();

        System.out.print("Enter final value: ");
        int finalValue = s.nextInt();

        for(int i= initialValue; i<= finalValue; i++){
            int sum = 0;
            int n = i;
            
            while(n!=0){
                int r = n%10;
                sum += r*r*r;
                n = n/10;
            }

            if(i == sum){
                System.out.println(i);
            }
        }
    }
    
}
