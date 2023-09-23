
import java.util.Scanner;


public class BubbleSort {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter array limit: ");
        int n = s.nextInt();
        
        int[] a= new int[n];
        System.out.print("Enter array elements: ");
        for(int i=0; i<a.length; i++){
            a[i] = s.nextInt();
        }
        
        System.out.print("Array elements are: ");
        for(int i=0; i<a.length; i++){
            System.out.print("\t"+a[i]);
        }
        
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(a[j]> a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        
        System.out.print("\nSorted elements are: ");
        for(int i=0; i<a.length; i++){
            System.out.print("\t"+a[i]);
        }
    }
    
}
