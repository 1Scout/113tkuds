public class ArrayStatistics {
    public static void main(String[] args) {
        int[] array={5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum=0;
        for(int value:array){
            sum+=value;
        }

        double average=(double)sum/array.length;
        int count=0;
        int evenCount = 0;
        int oddCount = 0;
        for(int value:array){
            if(value>average){
                count++;
            }
            if(value%2==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        int maxvalue=array[0];
        int minvalue=array[0];
        int maxIndex = 0;
        int minIndex = 0;
        int comparisons = 0;
        for (int i = 1; i <array.length; i++) {
            comparisons += 2;  
            
            if (array[i] > maxvalue) {
                maxvalue = array[i];
                maxIndex = i;                
            }
            
            if (array[i] < minvalue) {
                minvalue = array[i];
                minIndex = i;
            }
        }
        System.out.println("總和為:"+sum);
        System.out.printf("平均值:%.2f\n",average);
        System.out.printf("最大值：%d（位置：%d）\n", maxvalue, maxIndex);
        System.out.printf("最小值：%d（位置：%d）\n", minvalue, minIndex);
        System.out.println("有"+count+"個值超過平均");
        System.out.printf("偶數數量:%d\n",evenCount);
        System.out.printf("奇數數量:%d\n",oddCount);
    }
    
}
