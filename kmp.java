import java.util.Scanner;

public class kmp {

    void kmpSearch(String pat, String text) {
        int m = pat.length();
        int n = text.length();

        int lps[] = new int[m];
        int j = 0;

        computeLPS(pat, m, lps);
        int i = 0;

        while (i < n) {
            if (pat.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Found pattern: " + pat + " at index: " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    void computeLPS(String pat, int m, int lps[]) {
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        kmp kmpMultiple = new kmp();

        System.out.print("Enter the number of pairs: ");
        int numberOfPairs = s.nextInt();
        s.nextLine();

        for (int pair = 1; pair <= numberOfPairs; pair++) {
            System.out.println("\nEnter details for Pair " + pair + ":");

            System.out.print("Enter the text: ");
            String text = s.nextLine();

            System.out.print("Enter the pattern: ");
            String pat = s.nextLine();

            kmpMultiple.kmpSearch(pat, text);
        }

        s.close();
    }
}
