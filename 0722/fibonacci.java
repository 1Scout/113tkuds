public class fibonacci {
    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
        }
    public static void main(String[] args) {
        int n =10;  
        System.out.println("計算費波納契數列第 " + n + " 項：");
        System.out.println("基本遞迴: " + fibonacci(n));
    }
}
