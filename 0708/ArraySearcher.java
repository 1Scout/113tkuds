public class ArraySearcher {
    public static int findElement(int[] array,int target) {
        for (int i=0;i<array.length;i++) {
            if (array[i]==target) {
                return i;
            }
        }
        return -1;
    }
    public static int countOccurrences(int[] array,int target) {
        int count = 0;
        for (int value:array) {
            if (value==target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers={12,45,23,67,34,89,56,78,91,25};

        int target1=67;
        int target2=100;

  
        int index1=findElement(numbers,target1);
        if (index1!=-1) {
            System.out.println(target1+"的索引是:"+index1);
        } else {
            System.out.println("找不到"+target1);
        }

        int index2=findElement(numbers,target2);
        if (index2!=-1) {
            System.out.println(target2+"的索引是:"+index2);
        } else {
            System.out.println("找不到"+target2);
        }

        System.out.println(target1+"出現次數:"+countOccurrences(numbers,target1));
        System.out.println(target2+"出現次數:"+countOccurrences(numbers,target2));
    }
}

