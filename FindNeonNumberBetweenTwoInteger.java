import java.util.Scanner;

public class FindNeonNumberBetweenTwoInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter initial value: ");
        int initialValue = s.nextInt();

        System.out.print("Enter final value: ");
        int finalValue = s.nextInt();

        for (int i = initialValue; i <= finalValue; i++) {
            int n = i;
            int square = n * n;
            // System.out.print("\t"+square);
            int sum = 0;
            while(square!=0){
                int rem = square % 10;
                sum += rem;
                square /= 10;
            }
            if(sum == i){
                System.out.print("\t"+i);
            }
        }
    }
}
