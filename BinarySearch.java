import java.util.Scanner;

public class BinarySearch {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter array limit:");
        int n = s.nextInt();
        int l=0, r = n-1, mid;
        
        int[] a = new int[n];
        System.out.print("Enter array elements: ");
        for(int i=0; i<a.length; i++){
            a[i] = s.nextInt();
        }
        
        System.out.print("Array elements are: ");
        for(int i=0; i<a.length; i++){
            System.out.print("\t"+a[i]);
        }
        
        System.out.print("\nEnter searching value: ");
        int val = s.nextInt();
        
        while(l<=r){
            mid = (l+r)/2;
            
            if(a[mid] == val){
                System.out.print("The value of "+val+" is position: "+(mid+1));
                break;
            }
            else if(a[mid] < val){
                l = mid +1;
            }
            else{
                r = mid -1;
            }
        }
        
        if(l>r){
            System.out.println("Item not found.");
        }
        
    }
    
}
