import java.util.*;
public class F05_LCMRecursive {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入正整數:");
        int a = scanner.nextInt();
        System.out.println("請輸入正整數:");
        int b = scanner.nextInt();
        
        int gcd = gcdRecursive(a, b);
        
        int lcm = (a * b) / gcd;
        
        System.out.println("LCM: " + lcm);
        
        scanner.close();
    }
    
    private static int gcdRecursive(int a, int b) {
        if (a==b) {
            return a;
        }

        if (a > b) {
            return gcdRecursive(a-b,b);
        } else {
            return gcdRecursive(a,b-a);
        }
    }
}
/*
* Time Complexity:O(max(a,b))
** 說明：每次遞迴的操作都是O(1)
        最佳情況是O(1)
        最壞情況是O(max(a,b))
*/
