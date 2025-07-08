public class StudentGradeSystem {
    public static void main(String[] args) {
        int[] grades={85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        int countA=0;
        int countB=0;
        int countC=0;
        int countD=0;
        int sum=0;
        double average=sum/grades.length;
        int overavg=0;
        double overavgrate=overavg/10;
        for (int grade:grades){
            if(grade>90){
                countA++;
            }else if(grade>80||grade<90){
                countB++;
            }else if(grade>70||grade<80){
                countC++;
            }else{
                countD++;
            }
            sum+=grade;
            if(grade>sum){
                overavg++;
            }
        }
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
        System.out.println("---學生成績報告---");
        System.out.println("統計摘要：");
        System.out.printf("A 等級人數：%d\n",countA);
        System.out.printf("B 等級人數：%d\n",countB);
        System.out.printf("C 等級人數：%d\n",countC);
        System.out.printf("D 等級人數：%d\n",countD);
        System.out.printf("最高分：%d （學生編號 %d）\n", maxvalue, maxIndex);
        System.out.printf("最低分：%d （學生編號 %d）\n", minvalue, minIndex);
        System.out.printf("全班平均分數：%.2f\n",average);
        System.out.printf("高於平均分數的學生比例：%.2f%%\n",overavgrate);
        System.out.println("學生詳細成績列表：");
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("第%d位學生：%d分\n",i + 1,grades[i]);
        }
        System.out.println("-------");
    }   
}
