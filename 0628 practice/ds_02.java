import java.util.Scanner;
public class ds_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("請輸入圓的半徑:");
        double num=scanner.nextDouble();

        double area=num*num*3.14;
        System.out.println("圓的面積是:"+area);
        scanner.close();
    }
}
