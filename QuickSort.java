import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array limit: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        int l = 0;
        int r = n - 1;

        System.out.println("Before sorting:");
        output(a);

        quicksort(a, l, r);

        System.out.println("\nSorted array:");
        output(a);
    }

    static void quicksort(int a[], int l, int r) {
        if (l < r) {
            int pi = partition(a, l, r);
            quicksort(a, l, pi - 1);
            quicksort(a, pi + 1, r);
        }
    }

    static int partition(int a[], int l, int r) {
        int pivot = a[l];
        int i = l;
        int j = r;

        while (i < j) {
            while (a[i] <= pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }

        swap(a, l, j);
        return j;
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void output(int a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }
}
