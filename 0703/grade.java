import java.util.Scanner;
public class grade {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        if(x>90){
            System.out.print("A");
        }else if(x>80||x<90){
            System.out.print("B");
        }else if(x>70||x<80){
            System.out.print("C");
        }else if(x>60||x<70){
            System.out.print("D");
        }else{
            System.out.print("F");
        }
    }
}
