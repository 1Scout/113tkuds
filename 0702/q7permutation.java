import java.util.Scanner;

public class q7permutation {
    static int ops = 0;
    public static void permute(int[] arr, int start) {
        if (start == arr.length) {
            
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            ops++;
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);                    
            permute(arr, start + 1);                 
            swap(arr, start, i);                     
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("輸入n值:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        permute(nums, 0);             
        System.out.println(ops);     
    }
}
