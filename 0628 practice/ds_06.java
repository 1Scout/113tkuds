import java.util.*;
public class ds_06 {
    public static void main(String[] args) {
        int[] numbers=new int[10];
        Random ran=new Random();

        System.out.println("陣列內容為:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ran.nextInt(10) + 1;
            System.out.print(numbers[i] + " ");
        }
        int maxnum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxnum) {
                maxnum = numbers[i];
            }
        }
        System.out.println("陣列中的最大值是:" + maxnum);
    }
}
