public class Knapsack {

    public static int knapsack(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int[][] b = new int[n + 1][maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weight[i - 1] <= w) {
                    b[i][w] = Math.max(value[i - 1] + b[i - 1][w - weight[i - 1]], b[i - 1][w]);
                    
                } else {
                    b[i][w] = b[i - 1][w];
                }
            }
        }

        return b[n][maxWeight];
    }

    public static void main(String[] args) {
        int[] w = {3, 2, 5, 4};
        int[] v = {4, 3, 6, 5};
        int maxWeight = 5;

        int maxValue = knapsack(w, v, maxWeight);
        System.out.println("Maximum Profit: " + maxValue);
    }
}
