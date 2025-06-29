import java.util.Scanner;
public class ds_01{
    public static void main(String args[]){
         Scanner scanner=new Scanner(System.in);
    System.out.println("請輸入第一個整數:");
    int num1=scanner.nextInt();

    System.out.println("請輸入第二個整數:");
    int num2=scanner.nextInt();

    int num3=num1+num2;
    System.out.println("兩個整數的和是:"+num3);
    scanner.close();
    }
}