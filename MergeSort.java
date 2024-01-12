import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array limit: ");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.print("Before sorting: ");
        for(int i=0; i<n; i++){
            System.out.print("\t"+a[i]);
        }
        System.out.println();

        int l = 0;
        int r = n - 1;

        mergeSort(a, l, r);
        

        System.out.print("Sorted array: ");
        output(a, n);
    }

    static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    static void merge(int a[], int l, int mid, int r) {
        int i, j, k;
        int[] b = new int[100];

        i = l;
        j = mid + 1;
        k = l;

        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        if (i > mid) {
            while (j <= r) {
                b[k] = a[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }

        for (k = l; k <= r; k++) {
            a[k] = b[k];
        }
    }

    static void output(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }

}

