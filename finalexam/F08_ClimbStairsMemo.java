import java.util.*;

public class F08_ClimbStairsMemo {
    
    // 記憶化陣列，避免重複計算
    private static int[] memo;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入階梯數:");
        int n = scanner.nextInt();
        
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        
        int ways = climbStairsRecursive(n);
        
        System.out.println("Ways: " + ways);
        
        scanner.close();
    }

    private static int climbStairsRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1; 
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        if (memo[n] != -1) {
            return memo[n];
        }

        int result = climbStairsRecursive(n-1)+climbStairsRecursive(n-2)+climbStairsRecursive(n-3);
        memo[n] = result;
        
        return result;
    }
}
