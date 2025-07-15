import java.util.*;
public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("請輸入有幾個攤位:");
        int n=scanner.nextInt();

        List<Integer>idxList=new ArrayList<>();
        for(int i=0;i<n;i++) {
            System.out.println("請輸入攤位的成績:");
            double score=scanner.nextDouble();
            if(score==5.0) {
                idxList.add(i);
            }
        }

        if(idxList.isEmpty()){
            System.out.println("None");
        }else{
            for(int i:idxList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
