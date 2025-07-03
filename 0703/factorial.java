import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int result = 1;

        for (int i = 2; i <= N; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}

