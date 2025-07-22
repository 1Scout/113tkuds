public class fibonaccicompare {
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }
    // 時間複雜度：O(2^n) - 指數級成長！
    //每個數字會被重複計算很多次
    // 空間複雜度：O(n) - 遞迴深度
    //適合小數值運算
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
    // 時間複雜度：O(n) - 每個數字只計算一次
    // 空間複雜度：O(n) - 儲存計算結果
    //寫法較複雜，需額外寫入memo
    //適合大數值運算
}
