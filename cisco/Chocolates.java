class Chocolates {
    public static int maximumNumberOfChocolates(int[] choco) {

        // This is a 0-1 Knapsack problem which can also be solved using Dynamic Programming
        // We will memoize sub solutions in memo array, where memo[i] will store maximum sum till i index

        int n = choco.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return choco[0];
        }
        int[] memo = new int[n];
        memo[0] = choco[0];
        memo[1] = Integer.max(choco[0], choco[1]);

        for (int i = 2; i < n; i++) {
            memo[i] = Integer.max(memo[i - 1], memo[i - 2] + choco[i]);
            memo[i] = Integer.max(memo[i], choco[i]);
        }
        return memo[n - 1];
    }
}