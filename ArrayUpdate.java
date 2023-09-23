
import java.util.Scanner;

public class ArrayUpdate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter array limit:");
        int n = s.nextInt();
        int[] a = new int[n];
        
        System.out.print("Enter array elements:");
        for(int i = 0; i<a.length; i++){
            a[i] = s.nextInt();
        }
        
        System.out.println("Array elements are:");
        for(int i=0;i<a.length;i++){
            System.out.print("\t"+a[i]);
        }
        
        System.out.print("\nEnter update position:");
        int pos = s.nextInt();
        
        System.out.print("Enter update value:");
        int val = s.nextInt();
        
        for(int i=0; i<a.length; i++){
            if(i== pos){
                a[i] = val;
            }
        }
        
        System.out.print("Update Array elements are:");
        
        for(int i=0; i<a.length; i++){
            System.out.print("\t"+a[i]);
        }
        
        
    }
    
}
