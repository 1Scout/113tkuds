public class isSorted {
    public static boolean isSorted(int[] arr, int index) {
        if(index>=arr.length-1) {
            return true;
    }
    
        if(arr[index]>arr[index + 1]) {
            return false;
        }
    
        return isSorted(arr,index + 1);
    }

    public static boolean isSorted(int[] arr) {
        if (arr==null||arr.length<=1) {
            return true;
        }
        return isSorted(arr,0);
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {1,3,2,4,5};
        System.out.println("array1:"+isSorted(array1));
        System.out.println("array2:"+isSorted(array2));
    }
}
