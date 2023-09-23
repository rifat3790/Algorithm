import java.util.Scanner;

public class LinearSearch {
    
    public static void main(String[] args) {
        
        int pos = -1;
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter array limit: ");
        int n = s.nextInt();
        
        System.out.print("Enter array elements:");
        int[] a = new int[n];
        for(int i=0; i<a.length; i++){
            a[i] = s.nextInt();
        }
        
        System.out.print("Array elements are: ");
        for(int i=0; i<a.length; i++){
            System.out.print("\t"+a[i]);
        }
        
        System.out.print("\nEnter search value: ");
        int val = s.nextInt();
        
        for(int i=0; i<a.length; i++){
            if(a[i] == val){
                pos = i +1;
                break;
            }
        }
        
        if(pos == -1){
            System.out.println("Item not found.");
        }
        else{
            System.out.print("The value of "+val+" is position: "+pos);
        }
        
    }
    
}
