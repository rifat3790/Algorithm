import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String X = "ABCDEFGH";
        String Y = "abcdefgh";

        int[][] L = lcs(X, Y);
        System.out.println("The length of the Longest Common Subsequence is: " + L[X.length()][Y.length()]);

        HashSet<String> subsequences = new HashSet<>();
        printSubsequences(X, Y, X.length(), Y.length(), L, "", subsequences);

        System.out.println("\nAll common subsequences in descending order of length:");
        subsequences.stream().sorted((s1, s2) -> s2.length() - s1.length()).forEach(System.out::println);
    }

    static int[][] lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L;
    }

    static void printSubsequences(String X, String Y, int i, int j, int[][] L, String subsequence, HashSet<String> subsequences) {
        if (i == 0 || j == 0) {
            subsequences.add(subsequence);
            return;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            printSubsequences(X, Y, i - 1, j - 1, L, X.charAt(i - 1) + subsequence, subsequences);
        } else {
            if (L[i - 1][j] > L[i][j - 1]) {
                printSubsequences(X, Y, i - 1, j, L, subsequence, subsequences);
            } else {
                printSubsequences(X, Y, i, j - 1, L, subsequence, subsequences);
            }
        }
    }
}
