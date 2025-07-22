import java.util.*;
public class FactorialExampleinput {
    public static int factorial(int n) {
        // 停止條件：0! = 1, 1! = 1
        if (n <= 1) {
            System.out.print("1");
            return 1;
        }
        // 遞迴關係：n! = n × (n-1)!
        System.out.print(n+"*");
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("請輸入x值:");        
        int x=scanner.nextInt();
        int result=factorial(x);
        System.out.print("x! = ");
        System.out.println("="+result);
    }
}
