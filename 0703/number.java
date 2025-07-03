import java.util.Scanner;
public class number{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();

        for(int y=2;y<=x;y++){
            boolean check=true;

            for (int i=2;i<y;i++){
                if(y%i==0){
                    check=false;
                    break;
                }
            }
            if(check){
                System.out.printf(y+" ");
            }
        }
    }
}