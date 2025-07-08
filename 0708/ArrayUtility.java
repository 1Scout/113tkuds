import java.util.Arrays;

public class ArrayUtility {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int left=0;
        int right=array.length-1;
        while (left<right) {
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int findSecondLargest(int[] array) {
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;

        for(int num:array) {
            if(num>max) {
                secondMax=max;
                max=num;
            }else if(num>secondMax&&num<max) {
                secondMax=num;
            }
        }

        return(secondMax==Integer.MIN_VALUE)?-1:secondMax;
    }

    public static void main(String[] args) {
        int[] numbers={3,7,1,9,4,6,8,2,5};

        System.out.println("原始陣列：");
        printArray(numbers);

        System.out.println("\n反轉陣列：");
        reverseArray(numbers);
        printArray(numbers);

        System.out.println("\n陣列副本：");
        int[] copied=copyArray(numbers);
        printArray(copied);

        System.out.println("\n第二大的數值：");
        int secondLargest=findSecondLargest(numbers);
        System.out.println(secondLargest);
    }
}
