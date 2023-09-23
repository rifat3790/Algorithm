import java.util.Scanner;

public class RemoveArrayElement {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter array limits:");
        int n = s.nextInt();
        
        int[] a = new int[n];
        
        System.out.print("Enter array elements:");
        for(int i=0; i<a.length; i++){
            a[i] = s.nextInt();
        }
        
        System.out.print("Array elements are:");
        for(int i=0; i<a.length; i++){
            System.out.print("\t"+a[i]);
        }
        
        System.out.print("\nEnter delete position of an elements:");
        int pos = s.nextInt();
        for(int i=pos-1; i<a.length-1; i++){
            if(i == pos){
                a[i] = a[i+1];
            }
        }
        
        System.out.print("Final array elements are:");
        for(int i=0; i<a.length-1; i++){
            System.out.print("\t"+a[i]);
        }
    }
    
}
