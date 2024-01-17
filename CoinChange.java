public class CoinChange
{

    public static int countWays(int[] coins, int m, int n)
    {
        // Base cases:
        // If the target value becomes 0, it means we have found a solution.
        if (n == 0)
        {
            return 1;
        }

        // If the target value becomes negative or we have exhausted all coins, no solution is possible.
        if (n < 0 || m <= 0)
        {
            return 0;
        }

        // Recursive calls:
        // We have two choices for the m-th coin: either include it or exclude it.
        // 1. Include the m-th coin and reduce the target value by the coin's value.
        int includeCoin = countWays(coins, m, n - coins[m - 1]);
        // 2. Exclude the m-th coin and move to the previous coin denomination.
        int excludeCoin = countWays(coins, m - 1, n);

        // Total ways will be the sum of the two choices.
        return includeCoin + excludeCoin;
    }
    public static void main(String[] args)
    {
        int[] coins1 = {1, 2, 3};
        int N1 = 6;
        System.out.println("Number of ways to make change for " + N1 + " cents: " + countWays(coins1, coins1.length, N1));

        int[] coins2 = {2, 5, 3, 6};
        int N2 = 10;
        System.out.println("Number of ways to make change for " + N2 + " cents: " + countWays(coins2, coins2.length, N2));

        int[] coins3 = {1, 5, 10, 25};
        int N3 = 15;
        System.out.println("Number of ways to make change for " + N3 + " cents: " + countWays(coins3, coins3.length, N3));

        int[] coins4 = {1, 3, 5};
        int N4 = 8;
        System.out.println("Number of ways to make change for " + N4 + " cents: " + countWays(coins4, coins4.length, N4));

        int[] coins5 = {1, 2, 5, 10, 20};
        int N5 = 50;
        System.out.println("Number of ways to make change for " + N5 + " cents: " + countWays(coins5, coins5.length, N5));
    }

}