import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        Scanner scanner = new Scanner(System.in);

        System.out.print("輸入要搜尋的數字：");
        int target = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < s.length; i++) {
            System.out.println("尋找：" + target + " 在陣列中第 "+(i+1)+"個數字" + s[i]);
            if (s[i] == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("找到");
        } else {
            System.out.println("沒找到");
        }

        scanner.close();
    }
}
