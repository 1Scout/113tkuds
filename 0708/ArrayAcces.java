public class ArrayAcces {
    public static void main(String[] args) {
        int[] scores={85,92,77,60,88};
        int firstscore=scores[0];
        int lastscore=scores[4];
        int middlescore=scores[2];

        System.out.println("第一個成績:"+firstscore);
        System.out.println("最後一個個成績:"+lastscore);
        System.out.println("中間成績:"+middlescore);

        scores[0]=90;
        scores[scores.length-1]=95;

        int arrayLength=scores.length;

        System.out.println("\n修改好的陣列:");
        for(int i=0;i<arrayLength;i++){
            System.out.printf("索引%d:%d\n",i,scores[i]);
        }
    }
}
