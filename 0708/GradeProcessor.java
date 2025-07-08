public class GradeProcessor {
    public static void main(String[] args) {
        int[] grades={78, 85, 92, 67, 88, 95, 73, 90};

        int sum=0;
        for(int grade:grades){
            sum+=grade;
        }
        System.out.println("總分為:"+sum);

        double average=(double)sum/grades.length;
        System.out.printf("平均成績:%.2f分\n",average);
        int stucount=0;
        for(int grade:grades){
            if(grade>average){
                stucount++;
            }
        }
        System.out.println("有"+stucount+"位學生的成績超過平均");
        int maxvalue=grades[0];
        int minvalue=grades[0];
        int maxIndex = 0;
        int minIndex = 0;
        int comparisons = 0;
        for (int i = 1; i < grades.length; i++) {
            comparisons += 2;  
            
            if (grades[i] > maxvalue) {
                maxvalue = grades[i];
                maxIndex = i;                
            }
            
            if (grades[i] < minvalue) {
                minvalue = grades[i];
                minIndex = i;
            }
        }
        System.out.printf("最大值：%d（位置：%d）\n", maxvalue, maxIndex);
        System.out.printf("最小值：%d（位置：%d）\n", minvalue, minIndex);
        for(int i=0;i<grades.length;i++){
            System.out.println("學生編號:"+i+",成績:"+grades[i]);
        }
    }
}
