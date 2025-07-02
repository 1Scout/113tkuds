import java.util.Scanner;

public class q6fibonaccirec {
    static int ops = 0;
    public static int fibonacci(int n) {
        ops++;
        if (n == 0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("輸入n值:");
        int n = scanner.nextInt();          
        int result = fibonacci(n);         

        System.out.println(result);        
        System.out.println(ops);           
    }
}

