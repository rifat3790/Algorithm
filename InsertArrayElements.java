import java.util.Scanner;

public class InsertArrayElements {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter array limit: ");
        int n = s.nextInt();
        int[] a = new int[n+1];
        
        System.out.print("Enter array elements: ");
        for(int i=0; i<n; i++){
            a[i] = s.nextInt();
        }
        
        System.out.print("Array elememts are: ");
        for(int i=0; i<n; i++){
            System.out.print("\t"+a[i]);
        }
        
        System.out.print("\nEnter array insert position: ");
        int pos = s.nextInt();
        
        System.out.print("\nEnter inseting value: ");
        int val = s.nextInt();
        
        for(int i = n-1; i>=pos-1; i--){
            a[i+1] = a[i];
        }
        
        a[pos-1] = val;
        
        System.out.print("Updated array elements are: ");
        for(int i=0; i<=n; i++){
            System.out.print("\t"+a[i]);
        }
    }
}
