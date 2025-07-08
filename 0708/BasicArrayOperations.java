public class BasicArrayOperations {
    public static void main(String[] args) {
        int[] numbers={15, 28, 7, 42, 91, 33, 66, 58,24, 81};
        int arrayLength=numbers.length;
        System.out.println("陣列的長度為:"+arrayLength);
        numbers[2]=99;
        numbers[9]=100;
        System.out.println("\n修改好的陣列:");
        for(int i=0;i<arrayLength;i++){
            System.out.printf("索引%d:%d\n",i,numbers[i]);
        }
    }
}
