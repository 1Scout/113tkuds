public class ds_04 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("陣列中的元素有：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("第 " + (i + 1) + " 個元素是：" + numbers[i]);
        }
    }
}
