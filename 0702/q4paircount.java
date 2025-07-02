import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("輸入n值:");
        int n = scanner.nextInt();        
        int[] arr = new int[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("輸入陣列中要放入的值:");
            arr[i] = scanner.nextInt();
        }

        int Paircount= n * (n - 1) / 2;
        int ops= n * (n - 1) / 2;

        System.out.println(Paircount);
        System.out.println(ops);
    }
}

